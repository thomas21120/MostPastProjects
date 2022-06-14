/**
 * Author: Lindley, Thomas
 * Date: 11/17/2020
 * Project: project 1 CMSC 330 Advanced Programming
 * Purpose: parse text files based on provided GUI language
 */
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GUIParse {
    private BufferedReader bRead;
    private ArrayList<String> tokens = new ArrayList<String>();
    private int currToken;
    private JFrame mFrame;
    private JComponent component;

    // Constructor for GUIParse
    public GUIParse() {
        JFileChoose();
        currToken = 0;
    }

    //JFileChooser to allow selection of file and then read it into a BufferedReader
    private void JFileChoose() {
        try {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                System.out.println(selectedFile.getAbsolutePath());
            } else {
                return;
            }
            bRead = new BufferedReader(new FileReader(jfc.getSelectedFile()));
            arrayInput();
            GUIParse();
        } catch (IOException e) {
            System.out.println("Failed to read chosen file!");
        }
    }

    private void arrayInput() {
        try {
            String line;
            String tokenString;
            for (line = bRead.readLine(); line != null; line = bRead.readLine()) {
                String lines = line.trim();
                String[] lineSplit = lines.split("(?<=[\"(),:;])|(?=[\"(),:;])| ");
                for (int i = 0; i < lineSplit.length; i++) {
                    tokenString = lineSplit[i].trim();
                    if (!tokenString.equals("")) {
                        tokens.add(tokenString);
                    }
                }
            }
            tokens.removeAll(Arrays.asList("", null));
            System.out.println(tokens);
        } catch (IOException e) {
            System.out.println("Unable to add tokens to queue for parsing.");
        }
    }

    private void GUIParse() {

        int width, height;
        String name = "";

        if (tokens.get(currToken).equalsIgnoreCase("Window")) {
            currToken += 2;
            name = tokens.get(currToken);
            while(!tokens.get(++currToken).equalsIgnoreCase("\"")){
                name += " " + tokens.get(currToken);
            }
            mFrame = new JFrame(name);
            currToken += 1;
            mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mFrame.setVisible(true);
            if (tokens.get(currToken).equals("(")) {
                try {
                    currToken++;
                    width = Integer.parseInt(tokens.get(currToken));
                    currToken += 2;
                    height = Integer.parseInt(tokens.get(currToken));
                    currToken += 2;
                    mFrame.setSize(width, height);
                } catch (NumberFormatException e) {
                    System.out.println("Improper syntax window size definition.");
                }
            }
            if (tokens.get(currToken).equalsIgnoreCase("Layout")) {
                currToken++;
                if (tokens.get(currToken).equalsIgnoreCase("Flow")) {
                    mFrame.setLayout(new FlowLayout());
                    currToken += 2;
                } else if (tokens.get(currToken).equalsIgnoreCase("Grid")) {
                    int row = Integer.parseInt(tokens.get(currToken += 2));
                    int columns = Integer.parseInt(tokens.get(currToken += 2));
                    if (tokens.get(++currToken).equals(")")) {
                        mFrame.setLayout(new GridLayout(row, columns));
                        currToken += 2;
                    } else if (tokens.get(currToken).equalsIgnoreCase(",")) {
                        int hGap = Integer.parseInt(tokens.get(++currToken));
                        int vGap = Integer.parseInt(tokens.get(currToken += 2));
                        mFrame.setLayout(new GridLayout(row, columns, hGap, vGap));
                        currToken += 3;
                    }
                }
            }
        }
        while (!tokens.get(currToken).equalsIgnoreCase("End.")) {
            if(tokens.get(currToken).equalsIgnoreCase("Group")){
                currToken++;
                ButtonGroup radios = new ButtonGroup();
                while (!tokens.get(currToken).equalsIgnoreCase("End")) {
                    JRadioButton c = radioWidget();
                    mFrame.add(c);
                    radios.add(c);
                }
                currToken+=2;
            }else{
                mFrame.add(widgets());
            }
        }
    }

    private JComponent widgets() {
        if (tokens.get(currToken).equalsIgnoreCase("Button")) {
            component = buttonWidget();
        } else if (tokens.get(currToken).equalsIgnoreCase("Label")) {
            component = labelWidget();
        } else if (tokens.get(currToken).equalsIgnoreCase("Panel")) {
            component = panelWidget();
        } else if (tokens.get(currToken).equalsIgnoreCase("TextField")) {
            component = textFieldWidget();
        }
        return component;
    }

    private JButton buttonWidget() {
        String fullName = "";
        JButton button = new JButton();
        button.setVisible(true);
        currToken ++;
        if (tokens.get(++currToken).equalsIgnoreCase("\"")) {
            button.setText(" ");
            currToken += 2;
            return button;
        } else {
            fullName = tokens.get(currToken);
            while (!tokens.get(++currToken).equalsIgnoreCase("\"")) {
                fullName += " " + tokens.get(currToken);
            }
            currToken += 2;
            button.setText(fullName);
            return button;
        }
    }

    private JRadioButton radioWidget() {
        String fullName = "";
        if (!tokens.get(currToken).equalsIgnoreCase("Radio")) {
            System.out.println("Syntax error in radio group creation.");
        }
        currToken += 2;
        if (tokens.get(currToken).equalsIgnoreCase("\"")) {
            currToken += 2;
            return new JRadioButton();
        }
        fullName = tokens.get(currToken);
        while (!tokens.get(++currToken).equalsIgnoreCase("\"")) {
            fullName += " " + tokens.get(currToken);
        }
        currToken += 2;
        return new JRadioButton(fullName);
    }

    private JLabel labelWidget() {
        String fullName = "";
        JLabel label = new JLabel();
        label.setVisible(true);
        currToken += 2;
        if (tokens.get(currToken).equalsIgnoreCase("\"")) {
            label.setText(" ");
            currToken += 2;
            return label;
        } else {
            fullName = tokens.get(currToken);
            while (!tokens.get(++currToken).equalsIgnoreCase("\"")) {
                fullName += " " + tokens.get(currToken);
            }
            currToken += 2;
            label.setText(fullName);
            return label;
        }
    }

    private JPanel panelWidget() {
        JPanel panel = new JPanel();
        currToken++;
        panel = panelLayout(panel);
        panel.setVisible(true);
        while (!tokens.get(currToken).equalsIgnoreCase("End")) {
            if(tokens.get(currToken).equalsIgnoreCase("Group")){
                currToken++;
                ButtonGroup radios = new ButtonGroup();
                while (!tokens.get(currToken).equalsIgnoreCase("End")) {
                    JRadioButton c = radioWidget();
                    panel.add(c);
                    radios.add(c);
                }
                currToken+=2;
            }else{
                panel.add(widgets());
            }
        }
        currToken += 2;
        return panel;
    }

    private JTextField textFieldWidget() {
        int size = Integer.parseInt(tokens.get(++currToken));
        JTextField textF = new JTextField("", size);
        textF.setVisible(true);
        currToken+= 2;
        return textF;
    }

    private JPanel panelLayout(JPanel p) {
        JPanel formatPanel = p;
        if (tokens.get(currToken).equalsIgnoreCase("Layout")) {
            currToken++;
            if (tokens.get(currToken).equalsIgnoreCase("Flow")) {
                formatPanel.setLayout(new FlowLayout());
                formatPanel.revalidate();
                formatPanel.repaint();
            } else if (tokens.get(currToken).equalsIgnoreCase("Grid")) {
                int row = Integer.parseInt(tokens.get(currToken += 2));
                int columns = Integer.parseInt(tokens.get(currToken += 2));
                if (tokens.get(++currToken).equals(")")) {
                    formatPanel.setLayout(new GridLayout(row, columns));
                    currToken += 2;
                } else if (tokens.get(currToken).equalsIgnoreCase(",")) {
                    int hGap = Integer.parseInt(tokens.get(++currToken));
                    int vGap = Integer.parseInt(tokens.get(currToken += 2));
                    formatPanel.setLayout(new GridLayout(row, columns, hGap, vGap));
                    currToken += 3;
                    System.out.println(tokens.get(currToken));
                }
            } else {
                System.out.println("Improper Layout Syntax in panel creation");
            }
        }
        return formatPanel;
    }
}

/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 1
 * Date: 08/30/2020
 * Class Description: This class contains all necessary code to create a GUI for expression conversion. It includes
 * action listeners to preform conversions by passing a string containing user input when buttons are pressed. One
 * button will convert Prefix to post and the other will do the opposite. Both action listeners contain try and catch
 * statements to handle SyntaxError that is thrown by the ExpressionConverter class.
 */

import javax.swing.*;
import java.awt.*;

public class ConvertGUI extends JFrame {
    //Create all buttons, text fields and labels
    JLabel inputLabel = new JLabel("Enter Expression");
    JTextField input = new JTextField(25);
    JButton preToPost = new JButton("Prefix to Postfix");
    JButton postToPre = new JButton("Postfix to Prefix");
    JLabel resultLabel = new JLabel("Result");
    JTextField result = new JTextField(25);

    private ConvertGUI() {
        //Create frame
        super("Expression Converter");
        setSize(500, 150);
        setResizable(false);
        result.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the layout and pass all components needed by GUI to MakeFlowPanel method
        setLayout(new GridLayout(3, 1, 10, 0));

        JComponent[] inputComponents = {inputLabel, input};
        makeFlowPanel(inputComponents);

        JComponent[] buttonsComponents = {preToPost, postToPre};
        makeFlowPanel(buttonsComponents);

        JComponent[] outputComponents = {resultLabel, result};
        makeFlowPanel(outputComponents);

        //Action listeners for prefix to postfix button and postfix to prefix, when pressed action listener try's to pass
        //string from text field into evalPrePost to convert, if SyntaxError is thrown, caught here and error pop up shows
        preToPost.addActionListener(e -> {
            result.setText(" ");
            String t = input.getText();
            try {
                result.setText(ExpressionConvert.evalPrePost(t));
            } catch (SyntaxError s) {
                JOptionPane optionPane = new JOptionPane("Failure to run due to syntax error.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Syntax Error");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                setResizable(false);
                result.setText("Check Syntax!");
            }
        });
        postToPre.addActionListener(e -> {
            result.setText(" ");
            String s = input.getText();
            try {
                result.setText(ExpressionConvert.evalPostPre(s));
            } catch (SyntaxError t) {
                JOptionPane optionPane = new JOptionPane("Failure to run due to syntax error.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Syntax Error");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                result.setText("Check Syntax!");
            }
        });
    }
    //Makes the panel containing all the components passed into it as arguments
    private void makeFlowPanel(JComponent[] components) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        for (Component component : components)
            panel.add(component);
        add(panel);
    }

    //Creates the frame and makes it visible
    public static void main(String[] args) {
        ConvertGUI frame = new ConvertGUI();
        frame.setVisible(true);
    }
}


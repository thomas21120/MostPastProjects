import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            try {
                Scanner scannerIn = new Scanner(selectedFile);
                while (scannerIn.hasNextLine()){
                    String input = scannerIn.nextLine();
                    Polynomial a = new Polynomial(input);
                    System.out.println (input);
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found.");
            }
        }

        ArrayList polyList = new ArrayList(100);

    }
}



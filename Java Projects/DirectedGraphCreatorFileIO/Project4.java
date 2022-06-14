/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 4
 * Date: 10/13/2020
 * Class Description: This class scans in .tct files for processing into graphs and also calls string method to print a
 * string representation of the graph. Also calls Parenthesiszedlist and Hierarchy, if these classes where complete,
 * I believe we would just pass in the created Directed graph object for processing into each type of output to be printed
 * to the console.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Project4 {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            Scanner scan = new Scanner(selectedFile);
            DirectedGraph<Object> a = new DirectedGraph<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] vert = line.split(" ");
                for(int i = 1; i < vert.length; i++) {
                    a.addEdge(vert[0], vert[i]);
                }
            }
            a.cycleDetected();
            a.string();
            ParenthesizedList b = new ParenthesizedList();
            Hierarchy c = new Hierarchy();
        }
    }
}

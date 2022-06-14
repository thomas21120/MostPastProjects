/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 3
 * Date: 09/29/2020
 * Class Description: This class provide the error checking functionality to the program. caught in gui.java and thrown during the creation
 * of the binary tree.
 */

import javax.swing.*;

public class InvalidTreeSyntax extends Exception{
    public InvalidTreeSyntax(String message) {
        super(message);
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Error");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}

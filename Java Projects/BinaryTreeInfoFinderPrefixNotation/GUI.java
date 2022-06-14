/*
 * Author: Thomas, Lindley
 * Project: CMSC 350 Project 3
 * Date: 09/29/2020
 * Class Description: This class creates the gui and contains the action listners that call methods on the object created
 * here.
 */

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    BinaryTree a;
    //Create all buttons, text fields and labels
    JLabel inputLabel = new JLabel("Enter Tree:");
    JTextField input = new JTextField(25);
    JButton MakeTree = new JButton("Make Tree");
    JButton IsBalanced = new JButton("Is Balanced?");
    JButton IsFull = new JButton("Is Full?");
    JButton IsProper = new JButton("Is Proper?");
    JButton Height = new JButton("Height");
    JButton Nodes = new JButton("Nodes");
    JButton InOrder = new JButton("In Order");
    JLabel OutPutLabel = new JLabel("Output:");
    JTextField Output = new JTextField(25);

    private GUI() {
        //Create frame
        super("Expression Converter");
        setSize(700, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        Output.setEditable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the layout and pass all components needed by GUI to MakeFlowPanel method
        setLayout(new GridLayout(3, 1, 10, 0));

        JComponent[] inputComponents = {inputLabel, input};
        makeFlowPanel(inputComponents);

        JComponent[] buttonsComponents = {MakeTree, IsBalanced, IsFull, IsProper, Height, Nodes, InOrder};
        makeFlowPanel(buttonsComponents);

        JComponent[] outputComponents = {OutPutLabel, Output};
        makeFlowPanel(outputComponents);

        //Action listeners for prefix to postfix button and postfix to prefix, when pressed action listener try's to pass
        //string from text field into evalPrePost to convert, if SyntaxError is thrown, caught here and error pop up shows
        MakeTree.addActionListener(e -> {
            String inputs = input.getText();
            try {
                a = new BinaryTree(inputs);
            } catch (InvalidTreeSyntax invalidTreeSyntax) {
                invalidTreeSyntax.printStackTrace();
            }
            Output.setText("  ");
        });
        IsBalanced.addActionListener(e -> {
            Output.setText(Boolean.toString(this.a.balanced()));
        });
        IsFull.addActionListener(e -> {
            Output.setText(Boolean.toString(this.a.full()));
        });
        IsProper.addActionListener(e -> {
            Output.setText(Boolean.toString(this.a.proper()));
        });
        Height.addActionListener(e -> {
            Output.setText(Integer.toString(this.a.height()));
        });
        Nodes.addActionListener(e -> {
            Output.setText(Integer.toString(this.a.nodes()));
        });
        InOrder.addActionListener(e -> {
            Output.setText(this.a.inOrder());
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
        GUI frame = new GUI();
        frame.setVisible(true);
    }
}
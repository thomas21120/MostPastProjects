/*
Author: Thomas Lindley
Date: 12 SEP 2021
Assignment: Project 2
Course: CMSC 335 - Object-Oriented and Concurrent Programming
Purpose: Program that allows user to create a number of shape objects and shows the
          objects area or volume graphically through a GUI.
Assumptions: User wants to create one of nine shapes and knows the required       
              dimensions. User selects from menus to create shape and get volume or area with numerical input.
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.GridLayout;
import java.text.DecimalFormat;

public class main_SWING extends JFrame {
  // first row
  private JLabel selectShapeLB = new JLabel("Select A Shape");
  private JLabel inv0x1LB = new JLabel();
  private JLabel enterParam1LB = new JLabel();
  private JTextField enterParam1TF = new JTextField();

  // second row
  private JComboBox<String> selectShapeJCB = new JComboBox<String>();
  private JButton selectShapeBTN = new JButton("Select Shape");
  private JLabel enterParam2LB = new JLabel();
  private JTextField enterParam2TF = new JTextField();

  // third row
  private JLabel inv3x0LB = new JLabel();
  private JLabel inv3x1LB = new JLabel();
  private JLabel inv3x2LB = new JLabel();
  private JButton displayShapeBTN = new JButton("Display Shape");

  // fourth row
  private JLabel inv4x0LB = new JLabel();
  private JLabel inv4x1LB = new JLabel();
  private JLabel inv4x2LB = new JLabel();
  private JLabel areaOrVolumeLB = new JLabel();

  // fifth row
  private JButton clearBTN = new JButton("Clear");
  private JLabel inv5x1LB = new JLabel();
  private JLabel inv5x2LB = new JLabel();
  private JTextField areaOrVolumeTF = new JTextField();  

  private String shape;
  DecimalFormat df = new DecimalFormat("0.00");
  DecimalFormat sciDf = new DecimalFormat("0.######E0");

  public main_SWING(){
    setLayout(new GridLayout(0, 4, 5, 5));

    // first row
    add(selectShapeLB);
    add(inv0x1LB);
    add(inv3x2LB);
    add(inv5x2LB);

    // second row
    selectShapeJCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
        { "Circle", "Triangle", "Rectangle", "Square", "Cube", "Cone", "Cylinder", "Sphere", "Torus"}));
    add(selectShapeJCB);
    add(selectShapeBTN);
    add(enterParam1LB);
    add(enterParam1TF);

    // third row
    add(inv3x0LB);
    add(inv3x1LB);
    add(enterParam2LB);
    add(enterParam2TF);

    // fourth row
    add(inv4x0LB);
    add(inv4x1LB);
    add(inv4x2LB);
    add(displayShapeBTN);

    // fifth row
    add(clearBTN);
    add(inv5x1LB);
    add(areaOrVolumeLB);
    add(areaOrVolumeTF);
    
    // make sure parameter fields are not visible until shape selected
    enterParam2TF.setVisible(false);
    enterParam1TF.setVisible(false);

    pack();

    // action listener for button select shape
    selectShapeBTN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        selectShapeBTNActionPerformed(evt);
      }
    });

    // action listener for display shape button
    displayShapeBTN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        displayShapeBTNActionPerformed(evt);
      }
    });

    // action listener for clear button
    clearBTN.addActionListener(new java.awt.event.ActionListener(){
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        clearBTNActionPerformed(evt);
      }
    });
  }

  public static void main (String [] args){
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd, HH:mm");
    JFrame frame = new main_SWING();
    // set title of frame with time
    frame.setTitle("Shapes GUI                      " + date.format(dateFormat));
    frame.setLocationRelativeTo(null);
    frame.setSize(700,300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  // action for select shape button
  private void selectShapeBTNActionPerformed(java.awt.event.ActionEvent evt){
    shape = String.valueOf(selectShapeJCB.getSelectedItem());
    // switch between selected shapes, clear previous GUI and set appropriate text fields visible
    switch(shape){
      case "Circle":
        clearGUI();
        enterParam1LB.setText("Enter Radius:");
        enterParam1TF.setVisible(true);
        break;

      case "Triangle":
        clearGUI();
        enterParam1LB.setText("Enter Base:");
        enterParam1TF.setVisible(true);
        enterParam2LB.setText("Enter Height:");
        enterParam2TF.setVisible(true);
        break;

      case "Rectangle":
        clearGUI();
        enterParam1LB.setText("Enter Length:");
        enterParam1TF.setVisible(true);
        enterParam2LB.setText("Enter Width:");
        enterParam2TF.setVisible(true);
        break;

      case "Square":
        clearGUI();
        enterParam1LB.setText("Enter Edge:");
        enterParam1TF.setVisible(true);
        break;

      case "Cube":
        clearGUI();
        enterParam1LB.setText("Enter Edge:");
        enterParam1TF.setVisible(true);
        break;

      case "Cone":
        clearGUI();
        enterParam1LB.setText("Enter Radius:");
        enterParam1TF.setVisible(true);
        enterParam2LB.setText("Enter Height:");
        enterParam2TF.setVisible(true);
        break;

      case "Cylinder":
        clearGUI();
        enterParam1LB.setText("Enter Radius:");
        enterParam1TF.setVisible(true);
        enterParam2LB.setText("Enter Height:");
        enterParam2TF.setVisible(true);
        break;

      case "Sphere":
        clearGUI();
        enterParam1LB.setText("Enter Radius:");
        enterParam1TF.setVisible(true);
        break;

      case "Torus":
        clearGUI();
        enterParam1LB.setText("Enter Major Radius:");
        enterParam1TF.setVisible(true);
        enterParam2LB.setText("Enter Minor Radius:");
        enterParam2TF.setVisible(true);
        break;
    }
  }

  // make new frame for shape display, done here so clear button can close it
  JFrame frame2 = new JFrame(shape);

  // display shape action 
  private void displayShapeBTNActionPerformed(java.awt.event.ActionEvent evt){
    double side1, side2, radius1, radius2, output;
    // variable that prevents frame2 from displaying if error occurred, otherwise user has to close it
    // when improper input is used
    boolean error = false;
    // try/catch to catch NumberFormatException, happens when user enters non numerical data
    try{
      // switch between shapes, each shape clears frame2 to prevent old images from displaying
      // each shape gets user input parses it to double, gets the area/volume, and displays an image
      switch(shape){
        case "Circle":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          radius1 = Double.parseDouble(enterParam1TF.getText());
          if(radius1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Area:");
          // change output format to scientific notation if number is large or really small 
          output = Create.getAreaOfCircle(radius1);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new DrawCircle(radius1));
          break;

        case "Triangle":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          // base
          side1 = Double.parseDouble(enterParam1TF.getText());
          // height
          side2 = Double.parseDouble(enterParam2TF.getText());
          if(side1 < 0 || side2 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Area:");

          output = Create.getAreaOfTriangle(side1, side2);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new DrawTriangle((side1), (side2)));
          break;

        case "Rectangle":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          // length
          side1 = Double.parseDouble(enterParam1TF.getText());
          // width
          side2 = Double.parseDouble(enterParam2TF.getText());
          if(side1 < 0 || side2 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Area:");

          output = Create.getAreaOfRectangle(side1, side2);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new DrawRectangle((side1), (side2)));
          break;

        case "Square":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          side1 = Double.parseDouble(enterParam1TF.getText());
          if(side1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Area:");

          output = Create.getAreaOfSquare(side1);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new DrawSquare(side1));
          break;

        case "Cube":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          side1 = Double.parseDouble(enterParam1TF.getText());
          if(side1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Volume:");
          output = Create.getVolumeOfCube(side1);

          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new JLabel(new ImageIcon("Cube.jpg")));
          break;

        case "Cone":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          radius1 = Double.parseDouble(enterParam1TF.getText());
          // height
          side1 = Double.parseDouble(enterParam2TF.getText());
          if(side1 < 0 || radius1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Volume:");

          output = Create.getVolumeOfCone(radius1, side1);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new JLabel(new ImageIcon("Cone.jpg")));
          break;

        case "Cylinder":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          radius1 = Double.parseDouble(enterParam1TF.getText());
          // height
          side1 = Double.parseDouble(enterParam2TF.getText());
          if(side1 < 0 || radius1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Volume:");

          output = Create.getVolumeOfCylinder(radius1, side1);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new JLabel(new ImageIcon("Cylinder.jpg")));
          break;

        case "Sphere":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          radius1 = Double.parseDouble(enterParam1TF.getText());
          if(radius1 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Volume:");

          output = Create.getVolumeOfSphere(radius1);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new JLabel(new ImageIcon("Sphere.jpg")));
          break;

        case "Torus":
          frame2.getContentPane().removeAll();
          frame2.repaint();
          // Major Radius
          radius1 = Double.parseDouble(enterParam1TF.getText());
          // Minor Radius
          radius2 = Double.parseDouble(enterParam2TF.getText());
          if(radius1 < 0 || radius2 < 0) throw new NumberFormatException();
          areaOrVolumeLB.setText("Volume:");

          output = Create.getVolumeOfTorus(radius1, radius2);
          if((output>10000)||(output< 0.01)){
            areaOrVolumeTF.setText(sciDf.format(output));
          }else{
            areaOrVolumeTF.setText(df.format(output));
          }

          frame2.add(new JLabel(new ImageIcon("Torus.jpg")));
          break;
      }
      // set error to false so frame will become visible if no errors
      error = false;
    }catch(NumberFormatException e){
      // if error occurs clear everything, display message, and set error to true so frame2 does not display
      clearGUI();
      error = true;
      JOptionPane.showMessageDialog(null, "Dimensions must be decimal non-negative numbers!");
    }

    frame2.setLocationRelativeTo(null);
    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame2.pack();

    // check if error occurred and set visible accordingly 
    if(!error){
      frame2.setVisible(true);
    }else{
      frame2.setVisible(false);
    }
  }

  // clear button action, clear gui and get rid of frame2
  private void clearBTNActionPerformed(java.awt.event.ActionEvent evt){
    clearGUI();
    frame2.dispose();
  }

  // reset all fields and make text fields invisible
  private void clearGUI() {
    enterParam1LB.setText("");
    enterParam1TF.setText("");
    enterParam2LB.setText("");
    enterParam2TF.setText("");  
    areaOrVolumeLB.setText("");
    areaOrVolumeTF.setText("");
    areaOrVolumeLB.setText("");
    areaOrVolumeTF.setText("");        
    enterParam1TF.setVisible(false);
    enterParam2TF.setVisible(false);
  }
}


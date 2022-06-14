/*
Author: Thomas Lindley
Date: 26 AUG 2021
Assignment: Project 1
Course: CMSC 335 - Object-Oriented and Concurrent Programming
Purpose: Program that allows user to create a number of shape objects and shows the
          objects area or volume. Demonstrates inheritance in Java.
Assumptions: User wants to create one of nine shapes and knows the required       
              dimensions. User selects from menus with either numerical input or Y/N.
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Main{
  public static void main (String [] args){
    LocalDateTime date = LocalDateTime.now();
    // initialize a scanner for user inputs
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    Scanner myScanner = new Scanner(System.in);
    int selection;
    // variable state is used to break main menu while loop when user wants to quit
    boolean state = false;

    System.out.println("****Welcome to JAVA shapes Program****");

    // main driving loop, breaks when state = false
    while(true){
      System.out.println("""
              \nSelect from the menu below:\s
              1. Construct a Circle\s
              2. Construct a Rectangle\s
              3. Construct a Square\s
              4. Construct a Triangle\s
              5. Construct a Sphere\s
              6. Construct a Cube\s
              7. Construct a Cone\s
              8. Construct a Cylinder\s
              9. Construct a Torus\s
              10. Exit the program""");
      String userIn = myScanner.nextLine();
      // try/catch to check if user made valid choice
      try{
        selection = Integer.parseInt(userIn);
        if(selection <=0 || selection >10){
          throw new Exception();
        }
      }catch(Exception e){
        System.out.println("Incorrect input, please make an integer input from 1 to 10.");
        continue;
      }
      // break main while loop if user enters 10
      if(selection == 10){
        break;
      }
      // switch to choose correct method that asks for measurements of shape
      // also passes myScanner, so each method does not have to make a new scanner
      switch (selection) {
        case 1 -> createCircle(myScanner);
        case 2 -> createRectangle(myScanner);
        case 3 -> createSquare(myScanner);
        case 4 -> createTriangle(myScanner);
        case 5 -> createSphere(myScanner);
        case 6 -> createCube(myScanner);
        case 7 -> createCone(myScanner);
        case 8 -> createCylinder(myScanner);
        case 9 -> createTorus(myScanner);
      }

      // ask if user wants to continue after object creation and info display done
      while(true){
        System.out.println("Would you like to continue Y/N? ");
        String continueOp = myScanner.nextLine().toUpperCase();
        if(continueOp.equals("Y")){
          break;
        }else if(continueOp.equals("N")){
          state = true;
          break;
        }else {
          System.out.println("Please enter y or n ");
        }
      }
      // break from main driving while loop if user does not want to continue at
      // this point, when state is true
      if(state){
        break;
      }
    }
    System.out.println("\nThanks for using the program. Today is: " + date.format(dateFormat) +
                          " at " + date.format(timeFormat));
    // close the scanner and exit the program.
    myScanner.close();
    System.exit(0);
  }

  // method that takes in a scanner, gets user input and creates circle object using 
  // circle class 
  static void createCircle(Scanner scan){
    double radiusCi;
    System.out.println("\nYou have selected a Circle");
    // get user input, keep asking until valid entry
    while(true){
      System.out.println("What is the radius?");
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        radiusCi = Double.parseDouble(scan.nextLine());
        // pass user input to invalidMeasure to insure its greater than zero and //
        // throw exception if not
        if(invalidMeasure(radiusCi)) throw new Exception();
        break;
      } catch (Exception e) {
          // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Circle aCircle = new Circle(radiusCi);
    System.out.println("\nThe area of the Circle is: " + aCircle.getArea() + "\n");
  }

  // method that takes in a scanner, gets user input and creates Rectangle object 
  // using rectangle class.
  static void createRectangle(Scanner scan){
    double length, width;
    System.out.println("\nYou have selected a Rectangle");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the length?");
        length = Double.parseDouble(scan.nextLine());
        System.out.println("What is the width?");
        width = Double.parseDouble(scan.nextLine());
        if(invalidMeasure(length, width)) throw new Exception();
        // pass user input to invalidMeasure to insure its greater than zero and //
        // throw exception if not
        break;
      } catch (Exception e) {
          // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Rectangle aRectangle = new Rectangle(length, width);
    System.out.println("The area of the Rectangle is: " + aRectangle.getArea() + "\nThis rectangle is also " + 
    aRectangle.isSquare() + " a square." + "\n");
  }

  // method that takes in a scanner, gets user input and creates square object using 
  // square class 
  static void createSquare(Scanner scan){
    double edgeS;
    System.out.println("\nYou have selected a Square");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the length of one edge?");
        edgeS = Double.parseDouble(scan.nextLine());
        // pass user input to invalidMeasure to insure its greater than zero and //
        // throw exception if not
        if(invalidMeasure(edgeS)) throw new Exception();
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
        invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Square aSquare = new Square(edgeS);
    System.out.println("\nThe area of the Square is: " + aSquare.getArea() + "\n");
  }

  // method that takes in a scanner, gets user input and creates triangle object 
  // using triangle class 
  static void createTriangle(Scanner scan){
    double base, height, largestAngel, sideLeft, sideRight;
    System.out.println("\nYou have selected a Triangle");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the base?");
        base = Double.parseDouble(scan.nextLine());
        System.out.println("\nWhat is the height (from center of base)?");
        height = Double.parseDouble(scan.nextLine());
        System.out.println("\nWhat is the largest angle?");
        largestAngel = Double.parseDouble(scan.nextLine());
        System.out.println("\nIf one of the sides is the same as the height, re-enter please!");
        System.out.println("What is the the length of side to the left of the base?");
        sideLeft = Double.parseDouble(scan.nextLine());
        System.out.println("\nWhat is the the length of side to the right of the base?");
        sideRight = Double.parseDouble(scan.nextLine());
        if(invalidMeasure(base, height, largestAngel, sideLeft, sideRight)) throw new Exception();
        // pass user input to invalidMeasure to insure its greater than zero and //
        // throw exception if not
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Triangle aTriangle = new Triangle(base, height, largestAngel, sideLeft, sideRight);
    System.out.println("\nThe area of the Triangle is: " + aTriangle.getArea() + "\n" +
            "\nThe type of triangle based on its angles is:\n" + aTriangle.typeOfTriangleByAngle() +
            "\n" + "\nThe type of triangle based on its sides is:\n" + aTriangle.typeOfTriangleBySides() + "\n");
  }

  // method that takes in a scanner, gets user input and creates sphere object 
  // using sphere class 
  static void createSphere(Scanner scan){
    double radiusS;
    System.out.println("\nYou have selected a Sphere");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the radius?");
        radiusS = Double.parseDouble(scan.nextLine());
        // pass user input to invalidMeasure to insure its greater than zero and
        // throw exception if not
        if(invalidMeasure(radiusS)) throw new Exception();
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Sphere aSphere = new Sphere(radiusS);
    System.out.println("\nThe volume of the Sphere is: " + aSphere.getVolume() + "\n");
  }

  // method that takes in a scanner, gets user input and creates cube object 
  // using cube class 
  static void createCube(Scanner scan){
    double edgeC;
    System.out.println("\nYou have selected a Cube");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the length of one edge?");
        edgeC = Double.parseDouble(scan.nextLine());
        // pass user input to invalidMeasure to insure its greater than zero and
        // throw exception if not
        if(invalidMeasure(edgeC)) throw new Exception();
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Cube aCube = new Cube(edgeC);
    System.out.println("\nThe volume of the Cube is: " + aCube.getVolume() + "\n");
  }

  // method that takes in a scanner, gets user input and creates cone object 
  // using cone class 
  static void createCone(Scanner scan){
    double radiusC, heightC;
    System.out.println("\nYou have selected a Cone");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the radius?");
        radiusC = Double.parseDouble(scan.nextLine());
        System.out.println("What is the height?");
        heightC = Double.parseDouble(scan.nextLine());
        if(invalidMeasure(radiusC, heightC)) throw new Exception();
        // pass user input to invalidMeasure to insure its greater than zero and
        // throw exception if not
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Cone aCone = new Cone(radiusC, heightC);
    System.out.println("\nThe volume of the cone is: " + aCone.getVolume() + "\n");
  }

  // method that takes in a scanner, gets user input and creates Cylinder object 
  // using cylinder class 
  static void createCylinder(Scanner scan){
    double radiusCy, heightCy;
    System.out.println("\nYou have selected a Cylinder");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the radius?");
        radiusCy = Double.parseDouble(scan.nextLine());
        System.out.println("What is the height?");
        heightCy = Double.parseDouble(scan.nextLine());
        if(invalidMeasure(radiusCy, heightCy)) throw new Exception();
        // pass user input to invalidMeasure to insure its greater than zero and
        // throw exception if not
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Cylinder aCylinder = new Cylinder(radiusCy, heightCy);
    System.out.println("\nThe volume of the Cylinder is: " + aCylinder.getVolume() + "\n");
  }

  // method that takes in a scanner, gets user input and creates torus object 
  // using torus class 
  static void createTorus(Scanner scan){
    double radiusMajor, radiusMinor;
    System.out.println("\nYou have selected a Torus");
    // get user input, keep asking until valid entry 
    while(true){
      // try/catch will handle exception occurring when parse to double, happens 
      // when input not a number 
      try {
        System.out.println("What is the major radius?");
        radiusMajor = Double.parseDouble(scan.nextLine());
        System.out.println("What is the minor radius?");
        radiusMinor = Double.parseDouble(scan.nextLine());
        if(invalidMeasure(radiusMajor, radiusMinor)) throw new Exception();
        // pass user input to invalidMeasure to insure its greater than zero and
        // throw exception if not
        break;
      } catch (Exception e) {
        // if exception occurs call invalidInput which displays error message
          invalidInput();
      }
    }
    // once all inputs are acceptable create object and output its info
    Torus aTorus = new Torus(radiusMajor, radiusMinor);
    System.out.println("\nThe volume of the Torus is: " + aTorus.getVolume() + "\n");
  }

  // Method that prints to the terminal error message when called
  static void invalidInput(){
    System.out.println("Incorrect input, please enter positive numerical " +
            "data only (int or float), measurement can not be zero!");
  }

  // method that insures all inputs for creating shapes are greater than zero,
  // uses vargas and enhanced for to take any number of inputs in and check them
  static boolean invalidMeasure(double... inputs){
    boolean invalid = false;
    for (double i: inputs ){
      if (i <= 0.0) invalid = true;
    }
    return invalid;
  }
}
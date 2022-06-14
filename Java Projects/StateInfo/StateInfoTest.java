/*
 * Author: Lindley, Thomas
 * File: StateInfoTest.java
 * Date: 4/30/2020
 * Purpose: Creates StateInfo objects based on user inputs and outputs their info and a summary of choices
 */

package stateinfo;

import java.util.Scanner;

public class StateInfoTest {
    public static void main(String[] args) {
        // Initialize variables
        String choice = "";
        int stateChoice = 0;
        String stateSummary = "";

        // Greet user and prompt for input
        System.out.println("Hello, Please enter which state you would like to have info on or none to exit.");
        System.out.println("Your current choices are Virginia, South Carolina and Florida.");
        System.out.println("If nothing is entered program will default to my home state of Virginia's info.");

        // Get user inputs through while loop so it runs until they enter none
        while (true) {
            // Scan for user input
            Scanner scannerIn = new Scanner(System.in);
            // Change user inputs to be uppercase and remove spaces to allow program to accept different user inputs without issue
            choice = scannerIn.nextLine().toUpperCase().replace(" ", "");
            // break form infinite while loop if user enters none
            if ("NONE".equals(choice)) {
                break;
            }
            // Switch user inputs to integers to pass into state choice constructor
            switch (choice) {
                case "VIRGINIA":
                    stateChoice = 0;
                    break;
                case "SOUTHCAROLINA":
                    stateChoice = 1;
                    break;
                case "FLORIDA":
                    stateChoice = 2;
                    break;
            }
            // Pass into constructor, to create new StateInfo objects
            StateInfo y1 = new StateInfo(stateChoice);
            System.out.println("--------------------------------------------------------");
            // use getStateInfo method to get state info
            y1.getStateInfo();
            System.out.println("--------------------------------------------------------");
            System.out.println(" ");
            System.out.println("Please enter another state from the list of possible choices or none to print summary and exit:");
            // use getStateSummary method to add to stateSummary strings of each choice formatted differently
            stateSummary += y1.getStateSummary() + "\n";
        }

        // Print Summary
        System.out.println("------Thank You.-------");
        System.out.println("A summary report for each State, Bird, and Flower is:");
        System.out.println(stateSummary);
    }
}

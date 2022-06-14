/*
 * Author: Lindley, Thomas
 * File: StateInfo.java
 * Date: 4/30/2020
 * Purpose: Provides constructor and methods to StateInfoRun allowing creation of StateInfo objects and methods
 * to get state info and a summary
 */
package stateinfo;

public class StateInfo {
    // Initialize variables
    private int stateIn;
    private String state;
    private String bird;
    private String flower;

    // Constructor
    public StateInfo(int stateChoice){
        stateIn = stateChoice;
        // switch to take user input that was switched to integer, to populate each object with information
                switch (stateChoice) {
            case 0:
                state = "Virginia";
                bird = "Cardinal";
                flower = "Dogwood";
                break;
            case 1:
                state = "South Carolina";
                bird = "Wild Turkey and Carolina Wren";
                flower = "Yellow Jessamine";
                break;
            case 2:
                state = "Florida";
                bird = "Northern Mockingbird";
                flower = "Orange Blossom";
                break;
        }
    }

    public void getStateInfo() {
        // Print info for each choice
        System.out.println("Bird: " + bird);
        System.out.println("Flower: " + flower);
    }

    public String getStateSummary() {
        // Create summary in format of homework 4 example
        String summary = state + ", " + bird + ", " + flower;
        return summary;
    }
}

/*
 * Author: Lindley, Thomas
 * File: HeadPhoneTest.java
 * Date: 4/21/2020
 * Purpose: Creates multiple HeadPhone objects and displays their info in single
 * string
 */
package headphonetest;

import java.awt.Color;
import java.util.Scanner;

public class HeadPhoneTest {

    public static void main(String[] args) {
        // Constructors
        // Construct default headphone
        HeadPhone h1 = new HeadPhone();
        // Construct another headphone
        HeadPhone h2 = new HeadPhone(3, false, "Duke Nukem", Color.YELLOW, "Wave After Wave");
        // Construct another headphone
        HeadPhone h3 = new HeadPhone(-2, false, "Serious Sam", Color.BLACK, "Getting Serious");
        // Construct another headphone
        HeadPhone h4 = new HeadPhone(0, false, "Doom", Color.RED, "Monster Destroyer");

        // Intialize scanner to pass value to volume
        Scanner scannerIn = new Scanner(System.in);

        //Print all info for HeadPhones
        //call toString method to list field values for headphone 1
        String toString1 = h1.toString();
        //print info
        System.out.println("HeadPhone 1 : " + toString1);
        // Spacing
        System.out.println(" ");
        // Ask user if volume change is to be made
        System.out.println("If you would like to change the volume of headphone 1"
                + " please enter value 1 to 3, 1 = low, 2 = medium, 3 = "
                + "high. Enter 4 to cancel and continue.");
        // Spacing
        System.out.println(" ");
        // Scan for input 
        int volumeH1 = scannerIn.nextInt();
        // Any invalid int value will cancel volume change
        if (volumeH1 <= 3 && volumeH1 >=1) {
            h1.changeVolume(volumeH1);
                // Print volume change
                int headPhone1Volume = h1.getVolume();
                    System.out.println(" ");
                    System.out.println("New volume of HeadPhone 1: " + 
                            headPhone1Volume);
        }
        
        // Spacing
        System.out.println("------------------------------------");
        System.out.println(" ");

        //call toString method to list field values for headphone 2
        String toString2 = h2.toString();
        //print info
        System.out.println("HeadPhone 2 : " + toString2);
        // Spacing
        System.out.println(" ");
        // Ask user if volume change is to be made
        System.out.println("If you would like to change the volume of headphone 2"
                + " please enter value 1 to 3, 1 = low, 2 = medium, 3 = "
                + "high. Enter 4 to cancel and continue.");
        // Spacing
        System.out.println(" ");
        // Scan for input 
        int volumeH2 = scannerIn.nextInt();
        // Any invalid int value will cancel volume change
        if (volumeH2 <= 3 && volumeH2 >=1) {
            h2.changeVolume(volumeH2);
                // Print volume change
                int headPhone2Volume = h2.getVolume();
                    System.out.println(" ");
                    System.out.println("New volume of HeadPhone 2: " + 
                            headPhone2Volume);
        }
        
        // Spacing
        System.out.println("------------------------------------");
        System.out.println(" ");

        //call toString method to list field values for headphone 3
        String toString3 = h3.toString();
        //print info
        System.out.println("HeadPhone 3 : " + toString3);
        // Spacing
        System.out.println(" ");
        // Ask user if volume change is to be made
        System.out.println("If you would like to change the volume of headphone 3"
                + " please enter value 1 to 3, 1 = low, 2 = medium, 3 = "
                + "high. Enter 4 to cancel and continue.");
        // Spacing
        System.out.println(" ");
        // Scan for input 
        int volumeH3 = scannerIn.nextInt();
        // Any invalid int value will cancel volume change
        if (volumeH3 <= 3 && volumeH3 >=1) {
            h3.changeVolume(volumeH3);
                // Print volume change
                int headPhone3Volume = h3.getVolume();
                    System.out.println(" ");
                    System.out.println("New volume of HeadPhone 3: " + 
                            headPhone3Volume);
        }
        
        // Spacing
        System.out.println("------------------------------------");
        System.out.println(" ");

        //call toString method to list field values for headphone 4
        String toString4 = h4.toString();
        //print info
        System.out.println("HeadPhone 4 : " + toString4);
        // Spacing
        System.out.println(" ");
        // Ask user if volume change is to be made
        System.out.println("If you would like to change the volume of headphone 4"
                + " please enter value 1 to 3, 1 = low, 2 = medium, 3 = "
                + "high. Enter 4 to cancel and continue.");
        // Spacing
        System.out.println(" ");
        // Scan for input
        int volumeH4 = scannerIn.nextInt();
        // Any invalid int value will cancel volume change
        if (volumeH4 <= 3 && volumeH4 >=1) {
            h4.changeVolume(volumeH4);
                // Print volume change
                int headPhone4Volume = h4.getVolume();
                    System.out.println(" ");
                    System.out.println("New volume of HeadPhone 4: " + 
                            headPhone4Volume);
        }
        System.out.println("------------------------------------");
        System.out.println("Current volume of headphone one is " + h1.getVolume() + 
                ", Current volume of headphone two is " + h2.getVolume() + 
                ", Current volume of headphone three is " + h3.getVolume() + 
                ", Current volume of headphone four is " + h4.getVolume());
    }
}

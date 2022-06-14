/*
* Author: Thomas Lindley
* Date: 04/26/2020
* Purpose: Program outputs random numbers based on command line arguments.
*/
package randomargs;
import java.util.Random;
public class RandomArgs {

    public static void main(String[] args) {
        // Default Values
        int xNumRandoms = 5;
        int yRandMax = 5;

        // Accept command line arguments
        if (args.length == 2) {
            xNumRandoms = Integer.parseInt(args[0]);
            yRandMax = (Integer.parseInt(args[1])+1);
            System.out.println("Number of random numbers to generate: " + args[0]);
            System.out.println("Max value (Inclusive) for random generator is: " + args[1]);
        }
        // Print info if user does not enter correct command line arguments and exits
        else {
            System.out.println("Application requires 2 command arguments");
            System.out.println("eg. java RandomArgs.java 1 10");
            System.out.println("First argument being number of random numbers to generate.");
            System.out.println("Second argument being max value of random number.");
            System.exit(0);
        }
        // Loop to create and print random numbers
        for (int i=0 ; i<xNumRandoms; i++){
            int randInt = (int) (Math.random() * yRandMax);
            System.out.println("Random Integer: " + (i+1) + " is: "  + randInt);
        }
    }
}

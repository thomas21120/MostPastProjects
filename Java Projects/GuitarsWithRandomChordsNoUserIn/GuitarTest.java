/* 
* File: GuitarTest.java
* Author: Lindley, Thomas
* Date: 4/2/2020
* Purpose: This program Tests Guitar class and uses its methods
*/

//import color class
import java.awt.Color;

public class GuitarTest {
    public static void main(String[] args) {
        //construct a guitar
        Guitar g1 = new Guitar(21,30,"Fender",Color.BLUE);

        //construct default guitar
        Guitar g2 = new Guitar();

        //call getter methods
        //call toString method
        String toString = g1.toString();
        //print info
        System.out.println("toString(): " + toString);

        //call getter NumStrings
        int g1numStrings = g1.getNumStrings();
         //print num strings
        System.out.println("getNumStrings(): " + g1numStrings);

        // call get guitar length
        double g1guitarLength = g1.getGuitarLength();
        //print Guitarlength
        System.out.println("getGuitarLength(): " + g1guitarLength);

        //call getter guitarmanurfacturer 
        String g1guitarManurfacturer = g1.getGuitarManurfacturer();
        //print manurfacturer
        System.out.println("getGuitarManufacturer(): " + g1guitarManurfacturer);

        // call guitar collor string gettert 
        String colorName = g1.getGuitarColorString();
        //print color 
        System.out.println("getGuitarColorString(): " + colorName);

        // Call Play guitar mehtod-
        String tune = g1.playGuitar();
        //print itune
        System.out.println("playGuitar(): " + tune);
    }
}
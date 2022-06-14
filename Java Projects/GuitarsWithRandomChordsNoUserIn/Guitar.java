/* 
* File: Guitar.java
* Author: Lindley, Thomas
* Date: 4/2/2020
* Purpose: This program constructs instances of the GuitarSpec class and uses its methods
*/
import java.util.Random;
import java.awt.Color;

public class Guitar {
private int numStrings;
private double guitarLength;
private String guitarManurfacturer;
private Color guitarColor; 
private String colorName;

//Constructor
public Guitar (int strings, double length, String manurfacturer, Color clr) {
    numStrings = strings;
    guitarLength = length;
    guitarManurfacturer = manurfacturer;
    guitarColor = clr;
    if (guitarColor.equals(Color.RED)) colorName = "Red";
    if (guitarColor.equals(Color.BLUE)) colorName = "Blue";
    if (guitarColor.equals(Color.BLACK)) colorName = "Black";
    if (guitarColor.equals(Color.GREEN)) colorName = "Green";
    if (guitarColor.equals(Color.YELLOW)) colorName = "Yellow";
}
//Default Constructor
public Guitar() {
    numStrings = 6;
    guitarLength = 28.2;
    guitarManurfacturer = "Gibson";
    guitarColor = Color.RED;
}

//setter methods
//set numStrings
public void setNumStrings(int strings){
    numStrings = strings;
}
//set guitarLength
public void setGuitarLength(double length){
    guitarLength = length;
}
//set guitarManurfacturer
public void setGuitarManurfacturer(String manurfacturer){
    guitarManurfacturer = manurfacturer;
}
//set guitarClor
public void setGuitarColor(Color clr){
    guitarColor = clr;
}

//Getter methods
//get numStrings
public int getNumStrings() {
	return numStrings;
}
//get guitarLength
public double getGuitarLength() {
	return guitarLength;
}
//get guitarManurfacturer
public String getGuitarManurfacturer() {
	return guitarManurfacturer;
}
//get guitarClor
public Color getGuitarColor() {
return guitarColor;
}
//getter get GuitarColorS
public String getGuitarColorString() {
return colorName;
}

// toString method
public String toString() {
    String toString = ("(" + "numStrings = " + numStrings + "  Length = " + guitarLength + 
    "  Manurfacturer = " + guitarManurfacturer + "  Color = " + colorName + ")");
    return toString;
}


//method to get random chord 
public String playGuitar() {
    
//initialize random class
Random randomGen = new Random();
    
    //initialize variables
    char note = 'A';
    String duration = ".25";
    String tune = "";
    int randNoteInt = 0;
    int randDurationInt = 0;

        // For loop outputs 16 random notes with random duration
        for(int i=1; i<17; i++){  
            randNoteInt = randomGen.nextInt(7);
            
            // switch takes ranom int and swithes to a char
            switch (randNoteInt) {
                case 0:
                    note = 'A';
                    break;
                case 1:
                    note = 'B';
                    break;
                case 2:
                    note = 'C';
                    break;
                case 3:
                    note = 'D';
                    break;
                case 4:
                    note = 'E';
                    break;
                case 5:
                    note = 'F';
                    break;
                case 6:
                    note = 'G';
                    break;
        }    
            //random duration generator
            randDurationInt = randomGen.nextInt(5);

            //switch take random int and turns it to random duration
            switch (randDurationInt) {
                case 0:
                    duration = ".25";
                    break;
                case 1:
                    duration = ".5";
                    break;
                case 2:
                    duration = "1";
                    break;
                case 3:
                    duration = "2";
                    break;
                case 4:
                    duration = "4";
                    break;
            }
            //tune is a combination of ouputs from both switch statements
            tune = tune + (note + "(" + duration + ") ");
        }        
    return tune;
    } 
}


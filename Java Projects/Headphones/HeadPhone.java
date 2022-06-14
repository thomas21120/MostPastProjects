/*
 * Author: Lindley, Thomas
 * File: HeadPhone.java
 * Date: 4/21/2020
 * Purpose: Creates multiple HeadPhone objects and displays their info in single
 * string
 */
package headphonetest;

import java.awt.Color;

public class HeadPhone {

    // Initialize static variables
    private static final int LOW = 1;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;
    private int volume;
    private boolean pluggedIn;
    private String manurfacturer;
    private Color headPhoneColor;
    private String headPhoneModel;
    private String colorName;

    // Default Constructor
    public HeadPhone() {
        volume = MEDIUM;
        pluggedIn = false;
    }

    // Constructor
    public HeadPhone(int volumeA, boolean pluggedInA, String manurfacturerA,
            Color headPhoneColorA, String headPhoneModelA) {
        volume = volumeA;
        pluggedIn = pluggedInA;
        manurfacturer = manurfacturerA;
        headPhoneColor = headPhoneColorA;
        headPhoneModel = headPhoneModelA;
        if (headPhoneColor.equals(Color.RED)) {
            colorName = "Red";
        }
        if (headPhoneColor.equals(Color.BLUE)) {
            colorName = "Blue";
        }
        if (headPhoneColor.equals(Color.BLACK)) {
            colorName = "Black";
        }
        if (headPhoneColor.equals(Color.GREEN)) {
            colorName = "Green";
        }
        if (headPhoneColor.equals(Color.YELLOW)) {
            colorName = "Yellow";
        }
    }

    // Setter Methods
    public void setVolume(int volumeA) {
        volume = volumeA;
    }

    public void setPluggedIn(boolean pluggedInA) {
        pluggedIn = pluggedInA;
    }

    public void setManurfacturer(String manurfacturerA) {
        manurfacturer = manurfacturerA;
    }

    public void setHeadPhoneColor(Color headPhoneColorA) {
        headPhoneColor = headPhoneColorA;
    }

    public void setHeadPhoneModel(String headPhoneModelA) {
        headPhoneModel = headPhoneModelA;
    }



    // Getter Methods
    public int getVolume() {
        return this.volume;
    }

    public boolean getPluggedIn() {
        return this.pluggedIn;
    }

    public String getManurfacturer() {
        return this.manurfacturer;
    }

    public String getHeadPhoneColor() {
        return this.colorName;
    }

    public String getHeadPhoneModel() {
        return this.headPhoneModel;
    }

    // toString method
    public String toString() {
        String toString = ("(" + "Volume = " + volume + "  Plugged In = " + pluggedIn
                + "  Manurfacturer = " + manurfacturer + "  Color = " + colorName
                + "  HeadPhoneModel = " + headPhoneModel + ")");
        return toString;
    }
    
        // Method to change volume
    public void changeVolume(int xVolume) {
        this.volume = xVolume;
    }
}

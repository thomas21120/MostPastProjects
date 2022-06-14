/*
* File: Homework1.java
* Author: Lindley, Thomas
* Date: March 3, 2020
* Purpose: This program Takes various inputs from uservas follows:
* EMPLID(00000), quiz 1,2,3 % score(00.00), age (months),current temperature (Celsius)
* Then ouputs user inputed information, average grade, temp in farinheight, and age in years
* classes including Scanner classes.
*/

// Import each required Java class
import java.util.Scanner;

public class StudentInfo{
    public static void main(String[] args) {
      //variables
      int EMPLID = 0;
      int ageM = 0;
      int ageY = 0;
      double quiz1 = 0.0;
      double quiz2 = 0.0;
      double quiz3 = 0.0;
      double tempC = 0.0;
      double tempF = 0.0;
      double average = 0.0;
      //unicode for degrees symbol
      char deg = '\u00B0';

    //scanner class to acept input 
      Scanner scannerIn = new Scanner(System.in);
      
    //prompt and scan for Employee ID
      System.out.print("Please enter your Studen EMPLID number (0 - 999999): ");
        EMPLID = scannerIn.nextInt();
    //if statement to stop invalind input
        if ((EMPLID < 0) ||
                (EMPLID > 999999)){
        System.out.println("Invalid input, value must be between 0 and 999999. Bye.");
          System.exit(0);        
        }
    
    //prompt and scan for quiz 1 
        System.out.print("Please enter your grade for quiz 1 (0.0 - 100.0): ");
          quiz1 = scannerIn.nextDouble();
    //if statement to stop invalind input
        if ((quiz1 < 0.0) ||
              (quiz1 > 100.00)){
        System.out.println("Invalid input, value must be between 0.0 and 100.0. Bye.");
          System.exit(0);        
      }

    //prompt and scan for quiz 2 
      System.out.print("Please enter your grade for quiz 2 (0.0 - 100.0): ");
        quiz2 = scannerIn.nextDouble();
    //if statement to stop invalind input
        if ((quiz2 < 0.0) ||
              (quiz1 > 100.00)){
        System.out.println("Invalid input, value must be between 0.0 and 100.0. Bye.");
          System.exit(0);        
      }

    //prompt and scan for quiz 3
    System.out.print("Please enter your grade for quiz 3 (0.0 - 100.0): ");
      quiz3 = scannerIn.nextDouble();
    //if statement to stop invalind input
        if ((quiz3 < 0.0) ||
              (quiz1 > 100.00)){
        System.out.println("Invalid input, value must be between 0.0 and 100.0. Bye.");
          System.exit(0);        
      }

    //prompt and scan for age in months
      System.out.print("Please enter your age in months (0 - 1440): ");
        ageM = scannerIn.nextInt(); 
    //if statement to stop invalind input
        if ((ageM < 0) ||
                (ageM > 1440)){
            System.out.println("The oldest person ever to live, lived to 1392 months (116 years old)");
            System.out.println("pleae recalculate your age in months and try again. Bye.");
            System.exit(0);        
        }

    //prompt and scan for tempuratue in celsius 
      System.out.print("Please enter the current temperature in celsius (-100 - 100): ");
        tempC = scannerIn.nextDouble();
    //if statement to stop invalind input
        if ((tempC < -100) ||
                (tempC > 100)){
            System.out.println("Invalid input, value must be between -100 and 100.");
            System.out.println("Make sure you are inputing temperature in celcius.");
            System.exit(0);        
        }

    //add some space and print thank you
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println(".....Thank you for your time.....");
    
    //print emplid
    System.out.println("Student EMPLID: " + EMPLID);
    
    //print quiz grades
    System.out.println("Quiz 1 score: " + quiz1);
    System.out.println("Quiz 2 score: " + quiz2);
    System.out.println("Quiz 3 Score: " + quiz3);
    
    //average quiz grades
    average = (quiz1 + quiz2 + quiz3) / 3;
    System.out.println("quiz average: " + average);
    
    //print age in months
    System.out.println("Age in months: " + ageM);
    
    //calc age in years and output
    ageY = ageM / 12;
    System.out.println("Age in years: " + ageY);

    //output temperature in celcius
    System.out.println("Temperature in celsius: " + tempC+deg);

    //output fahrenheit
    tempF = tempC * 1.8 + 32;
    System.out.println("Temperature in fahrenheit: " + tempF+deg);
 
    }
}

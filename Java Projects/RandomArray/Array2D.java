/*
* File: Array2D
* Author: Lindley, Thomas
* Date: 04/14/2020
* Purpose: Program creates 5 x 10 table of integers andd prints them
*/ 

public class Array2D {
    // Set two array sizes
    static final int ARRAYROW = 5;
    static final int ARRAYCOLUMN = 10;

        public static void main(String args[]) {

     // Create array of int 2D
     int[][] int2D = new int[ARRAYROW][ARRAYCOLUMN];

     // Assign random values 
        for (int i=0; i<ARRAYROW; i++) {
            for (int j=0; j<ARRAYCOLUMN; j++) {
                int2D[i][j] = (int) (Math.random() * 30)+1;    
            }
        }
        
        // Print Results of int2D
        for (int i=0; i<ARRAYROW; i++){
            for (int j=0; j<ARRAYCOLUMN; j++){
              System.out.print(int2D[i][j] + "\t");
            }
          System.out.println("");
        } 
    }
}
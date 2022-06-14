
/*
* File: MyArrays
* Author: Lindley, Thomas
* Date: 04/13/202
* Purpose: Program creates multiple different arrays and will sort integers array
*/
import java.util.Random;
import java.util.Arrays;

public class MyArray {
	// Set two array sizes
	static final int ARRAYSIZE1 = 5;
	static final int ARRAYSIZE2 = 15;

	public static void main(String args[]) {
		System.out.println("Welcome to the MultiDimensional Array Demo.");
		System.out.println("This program will create multiple arrays and will sort integers array.");

		// Create array of doubles 2 D
		double[][] precip2D = new double[ARRAYSIZE1][ARRAYSIZE2];
		// Assign random values
		for (int i = 0; i < ARRAYSIZE1; i++) {
			for (int j = 0; j < ARRAYSIZE2; j++) {
				precip2D[i][j] = Double.parseDouble(String.format("%.2f", Math.random() * 10));
				final String b = new String("12.00");
				Double c = Double.parseDouble(b);

			}
		}

		// Create 1D integer array
		int[] arrayInteger = new int[ARRAYSIZE2];
		// Assign random values
		for (int i = 0; i < ARRAYSIZE2; i++) {
			arrayInteger[i] = (int) (Math.random() * 13);
		}

		// Create 2D Char array
		char[][] arrayChar = new char[ARRAYSIZE1][ARRAYSIZE2];
		Random rnd = new Random();
		// Assign random values from a to z
		for (int i = 0; i < ARRAYSIZE1; i++) {
			for (int j = 0; j < ARRAYSIZE2; j++) {
				arrayChar[i][j] = (char) (rnd.nextInt(26) + 'a');
			}
		}

		// Print result of integers
		System.out.println("");
		System.out.println("--Integers--");
		System.out.println("--UNSORTED--");
		System.out.print("------------");
		for (int i = 0; i < arrayInteger.length; i++) {
			if ((i % 5) == 0) {
				System.out.println("");
			}
			System.out.print(arrayInteger[i] + "\t");
		}

		// Print Results of Doubles
		for (int i = 0; i < ARRAYSIZE1; i++) {
			System.out.println("");
			System.out.println("Random Doubles Group :" + i);
			for (int j = 0; j < ARRAYSIZE2; j++) {
				if ((j % 5) == 0) {
					System.out.println("");
				}
				System.out.print(precip2D[i][j] + "\t");
			}
			System.out.println("");
		}

		// Print Results of Char
		System.out.println("");
		System.out.println("Random Chars");
		for (int i = 0; i < ARRAYSIZE1; i++) {
			System.out.println("------------");
			for (int j = 0; j < ARRAYSIZE2; j++) {
				System.out.print(arrayChar[i][j] + "\t");
			}
			System.out.println("");
		}

		// Sort integers
		Arrays.sort(arrayInteger);
		// Print Results of integers sorted
		System.out.println("");
		System.out.println("--Integers--");
		System.out.println("---SORTED---");
		System.out.print("------------");
		for (int i = 0; i < arrayInteger.length; i++) {
			if ((i % 5) == 0) {
				System.out.println("");
			}
			System.out.print(arrayInteger[i] + "\t");
		}
	}
}
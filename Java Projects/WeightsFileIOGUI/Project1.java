/*
 * File: Project1.java
 * Package Project1
 * Author: Lindley, Thomas
 * Date: June 2, 2020
 * Purpose: This program reads selected file, that has lbs in one column and oz in another, and
 * stores lbs and oz in a weight object, then uses methods in Weight.java to find min, max and average weight.
 */

package WeightsFileIOGUI;

import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Project1 {
	// Finds minimum weight by looping through weight objects and using lessThan
	// method to find if next weight
	// is less than the current weight and sets currentMinWeightIndex to the index
	// of the next smaller weight if true
	private static Weight findMinimum(Weight[] weight, int n) {
		int currentMinWeightIndex = 0;
		// Relies on n which is a counter of how many weight objects are created
		for (int i = 0; i < n; i++) {
			if (weight[i].lessThan(weight[currentMinWeightIndex])) {
				currentMinWeightIndex = i;
			}
		}
		return weight[currentMinWeightIndex];
	}

	// Finds Maximum weight in the same way minimum weight is found but opposite to
	// find max
	private static Weight findMaximum(Weight[] weight, int n) {
		int currentMaxWeightIndex = 0;
		// Relies on n which is a counter of how many weight objects are created
		for (int i = 0; i < n; i++) {
			if (weight[currentMaxWeightIndex].lessThan(weight[i])) {
				currentMaxWeightIndex = i;
			}
		}
		return weight[currentMaxWeightIndex];
	}

	// Finds average by adding all weights together with addToo method, and then
	// uses divide method to find average
	private static Weight findAverage(Weight[] weight, int n) {
		Weight avgWeight = new Weight(0, 0);
		// This is where the counter n is important because we need to only divide the
		// added weight by how many weights
		// Were actually added
		for (int i = 0; i < n; i++) {
			avgWeight.addToo(weight[i]);
		}
		avgWeight.divide(n);
		return avgWeight;
	}

	public static void main(String[] args) {
		// Initialize file chooser with default directory
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
		Scanner scannerIn = null;
		FileInputStream in = null;
		BufferedReader inputStream = null;
		// Initialize weight array
		Weight weight[] = new Weight[25];
		// Initialize counter
		int n = 0;

		try {
			// Chosen file is put into the input stream
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
			}
			inputStream = new BufferedReader(new FileReader(jfc.getSelectedFile()));
			scannerIn = new Scanner(inputStream);
		} catch (IOException io) {
			System.out.println("File IO exception" + io.getMessage());
		}
		try {
			while (scannerIn.hasNextDouble()) {
				Double pound = scannerIn.nextDouble();
				Double ounces = scannerIn.nextDouble();
				weight[n] = new Weight(pound, ounces);
				n++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Catch exception if the file contains too many weights
			System.out.println("Array index out of bounds exception: " + e.getMessage());
			System.exit(0);
		} finally {
			// Need another catch for closing
			// the streams
			try {
				// Close the streams, not sure if actually necessary, but I'm sure I've run into
				// problems with not closing streams before
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException io) {
				System.out.println("Issue closing the Files" + io.getMessage());
			}
		}
		// TESTING
		System.out.println("Minimum weight: " + findMinimum(weight, n).toString());
		System.out.println("Maximum weight: " + findMaximum(weight, n).toString());
		System.out.println("Average weight: " + findAverage(weight, n).toString());
	}
}

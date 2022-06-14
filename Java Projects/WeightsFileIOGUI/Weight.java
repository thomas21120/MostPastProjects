/*
 * File: Weight.java
 * Package Project1
 * Author: Lindley, Thomas
 * Date: June 2, 2020
 * Purpose: This program contains methods for finding minimum, maximum, and average weight object, and
 * normalizes results.
 * Note: Documentation is probably not the best, need to document as I go next time
 */

package WeightsFileIOGUI;

import java.text.DecimalFormat;

public class Weight {
	private double pounds;
	private double ounces;
	private final double OUNCES = 16.00;
	// format for ounces decimal
	DecimalFormat df = new DecimalFormat("0.000");

	public Weight(double pounds, double ounces) {
		this.pounds = pounds;
		this.ounces = ounces;
	}

	// Compares two values and returns true if one weight is less than another,
	// calls normalize to normalize result
	public Boolean lessThan(Weight input) {
		normalize();
		if (toOunces() < input.toOunces())
			return true;
		else
			return false;
	}

	// Adds weights together, normalizes result
	public void addToo(Weight input) {
		this.pounds = this.pounds + input.pounds;
		this.ounces = this.ounces + input.ounces;
		normalize();
	}

	// Divides total ounces value of weights by divide, which is determined by the n
	// counter in Project1.java
	public void divide(double divide) {
		this.ounces = this.toOunces() / divide;
		this.pounds = 0;
		normalize();
	}

	// toString for information to be printed, uses decimal format here to make sure
	// oz are to three decimal places
	public String toString() {
		String Pound = Double.toString(this.pounds);
		double Ounce = this.ounces;
		String OunceFormatted = df.format(Ounce);
		return Pound + "lbs " + OunceFormatted + "oz";
	}

	// converts pounds and ounces to ounces value of weight
	private Double toOunces() {
		Double poundsToOunces = this.pounds * OUNCES + this.ounces;
		return poundsToOunces;
	}

	// normalizes the results by converting ounces to pounds and adding it to
	// pounds, math floor used to only get whole
	// pounds of ounces, the ounces are found by using a modulus so we get the
	// remaining ounces that don't get turned into ounces
	private void normalize() {
		this.pounds = Math.floor(pounds + ounces / 16);
		this.ounces = ounces % 16;
	}
}

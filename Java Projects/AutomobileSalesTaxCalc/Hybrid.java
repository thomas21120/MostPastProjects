/*
 * Author: Thomas, Lindley
 * Date: 06/16/2020
 * Program: Hybrid.java - child class, creates automobile objects with added variable of mpg. Includes sales tax method that 
 * takes into account mpg to calculate sales tax
 */
package Project2;

public class Hybrid extends Automobile {
    private int mpg;
    // Hybrid takes in a new argument mpg
    public Hybrid(String makeModel, int salesPrice, int mpg) {
        super(makeModel, salesPrice);
        this.mpg = mpg;
    }
    //sales tax of hybrids rellies on mpg
    public double salesTax() {
        if (this.mpg < 40) {
            this.salesTax = (salesPrice * 0.05) - 100;
        } else {
            this.salesTax = ((salesPrice * 0.05) - (100 + 2 * (mpg - 40)));
        }
        return this.salesTax;
    }

    public String toString() {
        return "Make and Model: " + this.makeModel + "\n Sales Price: " + this.salesPrice +
                "\n Sales Tax: " + this.salesTax + "\n Hybrid Vehicle" + "\nMPG: " + mpg;
    }
}

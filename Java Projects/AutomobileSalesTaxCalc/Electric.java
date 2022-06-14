/*
 * Author: Thomas, Lindley
 * Date: 06/16/2020
 * Program: Electric.java - child class, creates automobile objects with added variable of weight. Includes sales tax method that 
 * takes into account weight to calculate sales tax
 */
package Project2;

public class Electric extends Automobile {
    private int weight;
    // takes in new argument of weight as it effects sales tax
    public Electric(String makeModel, int salesPrice, int weight) {
        super(makeModel, salesPrice);
        this.weight = weight;
    }
    //sales tax is dependent on weight of vehicle
    public double salesTax() {
        if (this.weight < 3000) {
            this.salesTax = (salesPrice * 0.05) - 200;
        } else {
            this.salesTax = (salesPrice * 0.05) - 150;
        }
        return this.salesTax;
    }

    public String toString() {
        return "Make and Model: " + this.makeModel + "\n Sales Price: " + this.salesPrice +
                "\n Sales Tax: " + this.salesTax + "\n Electric Vehicle" + "\nWeight: " + weight;
    }
}

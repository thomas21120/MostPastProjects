/*
 * Author: Thomas, Lindley
 * Date: 06/16/2020
 * Program: Automobile.java - parent class, creates automobile objects and includes method to find sales tax of object
 */
package Project2;

public class Automobile {
    // Variables
    protected String makeModel;
    protected int salesPrice;
    protected double salesTax;
    // Takes makeModel and salesPrice as argument. 
    public Automobile(String makeModel, int salesPrice) {
        this.makeModel = makeModel;
        this.salesPrice = salesPrice;
    }
    //Sales tax for normal cars is just 5 percent of price.
    public double salesTax() {
        this.salesTax = salesPrice * 0.05;
        return this.salesTax;
    }
    //To String method to print information.
    public String toString() {
        return "Make and Model: " + this.makeModel + "\n Sales Price: " + this.salesPrice
                + "\n Sales Tax: " + this.salesTax;
    }
}

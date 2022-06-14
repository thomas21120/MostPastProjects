/*
 * Author: Thomas, Lindley
 * Date: 07/24/2020
 * Purpose: This class declares variables neccesary to creat property objects. It also contains the constructor, a method for
 * changing status, and an overriden to string method.
 */
package lindley.project4;

public class Property implements StateChangeable<Status>{
    private String propAddress = "";
    private int numBed = 0;
    private int sqrFoot = 0;
    private int price = 0;
    private Status propStat;
    
    Property(String propAdd, int numB, int sqrF, int pric){
        propAddress = propAdd;
        numBed = numB;
        sqrFoot = sqrF;
        price = pric;
        propStat = Status.FOR_SALE;
    }
    
    public void changeState(Status propSta){
        propStat = propSta;
    }
    
    public String toString(){
        String stringy = "Property Address: " + propAddress + "\nNumber of Bedrooms: " 
            + numBed + "\nSquare Foot: " + sqrFoot + "\nPrice: " + price + "\nProperty Status: " + propStat;
    return stringy;
    }
}

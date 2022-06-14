//*******************************************************************
//  Class: Circle.java
//
//  Description: Child of TwoDimensionalShape.java, creates Circle object with 
//                area based on user input.
//*******************************************************************

public class Circle extends TwoDimensionalShape {
  double radius;
  public Circle(double radius){
    this.radius = radius;
    this.setArea(Math.PI * (radius * radius));
  }
}

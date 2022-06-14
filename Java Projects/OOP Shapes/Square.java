//*******************************************************************
//  Class: Square.java
//
//  Description: Child of TwoDimensionalShape.java, creates Square object with 
//                area based on user input.
//*******************************************************************

public class Square extends TwoDimensionalShape {
  double edge;
  public Square(double edge){
    this.edge = edge;
    this.setArea(edge * edge);
  }
}

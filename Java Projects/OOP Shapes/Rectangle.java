//*******************************************************************
//  Class: Rectangle.java
//
//  Description: Child of TwoDimensionalShape.java, creates rectangle object with 
//                area based on user input. Also determines if rectangle is also a 
//                square.
//*******************************************************************

public class Rectangle extends TwoDimensionalShape {
  double length;
  double width;
  public Rectangle(double length, double width){
    this.length = length;
    this.width = width;
    this.setArea(length * width);
  }
  //method to determine if rectangle is a square
  public String isSquare(){
    if(length == width){
      return "";
    }else {
      return "not";
    }
  }
}

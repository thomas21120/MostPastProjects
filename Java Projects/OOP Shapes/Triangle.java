//*******************************************************************
//  Class: Triangle.java
//
//  Description: Child of TwoDimensionalShape.java, creates triangle object with 
//                area based on user input. Also determines what type of triangle it 
//                is.
//*******************************************************************

public class Triangle extends TwoDimensionalShape {
  double base, height, largestAngel, sideLeft, sideRight;
  public Triangle(double base, double height, double largestAngel, double sideLeft, double sideRight){
    this.base = base;
    this.height = height;
    this.largestAngel = largestAngel;
    this.sideLeft = sideLeft;
    this.sideRight = sideRight;
    this.setArea(0.5 * base * height);
  }

  // method to determine what type of triangle based on largest angle given
  public String typeOfTriangleByAngle(){
    if(this.largestAngel < 90.0){
      return "Acute";
    } else if(this.largestAngel == 90.0){
      return "Right";
    } else if(this. largestAngel > 90.0 && this. largestAngel < 180.0){
      return "Obtuse";
    } else {
      return "Not a possible angle size.";
    }
  }

  // method to determine type of triangle based on side lengths given
  public String typeOfTriangleBySides(){
    if(this.base == this.sideRight && this.sideLeft == this.sideRight){
      return "Equilateral";
    }else if(this.base == this.sideLeft || this.sideRight == this.base || this.sideLeft == this.sideRight){
      return "Isosceles";
    }else {
      return "Scalene";
    }
  }
}

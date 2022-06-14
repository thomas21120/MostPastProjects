//*******************************************************************
//  Class: TwoDimensionalShape
//
// Description: Child of Shape, Parent of all 2D shapes, gives all children way to
//                set area. Also sets the shapes dimension.
//*******************************************************************

public class TwoDimensionalShape extends Shape {
  public TwoDimensionalShape(){
    this.setNumberOfDimensions("2D");
  }
  private double area;
  public void setArea(double area){
    this.area = area;
  }
  public double getArea(){
    return area;
  }
}

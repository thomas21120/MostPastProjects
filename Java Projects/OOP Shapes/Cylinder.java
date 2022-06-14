//*******************************************************************
//  class: Cylinder
//
//  Description: Child of ThreeDimensionalShape, creates cylinder object with volume
//                based on user input.
//*******************************************************************

public class Cylinder extends ThreeDimensionalShape {
  double radius, height;
  public Cylinder(double radius, double height){
    this.radius = radius;
    this.height = height;
    this.setVolume(Math.pow(radius, 2)*Math.PI*height);
  }
}

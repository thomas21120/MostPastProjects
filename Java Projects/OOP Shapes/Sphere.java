//*******************************************************************
//  class: Sphere
//
//  Description: Child of ThreeDimensionalShape, creates sphere object with volume 
//                based on user input.
//*******************************************************************

public class Sphere extends ThreeDimensionalShape {
  double radius;
  public Sphere(double radius){
    this.radius = radius;
    this.setVolume(((4.0/3.0)*Math.PI) * (Math.pow(radius, 3)));
  }
}

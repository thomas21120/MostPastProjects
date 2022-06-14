//*******************************************************************
//  class: Torus
//
//  Description: Child of ThreeDimensionalShape, creates torus object  with volume 
//                based on user input.
//*******************************************************************

public class Torus extends ThreeDimensionalShape {
  double radiusMajor, radiusMinor;
  public Torus(double radiusMajor, double radiusMinor){
    this.radiusMajor = radiusMajor;
    this.radiusMinor = radiusMinor;
    this.setVolume((Math.PI*Math.pow(radiusMinor, 2))*(2.0*Math.PI*radiusMajor));
  }
}

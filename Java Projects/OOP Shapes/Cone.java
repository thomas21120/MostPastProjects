//*******************************************************************
//Class: Cone
//
//Description: Child of ThreeDimensionalShape, allows creation of cone object, and 
// sets volume based on user input.
//*******************************************************************

public class Cone extends ThreeDimensionalShape {
  double radiusC, heightC;
  public Cone(double radiusC, double heightC){
    this.radiusC = radiusC;
    this.heightC = heightC;
    this.setVolume(Math.PI*Math.pow(radiusC, 2)*(heightC/3.0));
  }
}

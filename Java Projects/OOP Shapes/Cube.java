//*******************************************************************
//  class: Cube
//
//  Description: Child of ThreeDimensionalShape, creates cube object with volume 
//                based on user input
//*******************************************************************

public class Cube extends ThreeDimensionalShape {
  public Cube(double edge){
    this.setVolume(Math.pow(edge, 3));
  }
}

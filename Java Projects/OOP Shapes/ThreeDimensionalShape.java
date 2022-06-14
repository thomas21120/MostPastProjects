//*******************************************************************
//Class: ThreeDimensionalShape
//
//Description: Child of Shape, parent of all three dimensional shapes, gives all children volume and sets shape's dimension
//*******************************************************************

public class ThreeDimensionalShape extends Shape {
  public ThreeDimensionalShape(){
    this.setNumberOfDimensions("3D");
  }
  private double volume;
  public void setVolume(double volume){
    this.volume = volume;
  }
  public double getVolume(){
    return volume;
  }
}

//*******************************************************************
//Class: Shape
//
//Description: Parent class of all other classes besides main. Gives all children a dimension.
//*******************************************************************

public class Shape extends Object{
  private String dimensions;
  public void setNumberOfDimensions(String dimensions){
    this.dimensions = dimensions;
  }
  public String getNumDimensions(){
    return this.dimensions;
  }
}

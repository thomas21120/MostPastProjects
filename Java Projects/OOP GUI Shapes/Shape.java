//*******************************************************************
//Class: Shape.java
//
//Description: Parent class of all other classes besides main, classes that start with draw, and create. Gives all children a dimension.
//*******************************************************************

public class Shape{
  private int dimensions;
  private String name;
  Shape(int dimensions, String name){
    this.dimensions = dimensions;
    this.name = name;
  }
  int getNumDimensions(){
    return this.dimensions;
  }
  String getName(){
    return this.name;
  }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

class TwoDimensionalShape extends Shape {
  double dimension1, dimension2;
  TwoDimensionalShape(double dimension1, double dimension2, String name){
    super(2, name);
    this.dimension1 = dimension1;
    this.dimension2 = dimension2;
  }
  public double getArea(){
    return dimension1 * dimension2;
  }
}

//------------------------------------------------------------------------------------

class Triangle extends TwoDimensionalShape {
  Triangle(double base, double height){
    super(base * 0.5, height, "Triangle");
  }
}

//------------------------------------------------------------------------------------

class Square extends TwoDimensionalShape {
  Square(double edge){
    super(edge, edge, "Square");
  }
}

//------------------------------------------------------------------------------------

class Circle extends TwoDimensionalShape {
  Circle(double radius){
    super(radius * Math.PI, radius, "Circle");
  }
}

//------------------------------------------------------------------------------------

class Rectangle extends TwoDimensionalShape {
  public Rectangle(double length, double width){
    super(length, width, "Rectangle");
  }
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

class ThreeDimensionalShape extends Shape {
  double dimension1;
  double dimension2;
  double dimension3;
  ThreeDimensionalShape(double dimension1, double dimension2, double dimension3, String name){
    super(3, name);
    this.dimension1 = dimension1;
    this.dimension2 = dimension2;
    this.dimension3 = dimension3;
  }
  public double getVolume(){
    return dimension1 * dimension2 * dimension3;
  }
}

//------------------------------------------------------------------------------------

class Cone extends ThreeDimensionalShape {
  Cone(double radius, double height){
    super(Math.PI, (Math.pow(radius, 2)), (height/3.0), "Cone");
  }
}

//------------------------------------------------------------------------------------

class Cube extends ThreeDimensionalShape {
  Cube(double edge){
    super(edge, edge, edge, "Cube");
  }
}

//------------------------------------------------------------------------------------

class Cylinder extends ThreeDimensionalShape {
  Cylinder(double radius, double height){
    super((Math.pow(radius, 2)), Math.PI, height, "Cylinder");
  }
}

//------------------------------------------------------------------------------------

class Sphere extends ThreeDimensionalShape {
  Sphere(double radius){
    super((4.0/3.0), Math.PI, (Math.pow(radius, 3)), "Sphere");
  }
}

//------------------------------------------------------------------------------------

class Torus extends ThreeDimensionalShape {
  Torus(double radiusMajor, double radiusMinor){
    super(Math.PI, Math.pow(radiusMinor, 2), (2.0*Math.PI*radiusMajor), "Torus");
  }
}
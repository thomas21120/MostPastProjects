//*******************************************************************
//  Class: Create.java
//
//  Description: Used by main_Swing.java to get volume/area of shapes from Shape.java
//*******************************************************************

public class Create {
  static double getAreaOfCircle(double radius) { 
    return new Circle(radius).getArea();
  }

  static double getAreaOfRectangle(double length, double width) {
    return new Rectangle(length, width).getArea();
  }

  static double getAreaOfSquare(double edge) {
    return new Square(edge).getArea();
  }

  static double getAreaOfTriangle(double base, double height) {
    return new Triangle(base, height).getArea();
  }

  static double getVolumeOfSphere(double radius) {
    return new Sphere(radius).getVolume();
  }

  static double getVolumeOfCube(double edge) {
    return new Cube(edge).getVolume();
  }

  static double getVolumeOfCone(double radius, double height) {
    return new Cone(radius, height).getVolume();
  }   

  static double getVolumeOfCylinder(double radius, double height) {
    return new Cylinder(radius, height).getVolume();
  }

  static double getVolumeOfTorus(double majorRadius, double minorRadius) {
      return new Torus(majorRadius, minorRadius).getVolume();
  }
}

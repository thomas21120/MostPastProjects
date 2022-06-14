//*******************************************************************
//  Class: DrawCircle.java
//
//  Description: Used by main_Swing.java to display representation of shape 
//*******************************************************************

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;

public class DrawCircle extends JPanel{
  double radius;
  int rOut;

  public DrawCircle(double radius){
    this.radius = radius;
  }

  public Dimension getPreferredSize() {
    return new Dimension(200,200);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    // ensure shape can actually fit in frame
    while(radius > 100){
      radius = radius/2;
    }
    while(radius < 10){
      radius = radius * 10;
      System.out.println(radius);
    }
    rOut = (int) radius;
    int x = 100 - (rOut / 2);
    int y = 100 - (rOut / 2);
    g.drawOval(x, y, rOut, rOut);
  }
}


//*******************************************************************
//  Class: DrawRectangle.java
//
//  Description: Used by main_Swing.java to display representation of shape 
//*******************************************************************

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;

public class DrawRectangle extends JPanel{
  double length, width;
  int lOut, wOut;

  public DrawRectangle(double length, double width){
    this.length = length;
    this.width = width;
  }

  public Dimension getPreferredSize() {
    return new Dimension(200,200);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    // ensure shape can actually fit in frame
    while((length > 100) || (width > 100)){
      length = length/2;
      width = width/2;
    }
    lOut = (int) length;
    wOut = (int) width;
    int x = 100 - (lOut/2);
    int y = 100 - (wOut/2);
    g.drawRect(x, y, lOut, wOut);
  }
}

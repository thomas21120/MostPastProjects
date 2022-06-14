//*******************************************************************
//  Class: DrawTriangle.java
//
//  Description: Used by main_Swing.java to display representation of shape 
//*******************************************************************

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;

public class DrawTriangle extends JPanel {
  double base, height;
  int bOut, hOut;

  public DrawTriangle(double base, double height){
      this.base = base;
      this.height = height;
  }

  public Dimension getPreferredSize() {
      return new Dimension(200,200);
  }

  public void paintComponent(Graphics g) {
      super.paintComponent(g);

      // ensure shape can actually fit in frame
      while((base > 100) || (height > 100)){
        base = base/2;
        height = height/2;
      }
      bOut = (int) base;
      hOut = (int) height;
      int x = 100 - (bOut / 2);
      int y = 100 + (hOut / 2);
      g.drawLine(x, y, x, y - hOut);
      g.drawLine(x, y, x + bOut, y);
      g.drawLine(x, y - hOut, x + bOut, y);
  }  
}
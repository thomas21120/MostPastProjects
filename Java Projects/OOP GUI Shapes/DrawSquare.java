//*******************************************************************
//  Class: DrawSquare.java
//
//  Description: Used by main_Swing.java to display representation of shape 
//*******************************************************************

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;

public class DrawSquare extends JPanel {
    double edge;
    int eOut;

    public DrawSquare(double edge){
        this.edge = edge;
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(200,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // ensure shape can actually fit in frame
        while(edge > 100){
            edge = edge/2;
          }
        
        eOut = (int) edge;
        int x = 100 - (eOut / 2);
        int y = 100 - (eOut / 2);
        g.drawRect(x, y, eOut, eOut);
    }  
}

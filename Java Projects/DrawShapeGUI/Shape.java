/*
 * Author: Thomas Lindley 
 * Date: 06/30/2020
 * File: Shape.Java
 * 
 */
package lindley.project3;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

abstract class Shape extends Rectangle{
private Color color;
private boolean solid;
private static int count;

    public Shape(Rectangle rectangle, boolean solid, Color color ){
    this.solid = solid;
    this.color = color;
    setRect(rectangle.x, rectangle.y, rectangle.height, rectangle.width);
    count++;
    }
    public void setColor(Graphics g){
    g.setColor(this.color);
    }
    public boolean getSolid(){
    return this.solid;
    }
    public int getNoOfShpapes(){
    return count;
    }
    abstract void Draw(Graphics g);
}




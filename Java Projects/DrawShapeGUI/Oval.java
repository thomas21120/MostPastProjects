/*
 * Author: Thomas Lindley 
 * Date: 06/30/2020
 * File: Oval.Java
 * 
 */
package lindley.project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Oval extends Shape{
    public Oval(Rectangle rectangle, boolean solid, Color color){
    super(rectangle, solid, color);
    }
    @Override
    protected void Draw(Graphics g){
        setColor(g);
        if (getSolid()){
        g.drawOval(this.x, this.y, this.height, this.width);
        }else{
        g.fillOval(this.x, this.y, this.height, this.width);
        }
    }
}

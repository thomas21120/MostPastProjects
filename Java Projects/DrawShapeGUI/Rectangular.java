/*
 * Author: Thomas Lindley 
 * Date: 06/30/2020
 * File: Rectangular.Java
 * 
 */
package lindley.project3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rectangular extends Shape{
    public Rectangular(Rectangle rectangle, boolean solid, Color color){
    super(rectangle, solid, color);
    }
    @Override
    void Draw(Graphics g){
        setColor(g);
        if (getSolid()){
        g.drawRect(this.x, this.y, this.height, this.width);
        }else{
        g.fillRect(this.x, this.y, this.height, this.width);
        }
    }
}

/*
 * Author: Thomas Lindley 
 * Date: 06/30/2020
 * File: Drawing.Java
 * 
 */
package lindley.project3;
import java.awt.*;
import javax.swing.JPanel;

public class Drawing extends JPanel{
    Shape shape;
    @Override
    public void paintComponent(Graphics g){
    shape.Draw(g);
    g.setColor(Color.BLACK);
    g.drawString("" + shape.getNoOfShpapes(), 10, 10);
    }
    @Override
    public Dimension getPreferredSize(){
    Dimension size = new Dimension(200,200);
    return size;
    }
    void drawShape (Shape shape) throws Exception{
        if(contains(shape.x , shape.y) && contains(shape.x + shape.width, shape.y + shape.height)){
        this.shape = shape;
        repaint();
        }else{
            throw new OutsideBounds("Shape out of bounds.");
        }
    }
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ImageGUI extends JPanel {
  private int frameNumber;
  private long elapsedTMilli;
  private float pixelSize;

  static int translateX = 0;
    static int translateY = 0;
    static double rotation = 0.0;
    static double scaleX = 1.0;
    static double scaleY = 1.0;
    ImageCreate myImages = new ImageCreate();
    BufferedImage image_1 = myImages.getImage(ImageCreate.customImage1, Color.YELLOW);
    BufferedImage image_2 = myImages.getImage(ImageCreate.customImage2, Color.WHITE);
    BufferedImage image_3 = myImages.getImage(ImageCreate.customImage3, Color.MAGENTA);

    public static void main(String[] args) {
      JFrame window;
      window = new JFrame("Lindley Java Animations");
      window.setPreferredSize(new Dimension(800,600));
      final ImageGUI panel = new ImageGUI();
      window.setContentPane(panel);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.pack();
      window.setResizable(false);
      Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      window.setLocation(screen.width - window.getWidth() / 2,
        screen.height - window.getWidth() / 2);
      Timer timer;
      final long startTime = System.currentTimeMillis();

      timer = new Timer(1600, new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            if (panel.frameNumber > 4) {
                panel.frameNumber = 0;
            } else {
                panel.frameNumber++;
            }
            panel.elapsedTMilli = System.currentTimeMillis() - startTime;
            panel.repaint();
          }
        });
      window.setVisible(true);
      timer.start();
    }
  protected void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(Color.GRAY);
    g2.fillRect(0, 0, getWidth(), getHeight());

    // Controls your zoom and area you are looking at
    applyWindowToViewportTransformation(g2, -90, 90, -90, 90, true);

    AffineTransform savedTransform = g2.getTransform();
    System.out.println("Frame is " + frameNumber);
    switch (frameNumber) {
        case 1: // First frame is unmodified.
              translateX = 0;
              translateY = 0;
              scaleX = 1.0;
              scaleY = 1.0;
              rotation = 0;
            break;
        case 2: // Second frame translates each image by (-9, 5).
            translateX = -5;
            translateY = 7;
            break;
        case 3: // Third frame rotates each image by 60 degrees Counter
            translateX = -5;
            translateY = 7;
            rotation = 90*Math.PI / 180.0;
            break;
        case 4: // Third frame scale each image 2x for x, 0.5 for y
          translateX = -5;
          translateY = 7;
          rotation = 90*Math.PI / 180.0;
          scaleX = 2;
          scaleY = 0.5;
        break;
       // Can add more cases as needed 
        default:
            break;
    } // End switch
    g2.translate(translateX, translateY); // Move image.
    // To offset translate again
    g2.translate(0, 0);
    g2.rotate(rotation); // Rotate image.
    g2.scale(scaleX, scaleY); // Scale image.
    g2.drawImage(image_1, 0, 0, this); // Draw image.
    g2.setTransform(savedTransform);
    
    // Add another image
     g2.translate(translateX, translateY); // Move image.
    // To offset translate again
    // This allows you to place your images across your graphic
    g2.translate(-40,30);
    g2.rotate(rotation); // Rotate image.
    g2.scale(scaleX, scaleY); // Scale image.
    g2.drawImage(image_2, 0, 0, this); // Draw image.
    g2.setTransform(savedTransform);

    // Add another image
    g2.translate(translateX, translateY); // Move image.
    // To offset translate again
    // This allows you to place your images across your graphic
    g2.translate(40,30);
    g2.rotate(rotation); // Rotate image.
    g2.scale(scaleX, scaleY); // Scale image.
    g2.drawImage(image_3, 0, 0, this); // Draw image.
    g2.setTransform(savedTransform);
  }

  private void applyWindowToViewportTransformation(Graphics2D g2,
      double left, double right, double bottom, double top,
      boolean preserveAspect) {

    int width = getWidth();   // The width of this drawing area, in pixels.
    int height = getHeight(); // The height of this drawing area, in pixels.
    if (preserveAspect) {
      // Adjust the limits to match the aspect ratio of the drawing area.
      double displayAspect = Math.abs((double) height / width);
      double requestedAspect = Math.abs((bottom - top) / (right - left));
      if (displayAspect > requestedAspect) {
          // Expand the viewport vertically.
          double excess = (bottom - top) * (displayAspect / requestedAspect - 1);
          bottom += excess / 2;
          top -= excess / 2;
      } else if (displayAspect < requestedAspect) {
          // Expand the viewport vertically.
          double excess = (right - left) * (requestedAspect / displayAspect - 1);
          right += excess / 2;
          left -= excess / 2;
      }
    }
    g2.scale(width / (right - left), height / (bottom - top));
    g2.translate(-left, -top);
    double pixelWidth = Math.abs((right - left) / width);
    double pixelHeight = Math.abs((bottom - top) / height);
    pixelSize = (float) Math.max(pixelWidth, pixelHeight);
    }

}

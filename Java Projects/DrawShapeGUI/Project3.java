/*
 * Author: Thomas Lindley 
 * Date: 06/30/2020
 * File: Project3.Java
 * 
 */
package lindley.project3;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

/**
 *
 * @author Thoma
 */
public class Project3 extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Project3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCBShapeType = new javax.swing.JComboBox<>();
        jCBFillType = new javax.swing.JComboBox<>();
        jCBColor = new javax.swing.JComboBox<>();
        jTFWidth = new javax.swing.JTextField();
        jTFHeight = new javax.swing.JTextField();
        jTFXCoord = new javax.swing.JTextField();
        jTFYCoord = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        DrawingPanel = new javax.swing.JPanel();
        jBDraw = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Shape Type");

        jLabel2.setText("Fill Type");

        jLabel3.setText("Color");

        jLabel4.setText("Width");

        jLabel5.setText("Height");

        jLabel6.setText("X Coordinate");

        jLabel7.setText("Y Coordinate");

        jCBShapeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rectangle", "Oval" }));

        jCBFillType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hollow", "Solid" }));

        jCBColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBShapeType, 0, 144, Short.MAX_VALUE)
                    .addComponent(jCBFillType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFWidth)
                    .addComponent(jTFHeight)
                    .addComponent(jTFXCoord)
                    .addComponent(jTFYCoord))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCBShapeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jCBFillType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jCBColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTFWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTFHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTFXCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jTFYCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Drawing"));

        DrawingPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        DrawingPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        DrawingPanel.setOpaque(false);
        DrawingPanel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout DrawingPanelLayout = new javax.swing.GroupLayout(DrawingPanel);
        DrawingPanel.setLayout(DrawingPanelLayout);
        DrawingPanelLayout.setHorizontalGroup(
            DrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        DrawingPanelLayout.setVerticalGroup(
            DrawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DrawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(DrawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBDraw.setText("Draw");
        jBDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDrawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jBDraw)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBDraw)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDrawActionPerformed
        boolean hollow = true;
        int height = 0;
        int width = 0;
        int xCoord = 0;
        int yCoord = 0;
        Color color = Color.BLACK;
        String colors;
        
        if(jCBFillType.getSelectedItem().toString().equals("Solid")){
        hollow = false;
        }
        
        colors = jCBColor.getSelectedItem().toString();
        
        switch(colors){
            case "Black": color = Color.BLACK;
            break;
            case "Red": color = Color.RED;
            break;
            case "Orange": color = Color.ORANGE;
            break;
            case "Yellow": color = Color.YELLOW;
            break;
            case "Green": color = Color.GREEN;
            break;
            case "Blue": color = Color.BLUE;
            break;
            case "Magenta": color = Color.MAGENTA;
            break;
        }
        
        try{
            height = Integer.parseInt(jTFHeight.getText());
            width = Integer.parseInt(jTFWidth.getText());
            xCoord = Integer.parseInt(jTFXCoord.getText());
            yCoord = Integer.parseInt(jTFYCoord.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter numbers only.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        
        Rectangle shapes = new Rectangle(xCoord, yCoord, height, width);
        
        if (jCBShapeType.getSelectedItem().toString().equals("Rectangle")){
            Rectangular rect = new Rectangular(shapes, hollow, color);
                    try{
                        Drawing draw = new Drawing();
                        draw.setSize(draw.getPreferredSize());
                        draw.drawShape(rect);
                        DrawingPanel.removeAll();
                        DrawingPanel.add(draw);
                        DrawingPanel.repaint();
                    }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Shape out of Bounds.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
        }else{
            Oval oval = new Oval(shapes, hollow, color);
                    try{
                        Drawing draw = new Drawing();
                        draw.setSize(draw.getPreferredSize());
                        draw.drawShape(oval);
                        DrawingPanel.removeAll();
                        DrawingPanel.add(draw);
                        DrawingPanel.repaint();
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Shape out of Bounds.", "Error", JOptionPane.WARNING_MESSAGE);
                    }
        }
    }//GEN-LAST:event_jBDrawActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project3().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrawingPanel;
    private javax.swing.JButton jBDraw;
    private javax.swing.JComboBox<String> jCBColor;
    private javax.swing.JComboBox<String> jCBFillType;
    private javax.swing.JComboBox<String> jCBShapeType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTFHeight;
    private javax.swing.JTextField jTFWidth;
    private javax.swing.JTextField jTFXCoord;
    private javax.swing.JTextField jTFYCoord;
    // End of variables declaration//GEN-END:variables
}
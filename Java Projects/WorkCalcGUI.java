import javax.swing.*;
import java.awt.*;

public class Work extends JFrame{
    JLabel lblForce = new JLabel("Enter force (Newtons)");
    JLabel lblDistance = new JLabel("Enter distance (Meters)");
    JLabel lblTitle = new JLabel("Work Calculator", JLabel.CENTER);
    JLabel lblResult = new JLabel("Result (Joules)");
    JTextField tfForce = new JTextField(10);
    JTextField tfDistance = new JTextField(10);
    JTextField tfResult = new JTextField(10);
    JButton btnCalculate = new JButton("Calculate");
    JButton btnExit = new JButton("Exit");


    public Work(){
        JPanel TitlePanel = new JPanel();
        TitlePanel.add(lblTitle);
        add("North", lblTitle);

        JPanel ForceLabelPanel = new JPanel();
        ForceLabelPanel.setLayout(new GridLayout(3, 1, 0, 5));
        ForceLabelPanel.add(lblForce);
        ForceLabelPanel.add(lblDistance);
        ForceLabelPanel.add(lblResult);
        add("Center",  ForceLabelPanel);

        JPanel TextInPanel = new JPanel();
        TextInPanel.setLayout(new GridLayout(3, 1, 0, 5));
        TextInPanel.add(tfForce);
        tfForce.setToolTipText("Please use doubles (##.####)");
        TextInPanel.add(tfDistance);
        tfForce.setToolTipText("Please use doubles (##.####)");
        TextInPanel.add(tfResult);
        tfResult.setEditable(false);
        add("East",  TextInPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnCalculate);
        buttonsPanel.add(btnExit);
        add("South",  buttonsPanel);

        btnCalculate.addActionListener(e -> {
            double f = Double.parseDouble(tfForce.getText());
            double d = Double.parseDouble(tfForce.getText());
            double w = f*d;
            String outPut = Double.toString(w);
            tfResult.setText(outPut);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });
    }
    public static void main (String[] args){
        Work a = new Work();
        a.setTitle("Work!");
        a.setSize(300,200);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}

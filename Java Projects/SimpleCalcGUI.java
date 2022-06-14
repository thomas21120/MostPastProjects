
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalcGUI {
	// syntax of variables to be considered
	interface NumberInput {
		int numbers(int leftNumber, int rightNumber);
	}

	interface NameInput {
		String name(String firstName, String lastName);
	}

	public static class Multiply implements MyGui.NumberInput {
		public int numbers(int leftNumber, int rightNumber) {
			return leftNumber * rightNumber;
		}
	}

	public static class Divide implements MyGui.NumberInput {
		public int numbers(int leftNumber, int rightNumber) {
			return leftNumber / rightNumber;
		}
	}

	public static class NameEntry implements MyGui.NameInput {
		public String name(String firstName, String lastName) {
			return firstName + lastName;
		}
	}

	// initial configuration of frame
	public static class CoolFrame extends JFrame {
		static final int WIDTH = 300, HEIGHT = 300;

		public CoolFrame() {
			super("Cool Frame");
			setFrame(WIDTH, HEIGHT);
		}

		public CoolFrame(String title) {
			super(title);
			setFrame(WIDTH, HEIGHT);
		}

		public CoolFrame(String title, int width, int height) {
			super(title);
			setFrame(width, height);
		}

		public void display() {
			setVisible(true);
		}

		private void setFrame(int width, int height) {
			setSize(width, height);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	// Creates labels for input and output
	static class InputOutputPanel extends JPanel {
		private final TextEntryPanel scPanel;
		private final JLabel leftNumber = new JLabel("Left Number", JLabel.CENTER);
		private final JLabel rightNumber = new JLabel("Right Number", JLabel.CENTER);
		private final JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
		private final JTextField leftNumberTxt = new JTextField("");
		private final JTextField rightNumberTxt = new JTextField("");
		private final JTextField resultTxt = new JTextField("");
		private final JLabel firstName = new JLabel("First Name", JLabel.CENTER);
		private final JLabel lastName = new JLabel("Second Name", JLabel.CENTER);
		private final JLabel nameLbl = new JLabel("Result", JLabel.CENTER);
		private final JTextField firstNameTxt = new JTextField("");
		private final JTextField lastNameTxt = new JTextField("");
		private final JTextField nameResult = new JTextField("");

		public InputOutputPanel(TextEntryPanel scPanel) {
			this.scPanel = scPanel;
			setLayout(new GridLayout(2, 3));
			resultTxt.setBackground(Color.lightGray);
			resultTxt.setEditable(false);
			nameResult.setBackground(Color.lightGray);
			nameResult.setEditable(false);
			add(leftNumber);
			add(rightNumber);
			add(resultLbl);
			add(leftNumberTxt);
			add(rightNumberTxt);
			add(resultTxt);
			add(firstName);
			add(lastName);
			add(nameLbl);
			add(firstNameTxt);
			add(lastNameTxt);
			add(nameResult);
		}

		int getLeftNumberTxt() {
			return Integer.parseInt(leftNumberTxt.getText());
		}

		int getRightNumberTxt() {
			return Integer.parseInt(rightNumberTxt.getText());
		}

		String getFirstNameTxt() {
			return firstNameTxt.getText();
		}

		String getLastNameTxt() {
			return lastNameTxt.getText();
		}

		void setResultLbl(String label) {
			resultLbl.setText(label);
		}

		void setResultTxt(int result) {
			resultTxt.setText(String.valueOf(result));
		}

		void setNameTxt(String result) {
			nameResult.setText(result);
		}
	}

	// ButtonsPanel.java
	// Creates the button and tool tips parameters
	static class ButtonsPanel extends JPanel {
		private NumberInput binaryOpr;
		private NameEntry nameValue;
		private TextEntryPanel scPanel;
		private JButton multiplyBtn = new JButton("Multiply");
		private JButton divideBtn = new JButton("Divide");
		private JButton nameBtn = new JButton("Name");

		public ButtonsPanel(TextEntryPanel scPanel) {
			this.scPanel = scPanel;
			setLayout(new FlowLayout(FlowLayout.CENTER));
			multiplyBtn.setToolTipText("Add the two operands.");
			divideBtn.setToolTipText("Subtract the two operands.");
			nameBtn.setToolTipText("Displays first and last Name.");
			add(multiplyBtn);
			add(divideBtn);
			add(nameBtn);
			multiplyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setResultLbl("Product");
					binaryOpr = new Multiply();
					btnBinaryOprAction();
				}
			});
			divideBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setResultLbl("Quotient");
					binaryOpr = new Divide();
					btnBinaryOprAction();
				}
			});
			nameBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setResultLbl("Your Name");
					nameValue = new NameEntry();
					btnNameEntryAction();
				}
			});
		}

		public void setResultLbl(String label) {
			scPanel.ioPanel.setResultLbl(label);
		}

		public void btnBinaryOprAction() {
			int leftNumber = scPanel.ioPanel.getLeftNumberTxt();
			int rightNumber = scPanel.ioPanel.getRightNumberTxt();
			scPanel.ioPanel.setResultTxt(
					binaryOpr.numbers(leftNumber, rightNumber));
		}

		public void btnNameEntryAction() {
			String firstName = scPanel.ioPanel.getFirstNameTxt();
			String lastName = scPanel.ioPanel.getLastNameTxt();
			scPanel.ioPanel.setNameTxt(
					nameValue.name(firstName, " " + lastName));
		}
	}

	// TextEntryPanel.java
	// sets the parameters of where items are placed in frame
	static class TextEntryPanel extends JPanel {
		public InputOutputPanel ioPanel = new InputOutputPanel(this);
		public ButtonsPanel btnPanel = new ButtonsPanel(this);

		public TextEntryPanel() {
			setLayout(new BorderLayout());
			setBackground(Color.lightGray);
			add(ioPanel, BorderLayout.CENTER);
			add(btnPanel, BorderLayout.SOUTH);
		}
	}

	// TextEntryApplication.java
	// sets the initial window size when opening
	public static class TextEntryApplication extends CoolFrame {
		public TextEntryApplication() {
			super("Text Entry Application", 600, 120);
			add(new TextEntryPanel());
		}
	}

	static public void main(String[] args) {
		TextEntryApplication scApp = new TextEntryApplication();
		scApp.display();
	}
}
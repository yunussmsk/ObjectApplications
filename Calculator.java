import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends Application implements ActionListener {

	private JTextField show = new JTextField();
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton b0 = new JButton("0");
	private JButton bDot = new JButton(".");
	private JButton bEq = new JButton("=");
	private JButton bAdd = new JButton("+");
	private JButton bSub = new JButton("-");
	private JButton bDiv = new JButton("/");
	private JButton bMult = new JButton("*");
	private JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
	private String text = "";
	private Double first;
	private char operation;

	public Calculator() {
		super("Calculator", 300, 300);
		setLocation();

		setLayout(new BorderLayout(5, 5));

		show.setEditable(false);

		addingButtons();
		addingListener();

		add(show, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}

	public void setLocation() { // Overriding
		this.setLocation(200, 200);
	}

	public void addingListener() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		bDot.addActionListener(this);
		bAdd.addActionListener(this);
		bSub.addActionListener(this);
		bDiv.addActionListener(this);
		bEq.addActionListener(this);
		bMult.addActionListener(this);
	}

	public void addingButtons() {
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(bDiv);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(bMult);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(bSub);
		panel.add(bDot);
		panel.add(b0);
		panel.add(bEq);
		panel.add(bAdd);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b7)
			text += "7";
		if (e.getSource() == b8)
			text += "8";
		if (e.getSource() == b9)
			text += "9";
		if (e.getSource() == b4)
			text += "4";
		if (e.getSource() == b5)
			text += "5";
		if (e.getSource() == b6)
			text += "6";
		if (e.getSource() == b1)
			text += "1";
		if (e.getSource() == b2)
			text += "2";
		if (e.getSource() == b3)
			text += "3";
		if (e.getSource() == b0)
			text += "0";
		if (e.getSource() == bDot && text.length() != 0 && !text.contains("."))
			text += ".";
		if (e.getSource() == bAdd) {
			first = Double.parseDouble(text);
			operation = '+';
			text = "";
		}
		if (e.getSource() == bSub) {
			first = Double.parseDouble(text);
			operation = '-';
			text = "";
		}
		if (e.getSource() == bMult) {
			first = Double.parseDouble(text);
			operation = '*';
			text = "";
		}
		if (e.getSource() == bDiv) {
			first = Double.parseDouble(text);
			operation = '/';
			text = "";
		}
		if (e.getSource() == bEq) {
			switch (operation) {
			case '+':
				text = String.valueOf(first + Double.parseDouble(text));
				break;
			case '-':
				text = String.valueOf(first - Double.parseDouble(text));
				break;
			case '*':
				text = String.valueOf(first * Double.parseDouble(text));
				break;
			case '/':
				text = String.valueOf(first / Double.parseDouble(text));
				break;
			}
		}

		show.setText(text);
	}

}

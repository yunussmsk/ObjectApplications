import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppShop extends JFrame implements ActionListener {

	private static JButton st = new JButton("String App");
	private static JButton cal = new JButton("Calculator");
	private static JButton mou = new JButton("Mouse App");
	private static JButton type = new JButton("Typing App");

	private static StringApp stApp = new StringApp();
	private static Calculator calApp = new Calculator();
	private static MouseApp mouApp = new MouseApp();
	private static TypingApp typeApp;

	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame("Entertainment");

		frame.setSize(700, 600);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(3, 3, 10, 10));

		typeApp = new TypingApp();

		st.addActionListener(new AppShop());
		cal.addActionListener(new AppShop());
		mou.addActionListener(new AppShop());
		type.addActionListener(new AppShop());
		
		frame.add(new JLabel());
		frame.add(st);
		frame.add(new JLabel());
		frame.add(cal);
		frame.add(new JButton("Applications"));
		frame.add(mou);
		frame.add(new JLabel());
		frame.add(type);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == st) {
			stApp = new StringApp();
			stApp.setVisible(true);
		}
		if (event.getSource() == cal) {
			calApp = new Calculator();
			calApp.setVisible(true);
		}
		if (event.getSource() == mou) {
			mouApp = new MouseApp();
			mouApp.setVisible(true);
		}
		if (event.getSource() == type) {
			try {
				typeApp = new TypingApp();
			} catch (IOException e) {
			}
			typeApp.setVisible(true);
		}
	}

}

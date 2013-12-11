import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TypingApp extends Application implements KeyListener {

	private JLabel timer = new JLabel("60");
	private JLabel label1 = new JLabel("The Word:");
	private JLabel word = new JLabel("");
	private JLabel label2 = new JLabel("What You Type:");
	private JLabel usersInput = new JLabel("");
	private JButton button = new JButton("Start test!");

	private String words[];
	private Timer time;
	private int count = -1;
	private int correct = -1;

	public TypingApp() throws IOException {
		super("Typing App", 300, 300);

		assigningWordsToArray();

		setLayout(new BorderLayout());

		word.setFont(new Font("", Font.PLAIN, 30));
		usersInput.setFont(new Font("", Font.PLAIN, 30));

		JPanel panel = new JPanel(new GridLayout(4, 1));
		panel.add(label1);
		panel.add(word);
		panel.add(label2);
		panel.add(usersInput);

		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.getText().equals("0")) {
					time.stop();
					JOptionPane.showMessageDialog(null, "You typed "
							+ count + " words in 60 seconds. " + correct + " of them was correct.");
					button.setEnabled(false);
				} else
					timer.setText(String.valueOf(Integer.parseInt(timer
							.getText()) - 1));
			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(!time.isRunning())
					time.start();
				if (word.getText().equalsIgnoreCase(usersInput.getText().trim()))
					correct++;
				count++;
				word.setText(words[(int) (Math.random() * words.length)]);
				usersInput.setText("");
			}
		});

		button.addKeyListener(this);

		add(timer, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}

	public void assigningWordsToArray() throws IOException {

		File file = new File("text.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String text = "";
		String line = reader.readLine();

		while (line != null) {
			text += line;
			line = reader.readLine();
		}

		words = text.split(" ");
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE
				&& usersInput.getText().length() > 1)
			usersInput.setText(usersInput.getText().substring(0,
					usersInput.getText().length() - 2));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_SPACE
				&& e.getKeyCode() != KeyEvent.VK_BACK_SPACE)
			usersInput.setText(usersInput.getText() + e.getKeyChar());
	}

}

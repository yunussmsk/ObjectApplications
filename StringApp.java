import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.*;

public class StringApp extends Application implements ActionListener {

	private String text[];
	private int i = 1;
	private String textArea = "";
	private JTextArea area = new JTextArea(
			"Shows what you type here with upperletters\n and one-by-one...");
	private JTextField field = new JTextField("Type Here!");
	private final Timer time;

	public StringApp() {
		super("String App", 300, 300);
		setLocation();

		setLayout(new BorderLayout());

		time = new Timer(500, this);

		area.setEditable(false);
		field.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text = field.getText().toUpperCase().split("");
				field.setText("");
				field.setEditable(false);
				time.start();
			}
		});

		add(area, BorderLayout.CENTER);
		add(field, BorderLayout.SOUTH);
	}

	public void setLocation() {
		this.setLocation(500, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		textArea += text[i];
		i++;

		area.setText(textArea);

		if (i == text.length) {
			field.setEditable(true);
			i = 1;
			time.stop();
		}
	}

}

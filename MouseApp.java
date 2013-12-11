import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class MouseApp extends Application implements ActionListener {

	private Image img;
	private Image imgUp = (new ImageIcon("movingUp.png")).getImage();
	private Image imgDown = (new ImageIcon("movingDown.png")).getImage();
	private Image imgRight = (new ImageIcon("movingRight.png")).getImage();
	private Image imgLeft = (new ImageIcon("movingLeft.png")).getImage();
	private Image cheese = (new ImageIcon("cheese.png")).getImage();

	private JLabel label1 = new JLabel("Time:");
	private JLabel label2 = new JLabel("0");
	private JLabel label3 = new JLabel("Score:");
	private JLabel label4 = new JLabel("0");

	private Timer time;
	private Timer time2 = new Timer(0, this);

	private int x = 0, y = 0, xCh = (int) (Math.random() * 250),
			yCh = (int) (Math.random() * 250);
	Panel p = new Panel();

	public MouseApp() {
		super("Mouse App", 300, 300);
		setLayout(new BorderLayout());

		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				label2.setText(String.valueOf(Integer.parseInt(label2.getText()) + 1));
			}
		});

		img = imgRight;

		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);

		addKeyListener(p);

		add(panel, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		pack();
		time.start();
		time2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (label2.getText().equals("60")) {

			JOptionPane.showMessageDialog(null,
					"Your Score: " + label4.getText());
			time.stop();
		}

		if (x - xCh < 35 && xCh - x < 50 && y - yCh < 35 && yCh - y < 50) {
			xCh = (int) (Math.random() * 250);
			yCh = (int) (Math.random() * 250);
			label4.setText(String.valueOf(Integer.parseInt(label4.getText()) + 1));
			repaint();
		}

	}

	private class Panel extends JPanel implements KeyListener {

		public Panel() {
			setBackground(Color.WHITE);
			setPreferredSize(new Dimension(300, 300));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(cheese, xCh, yCh, 35, 35, null);
			g.drawImage(img, x, y, 50, 50, null);

		}

		@Override
		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				img = imgUp;
				y -= 5;
				if (outOfPanel())
					y += 5;
				break;
			case KeyEvent.VK_DOWN:
				img = imgDown;
				y += 5;
				if (outOfPanel())
					y -= 5;
				break;
			case KeyEvent.VK_RIGHT:
				img = imgRight;
				x += 5;
				if (outOfPanel())
					x -= 5;
				break;
			case KeyEvent.VK_LEFT:
				img = imgLeft;
				x -= 5;
				if (outOfPanel())
					x += 5;
				break;
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	public boolean outOfPanel() {
		return (x < 0 || y < 0 || x > 250 || y > 250);
	}
}

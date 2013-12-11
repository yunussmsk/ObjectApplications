import javax.swing.JFrame;

public class Application extends JFrame {

	protected String title;
	protected int width;
	protected int height;

	public Application(String t, int w, int h) {

		title = t;
		width = w;
		height = h;

		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation();
		setVisible(false);
		setResizable(false);

	}

	public void setLocation() {
		this.setLocationRelativeTo(null);
	}

}

package assessment;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	private int duration;
	
	public SplashScreen(int duration) {
		this.duration = duration;
	}
	public Color blueBorder = new Color(0, 0, 128, 255);
	public Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
	public void drawSplash() {
		int width = 225;
		int height = 225;
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		JLabel image = new JLabel(new ImageIcon("loading.gif"));
		JLabel title = new JLabel("STORE MANAGER DEMO", SwingConstants.CENTER);
		JPanel content = (JPanel) getContentPane();
		content.setBackground(Color.white);
		content.add(image, BorderLayout.CENTER);
		content.add(title, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createLineBorder(blueBorder, 4));
		title.setFont(new Font("Dialog", Font.BOLD, 16));
	}
	public void timeOut() {
		setVisible(true);
		try {
			Thread.sleep(duration);
		} 
		catch (Exception e) {
			System.exit(0);
		}
		setVisible(false);
	}
	public void showSplash() {
		drawSplash();
		timeOut();
	}
}
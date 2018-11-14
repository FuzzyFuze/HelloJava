package assessment;

import java.awt.*;																		// imports jdk abstract window tools module
import javax.swing.*;																	// imports jdk GUI wisget module

public class SplashScreen extends JWindow {												// SplashScreen class inherits imported object class

	private static final long serialVersionUID = 1L;									// auto-generated serialization attribute
	private int duration;																// integer attribute to control screen timer
	
	public SplashScreen(int duration) {													// constructor to initialize SplashScreen object with duration set
		this.duration = duration;														// pickup parameter at instantiation time and assign to object
	}
	public Color blueBorder = new Color(0, 0, 128, 255);								// instantiate Color object with RGBA attributes set
	public Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();		// instantiate Dimension object as a default toolkit component
	
	public void drawSplash() {															// method to draw the SplashScreen content
		int width = 225;																// declare integer to hold value for width
		int height = 225;																// declare integer to hold value for height
		int x = (screen.width - width) / 2;												// declare integer as screen width calculation for display width
		int y = (screen.height - height) / 2;											// declare integer as screen height calculation for display height
		setBounds(x, y, width, height);													// set the boundaries for the SplashScreen
		JLabel image = new JLabel(new ImageIcon("loading.gif"));						// instantiate JLabel ImageIcon object with file source
		JLabel title = new JLabel("STORE MANAGER DEMO", SwingConstants.CENTER);			// instantiate JLabel text object with String argument and center it
		JPanel content = (JPanel) getContentPane();										// assign JPanel method call to define a ContentPane
		content.setBackground(Color.white);												// set the background color of the ContentPane
		content.add(image, BorderLayout.CENTER);										// add the instance of 'image' to the ContentPane and center it
		content.add(title, BorderLayout.SOUTH);											// add the instance of 'title' to the ContentPane and align it 
		content.setBorder(BorderFactory.createLineBorder(blueBorder, 4));				// set the border of the ContentPane and set the color to 'blueBorder'
		title.setFont(new Font("Dialog", Font.BOLD, 16));								// set the font of 'title'
	}
	public void timeOut() {																// method to set the SplashScreen timer
		setVisible(true);																// boolean state to make the SplashScreen visible
		try {																			// try to execute next line
			Thread.sleep(duration);														// sleep for 'duration' (as set at SplashScreen instantiation time)
		} 
		catch (Exception e) {															// catch Exceptions if the try fails
			System.exit(0);																// exit from the runtime
		}
		setVisible(false);																// when try is sucessful, make the SplashScreen invisible
	}
	public void showSplash() {															// method to call the previous methods
		drawSplash();
		timeOut();
	}
} // end of class
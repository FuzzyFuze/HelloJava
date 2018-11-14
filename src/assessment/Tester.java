package assessment;

import java.io.FileNotFoundException;

public class Tester {
	
	public static void main(String[] args) throws FileNotFoundException {
        SplashScreen splash = new SplashScreen(3300);
        UI ui = new UI();
        splash.showSplash();
		ui.initArray();
		ui.startMenu();
	}
}
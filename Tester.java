package assessment;

import java.io.FileNotFoundException;										// imports jdk '404' module (auto-generated)

public class Tester {

    public static void main(String[] args) throws FileNotFoundException {	// main method - throws '404' (auto-generated)
        SplashScreen splash = new SplashScreen(3300);						// instantiate SplashScreen object
        UI ui = new UI();													// instantiate UI object
        splash.showSplash();												// call showSplash() method
        ui.initArray();														// call initArray() method
        ui.startMenu();														// call startMenu() method
    }
} // end of class
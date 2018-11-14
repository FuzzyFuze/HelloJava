package assessment;
																		// import all the jdk modules the package needs to run the 
																		// componentry of the UI (User Interface)
import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class UI {														// the base class of UI - not inherited, derived or abstract
																		// this class is used by the Tester class at runtime when instantiated
	private ArrayList<Location> loc = new ArrayList<Location>();		// private attribute to hold ArrayLists of Location objects
	private ArrayList<Product> product = new ArrayList<Product>();		// private attribute to hold ArrayLists of Product objects
	private int startSelection;											// declare integer for use in menu selsctions
	private int storeSelection;											// declare integer for use in menu selsctions
	private int invSelection;											// declare integer for use in menu selsctions
	private String brand;												// declare String attributes for use in methods
	private String desc;												// *
	private String grade;												// *
	private double weight;												// declare double attributes for use in methods
	private double price;												// *
	private int pieces;													// declare integer attributes for use in methods
	private int volume;													// *
	private int drawers;												// *
	private int quantity;												// *
	private boolean hasFinished = false;								// declare boolean(s) with default states
	private boolean isChoosing = false;									// *
	private boolean isRunning = true;									// *
	private boolean hasTools;											// declare a boolean with no set state

	public void zeroItem() {											// error dialog when user enters no values to int or double paramaters
		JOptionPane.showMessageDialog(null, "Error - value must be greater than 0!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public void invalidSel() {											// error dialog for when user makes otherwise invalid selections
		System.out.println("Invalid Selection!");
		JOptionPane.showMessageDialog(null, "\n Invalid Selection! \n", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void quit() {												// method to exit application
		isRunning = false;												// close loops with boolean states
		isChoosing = false;
		hasFinished = true;
		JOptionPane.showMessageDialog(null, "Exit Application...\n", "Good-bye!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);													// exit to OS or IDE
	}

	public void goBack() throws FileNotFoundException {					// method to navigate back to main menu
		isRunning = true;												// switch boolean state
		JOptionPane.showMessageDialog(null, "Back to Main Menu\n", "Back...", JOptionPane.INFORMATION_MESSAGE);
		startMenu();
	}

	public void showAbout() {											// method to display About dialog
		JOptionPane.showMessageDialog(null,
				"- Demo Application for Store/Inventory management\n- Developed by Shannon Davies\n- Public License 2018",
				"About Store Manager:", JOptionPane.INFORMATION_MESSAGE);
	}

	public void inputHasTools() {										// method to get user input and assign a boolean state for Toolbox objects
		int reply = JOptionPane.showConfirmDialog(null, "Does the toolbox include tools?", "Information required",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			hasTools = true;											// if user indicates 'Yes' then state is true
		} else {
			hasTools = false;											// else user has selected 'No' then state is false
		}
	}

	public void inputGrade() throws FileNotFoundException {				// method to get user input and assign a String value
		do {															// commence a 'do' loop
			grade = null;												// nullify the state of the String
			grade = JOptionPane.showInputDialog(null, "\nOil Grade:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (grade != null) {										// if input was entered
				try {													// check if the operation was successful
					System.out.println("You entered: " + grade);		// write to console 
				} catch (final Exception e) {							// otherwise operation was unsuccessful
					invalidSel();										// call invalidSel() method
				}
			} else {
				goBack();												// else the user may have cancelled or unknown condition is met
			}															// return to the Main Menu
		} while (grade == "" || grade == null);							// evaluate the loop until the criteria is met
	}

	public void inputStrings() throws FileNotFoundException {			// method to get user input and assign two String values
		do {															// commence a 'do' loop
			brand = null;												// nullify the state of the String
			brand = JOptionPane.showInputDialog(null, "\nEnter the brand name:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (brand != null) {										// if input was entered
				try {													// check if the operation was successful
					System.out.println("You entered: " + brand);		// write to console 
				} catch (final Exception e) {							// otherwise operation was unsuccessful
					invalidSel();										// call invalidSel() method
				}
			} else {													// else the user may have cancelled or unknown condition is met
				goBack();												// return to the Main Menu
			}
		} while (brand == "" || brand == null);							// evaluate the loop until the criteria is met

		do {															// same method pattern as the previous two methods
			desc = null;
			desc = JOptionPane.showInputDialog(null, "\nEnter a brief description:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (desc != null) {
				try {
					System.out.println("You entered: " + desc);
				} catch (final Exception e) {
					invalidSel();
				}
			} else {
				goBack();
			}
		} while (desc == "" || desc == null);
	}

	public void inputDoubles() {											// method to get user input and assign two double values
		do {																// commence a 'do' loop
			weight = 0;														// set value of 'weight' to 0
			String validWeight = JOptionPane.showInputDialog(null, "\nItem weight:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validWeight != null) {										// if input was entered
				try {														// check if the operation was successful
					double doubleWeight = Double.parseDouble(validWeight);	// parse the double to the validation String
					weight = doubleWeight;									// store the validated input in the 'weight' attribute
				} catch (final Exception e) {								// otherwise catch an illegal or fatal Exception
					invalidSel();											// call invalidSel() method (user dialog)
				}
			}
			if (weight <= 0) {												// if the 'weight' input was less than or equal to zero
				zeroItem();													// call zeroItem() method (user dialog)
			}
		} while (weight <= 0);												// evaluate this loop until the condition is met
		do {																// *
			price = 0;														// same method pattern as the above method
			String validPrice = JOptionPane.showInputDialog(null, "\nItem price:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validPrice != null) {
				try {
					double doublePrice = Double.parseDouble(validPrice);
					price = doublePrice;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (price <= 0) {
				zeroItem();
			}
		} while (price <= 0);
	}

	public void inputDrawers() {											// method to get user input and assign an integer value
		do {																// same method pattern as the above method only with integer input
			drawers = 0;
			String validDrawers = JOptionPane.showInputDialog(null, "\nNo Of Drawers:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validDrawers != null) {
				try {
					double doubleDrawers = Double.parseDouble(validDrawers);
					drawers = (int) doubleDrawers;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (drawers <= 0) {
				zeroItem();
			}
		} while (drawers <= 0);
	}

	public void inputVolume() {												// method to get user input and assign an integer value
		do {																// same method pattern as the above method
			volume = 0;
			String validVolume = JOptionPane.showInputDialog(null, "\nVolume:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validVolume != null) {
				try {
					double doubleVolume = Double.parseDouble(validVolume);
					volume = (int) doubleVolume;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (volume <= 0) {
				zeroItem();
			}
		} while (volume <= 0);
	}

	public void inputPieces() {
		do {
			pieces = 0;
			String validPieces = JOptionPane.showInputDialog(null, "\nNo Of Pieces:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validPieces != null) {
				try {
					double doublePieces = Double.parseDouble(validPieces);
					pieces = (int) doublePieces;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (pieces <= 0) {
				zeroItem();
			}
		} while (pieces <= 0);
	}

	public void inputQty() {												// method to get user input and assign an integer value
		do {																// same method pattern as the above two methods
			quantity = 0;
			String validQuantity = JOptionPane.showInputDialog(null, "\nQuantity in stock:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validQuantity != null) {
				try {
					double doubleQuantity = Double.parseDouble(validQuantity);
					quantity = (int) doubleQuantity;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (quantity <= 0) {
				zeroItem();
			}
		} while (quantity <= 0);
	}

	public void addItem() {														// method to add items to the ArrayList<Product> attribute
		switch (invSelection) {													// switch case depending on the user selection input criteria
		case 1:																	// incase of 1 add an instance of BaseProduct to the ArrayList
			product.add(new BaseProduct(brand, desc, weight, price, quantity));
			break;
		case 2:																	// incase of 2 add an instance of Toolkit to ArrayList
			product.add(new Toolkit(brand, desc, weight, price, quantity, pieces));
			break;
		case 3:																	// incase of 3 add an instance of Consumable to ArrayList
			product.add(new Consumable(brand, desc, weight, price, quantity, volume, grade));
			break;
		case 4:																	// incase of 4 add an instance of Toolbox to ArrayList
			product.add(new Toolbox(brand, desc, weight, price, quantity, drawers, hasTools));
			break;
		default:																// the default calls the invalidSel() method because no 
			invalidSel();														// evaluation has taken place
		}
		JOptionPane.showMessageDialog(null, "Product stored in inventory", "Stock Item Added",
				JOptionPane.INFORMATION_MESSAGE);								// after the switch case is evaluated, show a dialog message
	}

	public void removeItem() {													// method to remove the last item from the ArrayList
		try {
			JOptionPane.showMessageDialog(null, "Last product removed from list:\n" + product.get(product.size() - 1),	// display the last item (-1)
					"Stock Item Removed", JOptionPane.INFORMATION_MESSAGE);												// display the message
			product.remove(product.size() - 1);									// target the last item (-1) on the list
		} catch (final Exception e) {
			invalidSel();														// if it fails, catch any Exceptions and call invalidSel()
		}
	}

	public void clearList() throws FileNotFoundException {						// method to clear whole ArrayList
		int remAll = JOptionPane.showConfirmDialog(null, "Clear the inventory?", "Are you sure?",
				JOptionPane.YES_NO_OPTION);										// YES/NO dialog with user
		if (remAll == JOptionPane.YES_OPTION && product.size() > 0) {			// If the user answers yes and list items exist
			try {
				product.removeAll(product);																				// attempt to remove all products
				JOptionPane.showMessageDialog(null, "Inventory Clear", "Cleared", JOptionPane.INFORMATION_MESSAGE);		// display the message
			} catch (final Exception e) {
				invalidSel();																							// otherwise call invalidSel()
			}
		} else {																			
			JOptionPane.showMessageDialog(null, "No records changed", "No change to inventory",							// if evaluation is skipped
					JOptionPane.INFORMATION_MESSAGE);																	// no items were affected
			inventoryMenu();																							// return to inventory menu 
		}
	}

	public void confirmRem() throws FileNotFoundException {						// method to ask user to confirm an action
		int remItem = JOptionPane.showConfirmDialog(null, "Remove the last item created?", "Are you sure?",
				JOptionPane.YES_NO_OPTION);
		if (remItem == JOptionPane.YES_OPTION) {
			removeItem();														// if the respones is yes, execute the method
		} else {
			JOptionPane.showMessageDialog(null, "No records changed", "No change to inventory",
					JOptionPane.INFORMATION_MESSAGE);
			inventoryMenu();													// if the response is no, return to inventory menu
		}
	}

	public void editList() throws FileNotFoundException {						// method to call each method when creating a list object of Product
		inputStrings();															// it calls each method in sequence to construct an instance of Product
		inputDoubles();
		if (invSelection == 2) {
			inputPieces();
		} else if (invSelection == 3) {
			inputVolume();
			inputGrade();
		} else if (invSelection == 4) {
			inputDrawers();
			inputHasTools();
		}
		inputQty();
		addItem();																// at the end, the method addItem() is called
	}

	public void promptUser() throws FileNotFoundException {						// method to prompt a user if they would like to add another item
		int reply = JOptionPane.showConfirmDialog(null, "Add Another Item?", "Make Selection",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			editList();															// call the editList() method again
		} else {
			inventoryMenu();													// otherwise go back to inventory menu
		}
	}

	public void outputStream() throws FileNotFoundException {					// method to create a FileOutputSteam and PrintStream
		File file = new File("output.txt");										// create a file called 'output.txt'
		FileOutputStream fos = new FileOutputStream(file);						// assign 'fos' with an instance of FileOutputStream
		PrintStream ps = new PrintStream(fos);									// assign 'ps' with an instance of PrintStream
		System.setOut(ps);														// catch the output of the next s.o.p call
	}																			// * NOTE - this is boilerplate code from stack over flow forum!
																				// However, I do understand how its being used and why the imports are needed
	public void printToFile() throws FileNotFoundException {					// method to assemble the content for the text file output
		if (storeSelection == 1) {
			loc.get(0).setProduct(product);										// assign the current product list to Location based on storeSelection(1)
			outputStream();														// call the outputStream() method
			System.out.print(loc.get(0));										// generate the output for the awaiting output stream
		} else if (storeSelection == 2) {										// same as above only for storeSelection(2)
			loc.get(1).setProduct(product);
			outputStream();
			System.out.print(loc.get(1));
		} else if (storeSelection == 3) {										// same as above only for storeSelection(3)
			loc.get(2).setProduct(product);
			outputStream();
			System.out.print(loc.get(2));
		} else {
			invalidSel();														// otherwise call invalidSel() method
		}
		JOptionPane.showMessageDialog(null, "List Exported", "Output to File", JOptionPane.INFORMATION_MESSAGE);	// confirmation dialog
	}

	public int startManager() {													// method to create the Main Menu
		startSelection = 0;														// selection set to 0 position
		String stringSelection = JOptionPane.showInputDialog(null,				// create the dialog window with the following attributes
				"======== STORE MANAGEMENT ========\n\n" + "1. Manage Stores\n" + "2. About\n" + "3. Quit\n\n",
				"Main Menu", JOptionPane.PLAIN_MESSAGE);
		if (stringSelection != null) {
			try {																// if in put was entered, attempt to execute the next line
				startSelection = Integer.parseInt(stringSelection.trim());		// validate the String input
			} catch (final Exception e) {
				invalidSel();													// otherwise the selection criteria was not met 
			}																	// call invalidSel() method
		} else {
			quit();																// call quit() method to exit the application
		}
		return startSelection;													// the valid result is returned to the 'startSelection' integer
	}

	public int invManager() throws FileNotFoundException {						// method to create the Inventory Menu
		invSelection = 0;														// same method pattern as the Main Menu above
		String stringSelection = JOptionPane.showInputDialog(null,
				"======== INVENTORY ========\n\n" + "1. Add new product\n" + "2. Add new kit\n"
						+ "3. Add new consumable\n" + "4. Add new toolbox\n" + "5. Remove last item\n"
						+ "6. Export Stock List\n" + "7. Display All items\n" + "8. Clear List\n"
						+ "9. Back to Main Menu\n\n" + "Input selection, and press OK:",
						"Inventory Manager", JOptionPane.PLAIN_MESSAGE);
		if (stringSelection != null) {
			try {
				invSelection = Integer.parseInt(stringSelection.trim());
			} catch (final Exception e) {
				invalidSel();
			}
		} else {
			goBack();															// goBack() method called instead of quit() method
		}
		return invSelection;
	}

	public int storeManager() throws FileNotFoundException {					// method to create Store Selection Menu
		storeSelection = 0;														// same method pattern as the above menu methods
		String stringSelection = JOptionPane.showInputDialog(null,
				"======== SELECT STORE ========\n\n" + "1. Coburg North Warehouse\n" + "2. Richmond Store\n"
						+ "3. Preston Store\n" + "4. Back to Main Menu\n\n",
						"Store Manager", JOptionPane.PLAIN_MESSAGE);
		if (stringSelection != null) {
			try {
				storeSelection = Integer.parseInt(stringSelection.trim());
			} catch (final Exception e) {
				invalidSel();
			}
		} else {
			goBack();
		}
		return storeSelection;
	}

	public void inventoryMenu() throws FileNotFoundException {					// the logic switch case method to handle the Inventory Menu selections 
		while (!hasFinished) {													// while boolean state is false
			invSelection = invManager();										// assign selection value returned from invManager()
			switch (invSelection) {
			case 1:																// if the selection case is 1
				while (invSelection == 1) {										// while it's still 1
					editList();													// call editList()
					promptUser();												// then call promptUser();
				}
				break;
			case 2:																// do the same for selection case 2
				while (invSelection == 2) {
					editList();
					promptUser();
				}
				break;
			case 3:																// and the same for selection case 3
				while (invSelection == 3) {
					editList();
					promptUser();
				}
				break;
			case 4:																// and selection case 4
				while (invSelection == 4) {
					editList();
					promptUser();
				}
				break;
			case 5:																// if selection case 5
				confirmRem();													// confirmRem() is called to assert user actions
				break;
			case 6:																// if selection case 6
				printToFile();													// call printToFile() method to output text file
				break;
			case 7:
				System.out.println("Selection: " + invSelection);				// if selection case 7
				JOptionPane.showMessageDialog(null, "Displaying inventory ...", "In Stock",
						JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < product.size(); i++) {						// display each inventory item the ArrayList<Product> using for loop
					JOptionPane.showMessageDialog(null, product.get(i), "Item Details",
							JOptionPane.INFORMATION_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "There are " + product.size() + " entries(s) in the list",
						"Total entries", JOptionPane.INFORMATION_MESSAGE);		// display a tally for total list entries
				break;
			case 8:																// if selection case 8
				clearList();													// call clearList() method
				break;
			case 9:
				goBack();														// if case 9 go back to Main Menu interaction dialog
				break;
			default:
				invalidSel();													// default method call is to invalidSel()
			}
		}
	}

	public void chooseStore() throws FileNotFoundException {					// the logic switch case method to handle Store Selections
		while (isChoosing) {													// while boolean state is true
			storeSelection = storeManager();									// assign selection value returned from storeManager()
			switch (storeSelection) {
			case 1:																// if selection case 1
				while (storeSelection == 1) {									// while selection case remains as 1
					inventoryMenu();											// call the inventoryMenu() method
				}
				break;
			case 2:
				while (storeSelection == 2) {									// as above but for case 2
					inventoryMenu();
				}
				break;
			case 3:																// as above but for case 3
				while (storeSelection == 3) {
					inventoryMenu();
				}
				break;
			case 4:																// case 4 back to Main Menu
				goBack();
				break;
			default:
				invalidSel();													// default calls invalidSel() method
			}
		}
	}

	public void initArray() {													// method to initialize the ArrayList<Location> attribute
		loc.add(new Location("Warehouse", "233", "Factory Drive", "Coburg North", "VIC", "3058", "(03)97662000", null));
		loc.add(new Location("Store", "125", "Swan Street", "Richmond", "VIC", "3121", "(03)98992100", null));
		loc.add(new Location("Store", "175", "St. Georges Road", "Preston", "VIC", "3072", "(03)97662200", null));
	}																			// instantiated and stored three Location object instances

	public void startMenu() throws FileNotFoundException {						// logic switch case method to handle Main Menu selections
		while (isRunning) {														// while boolean state is true
			startSelection = startManager();									// assigned selection value returned from startManager()
			switch (startSelection) {
			case 1:																// if selection case 1
				isRunning = false;												// switch boolean state to false
				isChoosing = true;												// switch boolean state to true
				chooseStore();													// call chooseStore() method
				break;
			case 2:																// if case 2
				showAbout();													// call showAbout() method
				break;
			case 3:																// if case 3
				quit();															// Exit the application
				break;
			default:
				invalidSel();													// default call invalidSel()
			}
		}
	}
} // end of class
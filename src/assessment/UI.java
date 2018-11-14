package assessment;

import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class UI {

	private ArrayList<Location> loc = new ArrayList<Location>();
	private ArrayList<Product> product = new ArrayList<Product>();
	private int startSelection;
	private int storeSelection;
	private int invSelection;
	private String brand;
	private String desc;
	private String grade;
	private double weight;
	private double price;
	private int pieces;
	private int volume;
	private int drawers;
	private int quantity;
	private boolean hasFinished = false;
	private boolean isChoosing = false;
	private boolean isRunning = true;
	private boolean hasTools;

	public void zeroItem() {
		JOptionPane.showMessageDialog(null, "Error - value must be greater than 0!", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public void invalidSel() {
		System.out.println("Invalid Selection!");
		JOptionPane.showMessageDialog(null, "\n Invalid Selection! \n", "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void quit() {
		isRunning = false;
		isChoosing = false;
		hasFinished = true;
		JOptionPane.showMessageDialog(null, "Exit Application...\n", "Good-bye!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	public void goBack() throws FileNotFoundException {
		isRunning = true;
		JOptionPane.showMessageDialog(null, "Back to Main Menu\n", "Back...", JOptionPane.INFORMATION_MESSAGE);
		startMenu();
	}

	public void showAbout() {
		JOptionPane.showMessageDialog(null,
				"- Demo Application for Store/Inventory management\n- Developed by Shannon Davies\n- Public License 2018",
				"About Store Manager:", JOptionPane.INFORMATION_MESSAGE);
	}

	public void inputHasTools() {
		int reply = JOptionPane.showConfirmDialog(null, "Does the toolbox include tools?", "Information required",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			hasTools = true;
		} else {
			hasTools = false;
		}
	}

	public void inputGrade() throws FileNotFoundException {
		do {
			grade = null;
			grade = JOptionPane.showInputDialog(null, "\nOil Grade:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (grade != null) {
				try {
					System.out.println("You entered: " + grade);
				} catch (final Exception e) {
					invalidSel();
				}
			} else {
				goBack();
			}
		} while (grade == "" || grade == null);
	}

	public void inputStrings() throws FileNotFoundException {
		do {
			brand = null;
			brand = JOptionPane.showInputDialog(null, "\nEnter the brand name:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (brand != null) {
				try {
					System.out.println("You entered: " + brand);
				} catch (final Exception e) {
					invalidSel();
				}
			} else {
				goBack();
			}
		} while (brand == "" || brand == null);

		do {
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

	public void inputDoubles() {
		do {
			weight = 0;
			String validWeight = JOptionPane.showInputDialog(null, "\nItem weight:", "Information required:",
					JOptionPane.PLAIN_MESSAGE);
			if (validWeight != null) {
				try {
					double doubleWeight = Double.parseDouble(validWeight);
					weight = doubleWeight;
				} catch (final Exception e) {
					invalidSel();
				}
			}
			if (weight <= 0) {
				zeroItem();
			}
		} while (weight <= 0);
		do {
			price = 0;
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

	public void inputDrawers() {
		do {
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

	public void inputVolume() {
		do {
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

	public void inputQty() {
		do {
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

	public void addItem() {
		switch (invSelection) {
		case 1:
			product.add(new BaseProduct(brand, desc, weight, price, quantity));
			break;
		case 2:
			product.add(new Toolkit(brand, desc, weight, price, quantity, pieces));
			break;
		case 3:
			product.add(new Consumable(brand, desc, weight, price, quantity, volume, grade));
			break;
		case 4:
			product.add(new Toolbox(brand, desc, weight, price, quantity, drawers, hasTools));
			break;
		default:
			invalidSel();
		}
		JOptionPane.showMessageDialog(null, "Product stored in inventory", "Stock Item Added",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void removeItem() {
		try {
			JOptionPane.showMessageDialog(null, "Last product removed from list:\n" + product.get(product.size() - 1),
					"Stock Item Removed", JOptionPane.INFORMATION_MESSAGE);
			product.remove(product.size() - 1);
		} catch (final Exception e) {
			invalidSel();
		}
	}

	public void clearList() throws FileNotFoundException {
		int remAll = JOptionPane.showConfirmDialog(null, "Clear the inventory?", "Are you sure?",
				JOptionPane.YES_NO_OPTION);
		if (remAll == JOptionPane.YES_OPTION && product.size() > 0) {
			try {
				product.removeAll(product);
				JOptionPane.showMessageDialog(null, "Inventory Clear", "Cleared", JOptionPane.INFORMATION_MESSAGE);
			} catch (final Exception e) {
				invalidSel();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No records changed", "No change to inventory",
					JOptionPane.INFORMATION_MESSAGE);
			inventoryMenu();
		}
	}

	public void confirmRem() throws FileNotFoundException {
		int remItem = JOptionPane.showConfirmDialog(null, "Remove the last item created?", "Are you sure?",
				JOptionPane.YES_NO_OPTION);
		if (remItem == JOptionPane.YES_OPTION) {
			removeItem();
		} else {
			JOptionPane.showMessageDialog(null, "No records changed", "No change to inventory",
					JOptionPane.INFORMATION_MESSAGE);
			inventoryMenu();
		}
	}

	public void editList() throws FileNotFoundException {
		inputStrings();
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
		addItem();
	}

	public void promptUser() throws FileNotFoundException {
		int reply = JOptionPane.showConfirmDialog(null, "Add Another Item?", "Make Selection",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			editList();
		} else {
			inventoryMenu();
		}
	}

	public void outputStream() throws FileNotFoundException {
		File file = new File("output.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
	}

	public void printToFile() throws FileNotFoundException {
		if (storeSelection == 1) {
			loc.get(0).setProduct(product);
			outputStream();
			System.out.print(loc.get(0));
		} else if (storeSelection == 2) {
			loc.get(1).setProduct(product);
			outputStream();
			System.out.print(loc.get(1));
		} else if (storeSelection == 3) {
			loc.get(2).setProduct(product);
			outputStream();
			System.out.print(loc.get(2));
		} else {
			invalidSel();
		}
		JOptionPane.showMessageDialog(null, "List Exported", "Output to File", JOptionPane.INFORMATION_MESSAGE);
	}

	public int startManager() {
		startSelection = 0;
		String stringSelection = JOptionPane.showInputDialog(null,
				"======== STORE MANAGEMENT ========\n\n" + "1. Manage Stores\n" + "2. About\n" + "3. Quit\n\n",
				"Main Menu", JOptionPane.PLAIN_MESSAGE);
		if (stringSelection != null) {
			try {
				startSelection = Integer.parseInt(stringSelection.trim());
			} catch (final Exception e) {
				invalidSel();
			}
		} else {
			quit();
		}
		return startSelection;
	}

	public int invManager() throws FileNotFoundException {
		invSelection = 0;
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
			goBack();
		}
		return invSelection;
	}

	public int storeManager() throws FileNotFoundException {
		storeSelection = 0;
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

	public void inventoryMenu() throws FileNotFoundException {
		while (!hasFinished) {
			invSelection = invManager();
			switch (invSelection) {
			case 1:
				while (invSelection == 1) {
					editList();
					promptUser();
				}
				break;
			case 2:
				while (invSelection == 2) {
					editList();
					promptUser();
				}
				break;
			case 3:
				while (invSelection == 3) {
					editList();
					promptUser();
				}
				break;
			case 4:
				while (invSelection == 4) {
					editList();
					promptUser();
				}
				break;
			case 5:
				confirmRem();
				break;
			case 6:
				printToFile();
				break;
			case 7:
				System.out.println("Selection: " + invSelection);
				JOptionPane.showMessageDialog(null, "Displaying inventory ...", "In Stock",
						JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < product.size(); i++) {
					JOptionPane.showMessageDialog(null, product.get(i), "Item Details",
							JOptionPane.INFORMATION_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "There are " + product.size() + " entries(s) in the list",
						"Total entries", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				clearList();
				break;
			case 9:
				goBack();
				break;
			default:
				invalidSel();
			}
		}
	}

	public void chooseStore() throws FileNotFoundException {
		while (isChoosing) {
			storeSelection = storeManager();
			switch (storeSelection) {
			case 1:
				while (storeSelection == 1) {
					inventoryMenu();
				}
				break;
			case 2:
				while (storeSelection == 2) {
					inventoryMenu();
				}
				break;
			case 3:
				while (storeSelection == 3) {
					inventoryMenu();
				}
				break;
			case 4:
				goBack();
				break;
			default:
				invalidSel();
			}
		}
	}

	public void initArray() {
		loc.add(new Location("Warehouse", "233", "Factory Drive", "Coburg North", "VIC", "3058", "(03)97662000", null));
		loc.add(new Location("Store", "125", "Swan Street", "Richmond", "VIC", "3121", "(03)98992100", null));
		loc.add(new Location("Store", "175", "St. Georges Road", "Preston", "VIC", "3072", "(03)97662200", null));
	}

	public void startMenu() throws FileNotFoundException {
		while (isRunning) {
			startSelection = startManager();
			switch (startSelection) {
			case 1:
				isRunning = false;
				isChoosing = true;
				chooseStore();
				break;
			case 2:
				showAbout();
				break;
			case 3:
				quit();
				break;
			default:
				invalidSel();
			}
		}
	}
}
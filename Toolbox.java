package assessment;

public class Toolbox extends Product {						// inherited class from Product {abstract} 

	private int drawers;									// declare integer to hold a value
	private boolean hasTools;								// declare boolean with unset state

	public Toolbox(int drawers, boolean hasTools) {			// short constructor 
		super();											// use inherited constructor
		this.drawers = drawers;								// handle parameters
		this.hasTools = hasTools;							// *
	}

	public Toolbox(String brand, String desc, double weight, double price, int quantity, int drawers,
			boolean hasTools) {								// full constructor
		super(brand, desc, weight, price, quantity);		// use inherited constructor
		this.drawers = drawers;								// handle parameters
		this.hasTools = hasTools;							// *
	}

	public void setDrawers(int drawers) {					// set method for integer 'drawers'
		this.drawers = drawers;								// *
	}

	public void setHasTools(boolean hasTools) {				// set method for boolean state
		this.hasTools = hasTools;							// *
	}

	public int getDrawers() {								// get method for integer 'drawers'
		return drawers;										// return values
	}

	public boolean getHasTools() {							// get method for boolean state
		return hasTools;									// return state
	}

	@Override												// auto-generated
	public String toString() {								// method to return String output
		String status = null;								// nullify String value
		if (this.hasTools) {								// check if object instance 'hasTools' boolean state
			status = "Yes";									// return a String assigned to 'status'
		} else if (!this.hasTools) {						// check if object instance '!hasTools' boolean state
			status = "No";									// return a String assigned to 'status'
		}
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Number Of Drawers: " + drawers + " \n"
		+ "Includes Tools: " + status + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
		// the returned String output 
	}
} // end of class
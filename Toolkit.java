package assessment;

public class Toolkit extends Product {							// inherited class from Product {abstract} 

	private int pieces;											// declare integer to hold a value

	public Toolkit() {											// default constructor
		super();												// refernece to parent constructor
		this.pieces = 0;										// handle parameters
	}

	public Toolkit(String brand, String desc, double weight, 
		double price, int quantity, int pieces) {				// full constructor
		super(brand, desc, weight, price, quantity);			// refernece to parent constructor
		this.pieces = pieces;									// handle parameters
	}

	public void setPieces(int pieces) {							// set method for integer 'pieces'
		this.pieces = pieces;									// handle parameters
	}

	public int getPieces() {									// get method for integer 'pieces'
		return pieces;											// return values
	}

	@Override													// auto-generated
	public String toString() {									// toString() method override
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Number Of Pieces: " + pieces + " \n"
		+ "Quantity In Stock: " + quantity + " \n" + "------------------------------------------ \n\n";
	}
} // end of class
package assessment;

public class Toolkit extends Product {							

	private int pieces;											

	public Toolkit() {											
		super();												
		this.pieces = 0;										
	}

	public Toolkit(String brand, String desc, double weight, 
		double price, int quantity, int pieces) {				
		super(brand, desc, weight, price, quantity);			
		this.pieces = pieces;									
	}

	public void setPieces(int pieces) {							
		this.pieces = pieces;									
	}

	public int getPieces() {									
		return pieces;											
	}

	@Override													
	public String toString() {									
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Number Of Pieces: " + pieces + " \n"
		+ "Quantity In Stock: " + quantity + " \n" + "------------------------------------------ \n\n";
	}
}

package assessment;

public class BaseProduct extends Product {                                                          // this class is derived from the abstract Product class
	                                                                                            // it contains no additional attibutes or methods
	public BaseProduct(String brand, String desc, double weight, double price, int quantity) {  // acting as a means to instantiate the abstract class
		super(brand, desc, weight, price, quantity);                                        // for testing purposes
	}

	@Override
	public String toString() {
		return super.toString();
	}
} // end of class

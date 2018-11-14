package assessment;

public class BaseProduct extends Product {
  
	public BaseProduct(String brand, String desc, double weight, double price, int quantity) {
		super(brand, desc, weight, price, quantity);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}

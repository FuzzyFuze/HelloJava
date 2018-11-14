package assessment;

import java.text.DecimalFormat;													// import jdk text Decimal Format module
																				// this is the {abstract} class 'Product'
public abstract class Product {													// it is the parent class of all 'Product' derived classes
	protected String brand;														// declare protected attributes
	protected String desc;
	protected double weight;
	protected double price;
	protected int quantity;

	public Product() {															// default constructor
		this.brand = null;														// assign default values
		this.desc = null;
		this.weight = 0;
		this.price = 0;
		this.quantity = 0;
	}

	public Product(String brand, String desc, double weight, double price,		// full constructor
		int quantity) {															// handle parameters
		this.brand = brand;
		this.desc = desc;
		this.weight = weight;
		this.price = price;
		this.quantity = quantity;
	}

	public DecimalFormat df1 = new DecimalFormat("#.###");						// instantiate a DecimalFormat object for use in toString()
	public DecimalFormat df2 = new DecimalFormat("#.##");						// *
	
	public void setBrand(String brand) {										// set methods start here
		this.brand = brand;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}																			// set methods end here

	public String getBrand() {													// get methods start here
		return brand;
	}

	public String getDesc() {
		return desc;
	}

	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}																			// get methods end here

	@Override																	// auto-generated
	public String toString() {													// toString() method override
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
	}
}
package assessment;

import java.text.DecimalFormat;													
																				
public abstract class Product {													
	protected String brand;														
	protected String desc;
	protected double weight;
	protected double price;
	protected int quantity;

	public Product() {															
		this.brand = null;														
		this.desc = null;
		this.weight = 0;
		this.price = 0;
		this.quantity = 0;
	}

	public Product(String brand, String desc, double weight, double price,		
		int quantity) {															
		this.brand = brand;
		this.desc = desc;
		this.weight = weight;
		this.price = price;
		this.quantity = quantity;
	}

	public DecimalFormat df1 = new DecimalFormat("#.###");						
	public DecimalFormat df2 = new DecimalFormat("#.##");						
	
	public void setBrand(String brand) {										
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
	}																			

	public String getBrand() {													
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
	}																			

	@Override																	
	public String toString() {													
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
	}
}

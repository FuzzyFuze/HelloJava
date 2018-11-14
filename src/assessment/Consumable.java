package assessment;

public class Consumable extends Product {

	private int volume;
	private String grade;

	public Consumable() {
		super();
		this.volume = 0;
		this.grade = null;
	}

	public Consumable(String brand, String desc, double weight, double price, int quantity, int volume, String grade) {
		super(brand, desc, weight, price, quantity);
		this.volume = volume;
		this.grade = grade;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getVolume() {
		return volume;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Capacity: " + volume + "L \n" + "Grade: "
		+ grade + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
	}
}
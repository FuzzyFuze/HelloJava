package assessment;

public class Consumable extends Product {											// inherited class from Product {abstract} 

	private int volume;																// declare integer to hold a value
	private String grade;															// declare String to hold input

	public Consumable() {															// default constructor
		super();																	// reference to parent class constructor
		this.volume = 0;															// set default parameters
		this.grade = null;															// *
	}

	public Consumable(String brand, String desc, double weight, double price,
		int quantity, int volume, String grade) {									// full constructor
		super(brand, desc, weight, price, quantity);								// reference to parent class constructor
		this.volume = volume;														// handle parameters
		this.grade = grade;															// *
	}

	public void setVolume(int volume) {												// set method for integer 'volume'
		this.volume = volume;														// handle parameters
	}

	public void setGrade(String grade) {											// seth method for String 'grade'
		this.grade = grade;															// handle parameters
	}

	public int getVolume() {														// get method for integer 'volume'
		return volume;																// return values
	}

	public String getGrade() {														// get method for String 'grade'
		return grade;																// return values
	}

	@Override																		// auto-generated
	public String toString() {														// toString() method override
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Capacity: " + volume + "L \n" + "Grade: "
		+ grade + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
	}
} // end of class
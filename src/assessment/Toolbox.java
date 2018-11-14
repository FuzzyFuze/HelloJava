package assessment;

public class Toolbox extends Product {

	private int drawers;
	private boolean hasTools;

	public Toolbox(int drawers, boolean hasTools) {
		super();
		this.drawers = drawers;
		this.hasTools = hasTools;
	}

	public Toolbox(String brand, String desc, double weight, double price, int quantity, int drawers,
			boolean hasTools) {
		super(brand, desc, weight, price, quantity);
		this.drawers = drawers;
		this.hasTools = hasTools;
	}

	public void setDrawers(int drawers) {
		this.drawers = drawers;
	}

	public void setHasTools(boolean hasTools) {
		this.hasTools = hasTools;
	}

	public int getDrawers() {
		return drawers;
	}

	public boolean getHasTools() {
		return hasTools;
	}

	@Override
	public String toString() {
		String status = null;
		if (this.hasTools) {
			status = "Yes";
		} else if (!this.hasTools) {
			status = "No";
		}
		return "Brand Name: " + brand + " \n" + "Description: " + desc + " \n" + "Item Weight: " + df1.format(weight)
		+ "kg \n" + "Item Price: $" + df2.format(price) + " \n" + "Number Of Drawers: " + drawers + " \n"
		+ "Includes Tools: " + status + " \n" + "Quantity In Stock: " + quantity + " \n"
		+ "------------------------------------------ \n\n";
	}
}
package assessment;

import java.util.*;								// imports all jdk utilites module(s)

public class Location {							// the base class of Location - not inherited or abstract. 
	private String type;						// the private attributes of the Location Class are 
	private String streetNo;					// mainly Strings except for the bottom attribute.
	private String streetName;					// *
	private String suburb;						// *
	private String state;						// *
	private String postCode;					// *
	private String phoneNo;						// *
	private ArrayList<Product> product;			// Location requires an instance of a product list or it's list will be null

	public Location() {							// default constructor
		this.type = null;						// set all Strings as 'null'
		this.streetNo = null;					// *
		this.streetName = null;					// *
		this.suburb = null;						// *
		this.state = null;						// *
		this.postCode = null;					// *
		this.phoneNo = null;					// *
		this.product = null;					// *
	}

	public Location(String type, String streetNo, String streetName, String suburb,
		String state, String postCode, String phoneNo, ArrayList<Product> product) {			// full constructor
		this.type = type;																		// handle parameters
		this.streetNo = streetNo;																// *
		this.streetName = streetName;															// *
		this.suburb = suburb;																	// *
		this.state = state;																		// *
		this.postCode = postCode;																// *
		this.phoneNo = phoneNo;																	// *
		this.product = product;																	// *
	}

	public void setType(String type) {							//set methods start here
		this.type = type;										// *
	}															// *
																// *
	public void setStreetNo(String streetNo) {					// *
		this.streetNo = streetNo;								// *
	}															// *
																// *
	public void setStreetName(String streetName) {				// *
		this.streetName = streetName;							// *
	}															// *
																// *
	public void setSuburb(String suburb) {						// *
		this.suburb = suburb;									// *
	}															// *
																// *
	public void setState(String state) {						// *
		this.state = state;										// *
	}															// *
																// *
	public void setPostCode(String postCode) {					// *
		this.postCode = postCode;								// *
	}															// *
																// *
	public void setPhoneNo(String phoneNo) {					// *
		this.phoneNo = phoneNo;									// *
	}															// *
																// *
	public void setProduct(ArrayList<Product> product) {		// *
		this.product = product;									// *
	}															// set methods end here
																// *
	public String getType() {									// get methods start here
		return type;											// *
	}															// *
																// *
	public String getStreetNo() {								// *
		return streetNo;										// *
	}															// *
																// *
	public String getStreetName() {								// *
		return streetName;										// *
	}															// *
																// *
	public String getSuburb() {									// *
		return suburb;											// *
	}															// *
																// *
	public String getState() {									// *
		return state;											// *
	}															// *
																// *
	public String getPostCode() {								// *
		return postCode;										// *
	}															// *
																// *
	public String getPhoneNo() {								// *
		return phoneNo;											// *
	}															// *
																// *
	public List<Product> getProduct() {							// *
		return product;											// *
	}															// get methods end here
																// *
	@Override													// auto-generated
	public String toString() {									// toString() method override
		return "========================================== \n" + suburb + " " + type + " \n" + streetNo + " " + streetName
				+ " \n" + suburb + " \n" + state + " \n" + postCode + " \n" + "Phone No: " + phoneNo + " \n\n"
				+ "Inventory: \n" + "========================================== \n\n"
				+ product.toString().replaceAll("\\[|\\]|\\,\\s", "") + "\n"
				+ "------------------END---------------------";
	}
} // end of class
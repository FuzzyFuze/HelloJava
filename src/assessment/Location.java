package assessment;

import java.util.*;

public class Location {
	private String type;
	private String streetNo;
	private String streetName;
	private String suburb;
	private String state;
	private String postCode;
	private String phoneNo;
	private ArrayList<Product> product;

	public Location() {
		this.type = null;
		this.streetNo = null;
		this.streetName = null;
		this.suburb = null;
		this.state = null;
		this.postCode = null;
		this.phoneNo = null;
		this.product = null;
	}

	public Location(String type, String streetNo, String streetName, String suburb, String state, String postCode,
			String phoneNo, ArrayList<Product> product) {
		this.type = type;
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.suburb = suburb;
		this.state = state;
		this.postCode = postCode;
		this.phoneNo = phoneNo;
		this.product = product;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}

	public String getType() {
		return type;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public String getSuburb() {
		return suburb;
	}

	public String getState() {
		return state;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public List<Product> getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "========================================== \n" + suburb + " " + type + " \n" + streetNo + " " + streetName
				+ " \n" + suburb + " \n" + state + " \n" + postCode + " \n" + "Phone No: " + phoneNo + " \n\n"
				+ "Inventory: \n" + "========================================== \n\n"
				+ product.toString().replaceAll("\\[|\\]|\\,\\s", "") + "\n"
				+ "------------------END---------------------";
	}
}
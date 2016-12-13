/**
 * Assignment Three - EStore Search - Product Class
 * 
 * This class is a super class that contains Book and Electronics as its subclasses.
 * It contains methods common to both the Book and Electronics subclasses, which
 * Book and Electronics inherits.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */

import java.util.InputMismatchException;

public abstract class Product {
	/** ID of the product. */
	public String productID;
	/** Name of the product. */
	public String name;
	/** Year of the product. */
	public int year;
	/** Price of the product. */
	public String price;
	/** Key value of the product */
	public String key = "";
	/** Check for valid Product */
	boolean isValid = true;
	
	/**
	 * Creates a new product object with the following specified parameters.
	 * 
	 * @param productID ProductID of book/electronic
	 * @param name Name of book/electronic
	 * @param year Year of book/electronic
	 * @param price Price of book/electronic
	 * @param key Key value of book/electronic
	 */
	public Product(String productID, String name, String year, String price, String key)
	{
		/** Set the common variables */
		this.productID = productID;
		this.name = name;
		/** Exception handling for string -> int conversion */
		try
		{
			// Try to convert
			this.year = Integer.parseInt(year);
		} catch(InputMismatchException ex) { // Catch a possible non integer entry, in both cases set isValid to false.
			System.out.println("ERROR: This is not a number. Please try again!");
			isValid = false;
		} catch(NumberFormatException e) {
			System.out.println("ERROR: This is not a number. Please try again!");
			isValid = false;
		}
		this.key = key;
		this.price = price;
	}
	
	/**
	 * Copy constructor so that for parameter passing of Product references,
	 * we can create a duplicate object and assign it to another reference
	 * in order to avoid the creation of co-references that may cause
	 * privacy leaks.
	 * 
	 * @param toCopy Object to duplicate
	 */
	public Product (Product toCopy) {
		this.productID = toCopy.productID;
		this.name = toCopy.name;
		this.year = toCopy.year;
		this.price = toCopy.price;
		this.key = toCopy.key;
	}
	
	/**
	 * Copy references to a new instance of the mutable class.
	 * 
	 * @return None
	 */
	public Product deepCopy() {
		if (this instanceof Book) {
			return new Book((Book)this);
	    } else if (this instanceof Electronic) {
	    	return new Electronic((Electronic)this);
	    } else {
	    	throw new Error("Unknown type of product");
	    }
	}

	/**
	 * Displays all fields of a Product that gets override by child classes.
	 * 
	 * @return string Product fields in string format
	 */
	public String print()
	{
		return ("type = \"Book\"\nProductID number = \"" 
    			+ getProductID() 
    			+ "\"\ntitle = \"" 
    			+ getName()
    			+ "\"\nyear = \""
    			+ getYear() 
    			+ "\"\nprice = \""
    			+ getPrice());
	}

	/**
	 * Returns the product ID
	 * 
	 * @return productID 
	 */
	protected String getProductID() {
		return productID;
	}
	
	/**
	 * Sets the product ID which must be 6 digits long.
	 * 
	 * @param productID
	 */
	protected void setProductID(String productID) {
		this.productID = productID;
	}
	
	/**
	 * Returns the name of the product.
	 * 
	 * @return name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the product.
	 * 
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the year of the product.
	 * 
	 * @return year
	 */
	protected int getYear() {
		return year;
	}
	
	/**
	 * Sets the year of the product which must be between 1000 and 9999.
	 * 
	 * @param year
	 */
	protected void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Returns the price of the product.
	 * 
	 * @return price in Canadian dollars ($).
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * Sets the price of the product which must be of digits and maximum 2 decimal places.
	 * 
	 * @param price in Canadian dollars ($).
	 */
	protected void setPrice(String price) {
		this.price = price;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * The way isValid is handled: It prevents this Product from being created in the 
	 * EStoreSearch class so the user can try another input.
	 * 
	 * @return isValid Validation check
	 */
	public boolean getIsValid()
	{
		return isValid;
	}
	
	/**
	 * The way isValid is handled: It prevents this Product from being created in the 
	 * EStoreSearch class so the user can try another input.
	 * 
	 * @param isValid Validation check
	 */
	public void setIsValid(boolean isValid)
	{
		this.isValid = isValid;
	}
}

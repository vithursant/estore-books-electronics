/**
 * Assignment Three - EStore Search - Electronic Class
 * 
 * This class holds the contents of the electronic object.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */

public class Electronic extends Product {
	/** Manufacturer of the electronics product */
	private String manufacturer;
	
	/**
	 * Constructor for the Electronics class, which is invoked to create electronic objects from the class blueprint.
	 * 
	 * @param productID Product ID number of the electronic
	 * @param name Name of the electronic
	 * @param year Year of the electronic
	 * @param price Price of the electronic
	 * @param manufacturer Manufacturer of the electronic
	 * @param key Key value of the electronic
	 */
	public Electronic(String productID, String name, String manufacturer, String year, String price, String key)
	{
		super(productID, name, year, price, key);
		if (this.productID != null) {
			this.manufacturer = manufacturer;
		}
	}
	
	/**
	 * Copy constructor so that for parameter passing of Electronic references,
	 * we can create a duplicate object and assign it to another reference
	 * in order to avoid the creation of co-references that may cause
	 * privacy leaks.
	 * 
	 * @param toCopy Object to duplicate
	 */
	public Electronic(Electronic toCopy) {
	    super(toCopy);
	    this.manufacturer = toCopy.manufacturer;
	}
	  
	/**
	 * Display all fields of an Electronic.
	 */
	@Override
	public String print()
	{
		return ("Type = \"Electronic\"\nProductID Number = \"" 
    			+ getProductID() 
    			+ "\"\nName = \"" 
    			+ getName()
    			+ "\"\nYear = \""
    			+ getYear()
    			+ "\"\nManufacturer = \"" 
            	+ getManufacturer()
            	+ "\"\nPrice = \""
            	+ getPrice()
            	+ "\"");
	}
	
	/**
	 * Returns manufacturer name of the electronic product.
	 * 
	 * @return manufacturer of the electronic
	 */
	protected String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the electronic manufacturer's name.
	 * 
	 * @param manufacturer of the electronic
	 */
	protected void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}

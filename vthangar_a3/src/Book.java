/**
 * Assignment Three - EStore Search - Book Class
 * 
 * This class holds the contents of the book object.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */

public class Book extends Product {
	/** Authors of the book */
	private String author;
	/** Publisher of the book */
	private String publisher;
	
	/**
	 * Constructor for the Book class, which is invoked to create book objects from the class blueprint.
	 * 
	 * @param productID the product ID number of the book
	 * @param name the name of the book
	 * @param year the year of the book
	 * @param price the price of the book
	 * @param authors the author(s) of the book
	 * @param publisher the publisher(s) of the book
	 * @param key Key value of the book
	 */
	@SuppressWarnings("unused")
	public Book(String productID, String author, String name, String publisher, String year, String price, String key)
	{
		super(productID, name, year, price, key);
	    if (this == null)
	    	throw new NullPointerException("Invalid null product");
	    else {
			this.author = author;
			this.publisher = publisher;
	    }
	}

	/**
	 * Copy constructor so that for parameter passing of Book references,
	 * we can create a duplicate object and assign it to another reference
	 * in order to avoid the creation of co-references that may cause
	 * privacy leaks.
	 * 
	 * @param toCopy Object to duplicate
	 */
	public Book(Book toCopy) {
	    super(toCopy);
	    this.author = toCopy.author;
	    this.publisher = toCopy.publisher;
	}
	
	/**
	 * Displays all fields of a Books.
	 */
	@Override
	public String print()
	{
		return ("Type = \"Book\"\nProductID Number = \"" 
	            			+ getProductID() 
	            			+ "\"\nName = \"" 
	            			+ getName()
	            			+ "\"\nYear = \""
	            			+ getYear()
	            			+ "\"\nAuthors = \"" 
	                    	+ getAuthor()
	                    	+ "\"\nPublisher = \"" 
	                    	+ getPublisher()
	                    	+ "\"\nPrice = \""
	                    	+ getPrice()
	                    	+ "\"");
	}
	
	/**
	 * Returns the authors of the book.
	 * 
	 * @return authors of the book
	 */
	protected String getAuthor() {
		return author;
	}

	/**
	 * Sets the authors of the book.
	 * 
	 * @param authors the authors of the book
	 */
	protected void setAuthors(String author) {
		this.author = author;
	}

	/**
	 * Returns the publisher of the book.
	 * 
	 * @return publisher the publisher of the Book
	 */
	protected String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher of the book.
	 * 
	 * @param publisher the publisher of the book
	 */
	protected void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}

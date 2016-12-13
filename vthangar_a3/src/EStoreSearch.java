/**
 * Assignment Three - EStore Search - EStoreSearch class
 * 
 * This is a EStore search program which allows the user to add books/electronic
 * products and search the EStore for information such as matching books/electronics.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EStoreSearch {
	/** Initializations */
	Scanner input = new Scanner(System.in);
	
	private ArrayList<Product> refList;
	private String productID;
	private String name;
	private String year;
	private String key;
	private String price;
	
	/**
	 * HashMap of the names of book/electronic with appropriate values of the ArrayList index.
	 */
	private HashMap <String, ArrayList<Integer>> hashmap;
	
	/**
	 * If there is no input file to read product information from.
	 */
	public EStoreSearch()
	{
		refList = new ArrayList<>();
		hashmap = new HashMap<String, ArrayList<Integer>>();
	}

	/**
	 * If there is a file present to read from then Overloading
	 * 
	 * @param file
	 */
	public EStoreSearch(File file)
	{
		refList = new ArrayList<>();
		hashmap = new HashMap<String, ArrayList<Integer>>();
		String line, author, publisher, manufacturer;
		
		/** Try catch statement for reading a line from the file */
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(file));
			
			/** Main while loop to read the file line by line */
			while ((line = bufferReader.readLine()) != null)
			{
				/** Reset the values for each line */
				String type = "";
				productID = "";
				name = "";
				year = "";
				key = "";
				author = "";
				publisher = "";
				manufacturer = "";
				price = "";
				
				/** Split the lines for each field */
				String[] arr = line.split("\"");
				type = arr[1];
				line = bufferReader.readLine();
				arr = line.split("\"");
				productID = arr[1];
				line = bufferReader.readLine();
				arr = line.split("\"");
				name = arr[1];
				line = bufferReader.readLine();
				arr = line.split("\"");
				
				/** Try catch for parsing an integer from input file */
				year = arr[1];
				key = productID.substring(0, 1) + productID.substring(productID.length()-1) + String.valueOf(year);
				
				/** If statements for getting appropriate fields based on Book or Electronic */
				if (type.equals("Book"))
				{
					line = bufferReader.readLine();
					arr = line.split("\"");
					if (arr.length > 1) 
					{
						author = arr[1];
					}
					
					line = bufferReader.readLine();
					arr = line.split("\"");
					if (arr.length > 1) 
					{
						publisher = arr[1];
					}
					
					/** Add to the Product List estore */
					refList.add(new Book(productID, author, name, publisher, year, price, key));
				}
				/** Else if it's an Electronic scan for manufacturer */
				else
				{
					line = bufferReader.readLine();
					arr = line.split("\"");
					if (arr.length > 1) 
					{
						manufacturer = arr[1];
					}
					refList.add(new Electronic(productID, name, manufacturer, year, price, key));
				}
				/** Add the name to the hashtable */
				addHash(name);
			}
			
			bufferReader.close();
		} catch (FileNotFoundException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		} catch (IOException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Add name and its appropriate location in the hashtable.
	 * 
	 * @param str
	 */
	public void addHash(String str)
	{
		/** Tokenize the string by spaces */
		StringTokenizer strTok = new StringTokenizer(str.toLowerCase());
		/** While loop to continue until no more tokens */
		while (strTok.hasMoreTokens() == true)
		{
			/** Load next token */
			String curr = strTok.nextToken();
			
			if (hashmap.containsKey(curr))
			{
				/** Get ArrayList for the word and add it to the array */
				hashmap.get(curr).add(refList.size() - 1);
				/** Update the value of the table */
				hashmap.put(curr, hashmap.get(curr));
			}
			else
			{
				/** Put a new ArrayList in the table and add it to the array*/
				hashmap.put(curr, new ArrayList<Integer>());
				hashmap.get(curr).add(refList.size() - 1);
			}
		}
	}
	
	/**
	 * Adds a Book or an Electronic.
	 * 
	 * @param productID2
	 * @param name2
	 * @param year2
	 * @param authorg
	 * @param publisher
	 * @param price
	 * @param type
	 * @return None
	 */
	public void addObject(String productID2, String name2, String year2, String authorg, String publisher, String price, int type)
	{
		productID = "";
		name = "";
		year = "";
		this.productID = productID2;
		this.name = name2;
		this.year = year2;
		key = productID.substring(0, 1) + productID.substring(productID.length()-1) + String.valueOf(year);
		if (checkIfObjectExists(key) == false)
		{
			if (type == 0)
			{
				refList.add(new Book(productID, authorg, name, publisher, year, price, key));
			} 
			else 
			{
				refList.add(new Electronic(productID, name, authorg, year, price, key));
			}
			/** Remove from the list if not valid */
			if (refList.get(refList.size() - 1).getIsValid() == false) 
			{
				refList.remove(refList.size() - 1);
			/** Add to Hash */
			} 
			else 
			{
				addHash(name);
			}
		}
		else
		{
			System.out.println("Book already exists. Entry is skipped.");
		}
	}
	
	/**
	 * Check if object exists using the key.
	 * 
	 * @param key Object's key value
	 * @return ret true/false
	 */
	public boolean checkIfObjectExists(String key)
	{
		int i;
		/** Check if the book exists or not by checking the keys */
		for (i = 0; i < refList.size(); i++)
		{
			if (key.equals(refList.get(i).getKey())) 
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Intersection of values between two ArrayLists 
	 * 
	 * @param listA first ArrayList
	 * @param listB second ArrayList
	 * @return intersection intersection ArrayList of two ArrayLists
	 */
	public ArrayList<Integer> findInt(ArrayList<Integer> listA, ArrayList<Integer> listB)
	{
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		/** Check if value in list, then add to intersection list */
		for (int i = 0; i < listA.size(); i++) 
		{
			if (listB.contains(listA.get(i))) 
			{
				intersection.add(listA.get(i));
			}
		}
		
		return (intersection);
	}
	
	/**
	 * Function for searching the List.
	 * 
	 * @param productID2
	 * @param name2
	 * @param startYear
	 * @param endYear
	 * @return estore 
	 */
	public String searchList(String productID2, String name2, int startYear, int endYear)
	{
		int i;
		
		/** Duplicate ArrayList into variable */
		ArrayList<Product> updateList = new ArrayList<Product>(refList);
		String productID = "";
		String name = "";
		int year1 = startYear;
		int year2 = endYear;
		productID = productID2;
		name = name2;
		
		if (!(productID.isEmpty()))
		{
			for (i = 0; i < updateList.size(); i++)
			{
				if (!(updateList.get(i).getProductID().toLowerCase().equals(productID.toLowerCase())))
				{
					/** Remove if no match */
					updateList.remove(i);
					i--;
				}
			}
		}
		if (!(name.isEmpty()))
		{
			StringTokenizer keywordToken;
			String updateKeyword;
			ArrayList<Integer> intersection = new ArrayList<Integer>();
			
			/** String tokenizers to go through keywords and names */
			keywordToken = new StringTokenizer(name);
			updateKeyword = keywordToken.nextToken();
			
			if (hashmap.containsKey(updateKeyword.toLowerCase()))
			{
				for (int j = 0; j < hashmap.get(updateKeyword.toLowerCase()).size(); j++)
				{
					intersection.add(hashmap.get(updateKeyword.toLowerCase()).get(j));
				}
			}
			while (keywordToken.hasMoreTokens())
			{
				/** While loop which goes through all keywords checking for intersections */
				updateKeyword = keywordToken.nextToken();
				if (intersection.isEmpty())
				{
					/** Break if no intersection */
					intersection.clear();
					break;
				}
				else
				{
					if (hashmap.containsKey(updateKeyword.toLowerCase())) 
					{
						intersection = findInt(intersection,hashmap.get(updateKeyword));
					}
					else
					{
						intersection.clear();
					}
				}
				
			}
			updateList.clear();
			/** Update the updateList to show the intersection of keywords in the results */
			for (i = 0; i < intersection.size(); i++) 
			{
				updateList.add(refList.get(intersection.get(i)));
			}
		}
		
		/** Valid range from number to number */
		if (!(year1 == 0 && year2 == 0))
		{
			if (year1 != year2)
			{
				if (year1 == 0)
				{
					for (i = 0; i < updateList.size(); i++)
					{
						/** Case for year with range '-####' */
						if (!(updateList.get(i).getYear() <= year2))
						{
							updateList.remove(i);
							i--;
						}
					}
				}
				else if (year2 == 0)
				{
					for (i = 0; i < updateList.size(); i++)
					{
						/** Case for year with '####-' */
						if (!(updateList.get(i).getYear() >= year1))
						{
							updateList.remove(i);
							i--;
						}
					}
				}
				else
				{
					for (i = 0; i < updateList.size(); i++)
					{
						/** Case for year with range '####-####' */
						if (!(updateList.get(i).getYear() >= year1 && updateList.get(i).getYear() <= year2))
						{
							updateList.remove(i);
							i--;
						}
					}
				}
			}
			else
			{
				for (i = 0; i < updateList.size(); i++)
				{
					/** Case for year with no ranges */
					if (!(updateList.get(i).getYear() == year1))
					{
						updateList.remove(i);
						i--;
					}
				}
			}
		}
		/** Print the estore */
		return (printList(updateList));
	}
	
	/**
	 * Print the ArrayList.
	 * 
	 * @param refList
	 * @return ret result String
	 */
	public String printList(ArrayList<Product> refList)
	{
		String ret = "";
		if (refList.isEmpty()) 
		{
			return("No Products to Display!");
		}
		else
		{
			int i;
			/** If the Book List is not empty, then print out the contents of the book */
			for (i = 0; i < refList.size(); i++)
			{
				ret += ("Result " + (i+1) + "\n" + refList.get(i).print() + "\n");
			}
			return(ret);
		}
	}
	
	/**
	 * Write the List into the file.
	 * @param out
	 */
	public void appendList(File out)
	{
		PrintWriter libFile;
		try {
			/** Write lines into the file */
            libFile = new PrintWriter(new BufferedWriter(new FileWriter(out, false)));
            for (int i = 0; i < refList.size(); i++)
            {
            	libFile.println(refList.get(i).print());
            }
            /** Close the file */
            libFile.close();
        } catch (IOException ex) {
        	System.out.println("ERROR: File not found. Skip file save.");
            Logger.getLogger(EStoreSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}

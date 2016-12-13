*********************************************************************************
* Name:		Vithursan Thangarasa						*
* Student ID:	0821795								*
* Date:		11/30/2016							*
*            									*
* Course: 	CIS*2430 - Object-Oriented Programming                		*
* Professor:	Dr. Song                                              		*
*********************************************************************************

Task:			
Improve Assignment #2. The improvements include:
* Adding a Graphical User Interface (GUI)
* Exception Handling to the application is more robust and user friendly

Problem:
There were several problems that were encountered, such as:
1.	Privacy leak protection for mutable classes. 
2.	Overriding methods for inheritance because it had to be defined in a
	descendant class.
3.	Creating GUI using Java's built-in graphics classes requires more work.
5.	Implementing exception handling into the program. Throwing exceptions in
	constructors and mutator methods whenever violations occur.
	
Assumptions:
1.	The currency of the price is in Canadian Dollars.
2. 	There is only one EStore being worked with and not multiple EStores
	with multiple books and/or electronics.
3.	All keywords of name must be found in order to find its associated 
	product.
	
Limitations:
1.	The data that is added for the books and/or electronics are not 
	stored permanently, therefore the inputted data will be lost once
	the application has been closed.
2. 	Program cannot add multiple Books/Electronics at the same time. 
	Have to be entered one at a time.
	
Build:
The program consists of five classes:
	1) EStoreUI (main class)
	2) EStoreGUIFrame
	3) EStoreSearch
	4) Product 
	5) Book
	6) Electronics

Prerequisites:
The <input file> needs to be put in the estore_input folder which can be
found in the root of the working folder.

Running: 
To run the program, user must compile "EStoreUI.java" by typing:

	"javac EStoreUI.java" from a terminal within the src/ directory
	
After compilation the user must run the compiled code by typing:

	"java EStoreUI” within the terminal.


Result:
The EStore Java application will launch, giving the user a friendly interface
to perform their ADD and SEARCH actions in the EStore.
	
Test Plan:
The user can test the program by entering different book/electronic 
information, and then perform the search operation to find stored information.

Example of Test Cases:

Adding the following Books and Electronics inside the program:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Book
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ProductID: 	000003
Name: 		Harry Potter and the Prisoner of Azkaban
Year:		1999
Price:		23.99
Authors:	J.K. Rowling
Publisher:	Arthur A. Levine Books

ProductID: 	000004
Name: 		Harry Potter and the Goblet of Fire
Year:		2000
Price:		23.99
Authors:	J.K. Rowling
Publisher:	Arthur A. Levine Books

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Electronic
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ProductID:	000020
Name:		Samsung Galaxy S7 Edge
Year:		2016
Price:		899.99
Manufacturer:	Samsung Electronics

ProductID:	000021
Name:		Samsung Gear S2
Year:		2014
Price:		449.99
Manufacturer:	Samsung Electronics

1.	Switch to different panels (i.e. ADD, SEARCH, QUIT, RESET) and
	check if the proper window is being displayed upon button press.
2. 	Using JMenu bar navigate every possible action with different input
	entry fields and it would properly clear every time.
1. 	A search for the name keyword ‘Samsung’ would result in both 
	Samsung electronics through the HashMap.
2.	A search for title ‘Samsung’ and year range '2015-2016' 
	would result in only the 'Samsung Galaxy S7 Edge' being
	found, using the HashMap and sequentially searching the
	matching 'values' of HashMap for the specified year.
3.	In the input entry fields, try different inputs that are not
	expected (i.e. letters for numbers and vice versa). The entry
	was ignored and the product was not added, so exception handling
	worked. The ERROR message(s) were displayed in the text area.
4. 	Invalid productID, year, price values would result in ERROR messages
	in the text area and program didn't proceed further.
5. 	Checked if all input entry fields were correct, then
	"Product Successfully Added" message was displayed in the text area.
6. 	Search results printed correctly and vertical scroll bar for the
	text area was fully functional.

Improvements:
1.	Design a test suite using JUnit 4 for a more automated 
	process of testing the various methods. Some test functions have been 
	implemented.
2. 	Options for sorting and displaying the products:
	* high price to low price
	* low price to high price
	* most recent
	* A-Z 
	* Z-A
3.	Loading multiple reference files to help build a larger database.
4. 	Allow for multiple books and electronics to be added instead of doing it
	one at a time.
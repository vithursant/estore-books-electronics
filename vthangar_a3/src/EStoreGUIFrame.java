/**
 * Assignment Three - EStore Search - EStoreGUIFrame Class
 * 
 * This class is the JFrame of EStoreGUIFrame containing the containers for the GUI. 
 * It includes a lot of validity as well.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
	
public class EStoreGUIFrame extends JFrame {
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -7818916962189658480L;
	/** Initialize the components that are used and accessed in this class */
	private JPanel panel;
	private JPanel rightPanel;
	private JPanel welcomePanel;
	private JPanel bottomPanel;
	private JPanel addPanel;
	private JPanel typeRow;
	private JPanel pIDRow;
	private JPanel nameRow;
	private JPanel yearRow;
	private JPanel endYearRow;
	private JPanel authRow;
	private JPanel pubRow;
	private JPanel priceRow;
	
	private JMenuItem add;
	private JMenuItem search;
	private JMenuItem quit;
	
	private JButton reset;
	private JButton execute;
	
	private JTextArea textArea;
	private JScrollPane scroll;
	private JComboBox<?> prodList;
	
	private JLabel textLabel;
	private JLabel indicator;
	private JLabel yearLab;
	private JLabel pubLab;
	
	private JTextField pIDNum;
	private JTextField name;
	private JTextField year;
	private JTextField authorg;
	private JTextField publisher;
	private JTextField eyear;
	private JTextField price;
	
	private EStoreSearch estore;
	
	/**
	 * Creates a new estore GUI frame object with the following specified parameters.
	 * 
	 * @param estore EStoreSearch object
	 */
	public EStoreGUIFrame(EStoreSearch estore) {
		/** Set the label and size of the frame */
		super("EStore Search");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.estore = estore;
		
		/** THe main JPanel layout using BorderLayout and contains other JPanels. */
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		/** Welcome Screen */
		JTextArea welcome = new JTextArea("Welcome to EStore Search.\n\nSelect a command from the \"Commands\" menu above to ADD a Product, SEARCH Products, or QUIT the program");
		welcome.setOpaque(false);
		welcome.setEditable(false);
		welcomePanel = new JPanel(new BorderLayout());
		welcomePanel.add(welcome, BorderLayout.CENTER);
		
		/** Add the panels by specifying the respective directions */
		panel.add(welcomePanel, BorderLayout.CENTER);
		initButtonPane();
		panel.add(rightPanel, BorderLayout.EAST);
		initTextArea();
		panel.add(bottomPanel, BorderLayout.SOUTH);
		indicator = new JLabel();
		add(indicator, BorderLayout.NORTH);
		initInputPanel();
		panel.add(addPanel, BorderLayout.WEST);
		
		/** Add the panel to the JFrame */
		add(panel);
		jMenu();
		
		/** Make the visibility of the panels used for adding and searching invisible to start */
		rightPanel.setVisible(false);
		bottomPanel.setVisible(false);
		addPanel.setVisible(false);
	}
	
	/** Reset and clear all text fields to begin */
	private void clear()
	{
		pIDNum.setText("");
		name.setText("");
		year.setText("");
		eyear.setText("");
		authorg.setText("");
		publisher.setText("");
		price.setText("");
	}
	
	/** Initializing the Input Panel
	 * The input panel is on the left with the various fields for entering input.
	 */
	private void initInputPanel()
	{
		addPanel = new JPanel();
		addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
		addPanel.setBorder(BorderFactory.createEmptyBorder(10,20,0,20));
		pubLab = new JLabel("Publisher: ");
		yearLab = new JLabel("Year: ");
		JLabel typeLab = new JLabel("Type: ");
		JLabel callLab = new JLabel("Product ID: ");
		JLabel authLab = new JLabel("Authors: ");
		JLabel titLab = new JLabel("Name Keywords: ");
		JLabel eyearLab = new JLabel("End Year: ");
		JLabel priceLab = new JLabel("Price: ");
		
		String[] choices = {"Book", "Electronic"};
		prodList = new JComboBox<Object>(choices);
		
		pIDNum = new JTextField(20);
		name = new JTextField(20);
		year = new JTextField(5);
		eyear = new JTextField(5);
		authorg = new JTextField(20);
		publisher = new JTextField(20);
		price = new JTextField(12);
		
		typeRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pIDRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		yearRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		endYearRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		authRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pubRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		priceRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		typeRow.add(typeLab);
		typeRow.add(prodList);
		pIDRow.add(callLab);
		pIDRow.add(pIDNum);
		nameRow.add(titLab);
		nameRow.add(name);
		yearRow.add(yearLab);
		yearRow.add(year);
		authRow.add(authLab);
		authRow.add(authorg);
		pubRow.add(pubLab);
		pubRow.add(publisher);
		endYearRow.add(eyearLab);
		endYearRow.add(eyear);
		priceRow.add(priceLab);
		priceRow.add(price);
		
		/** Add an ActionListener for the JComboBox. 
		 * Index value 0 == Book 
		 * Index value 1 == Electronic
		 */
		prodList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int curr = prodList.getSelectedIndex();
				if (curr == 0)
				{
					authLab.setText("Authors: ");
					pubRow.setVisible(true);
				}
				else
				{
					authLab.setText("Manufacturer: ");
					pubRow.setVisible(false);
				}
				clear();
				repaint();
			}
		});
		
		/** Add to Panel */
		addPanel.add(typeRow);
		addPanel.add(pIDRow);
		addPanel.add(nameRow);
		addPanel.add(yearRow);
		addPanel.add(endYearRow);
		addPanel.add(authRow);
		addPanel.add(pubRow);
		addPanel.add(priceRow);
	}
	
	/** Initialize the Text Area:
	 * Initialize the white Text Area at the bottom of the window, which is used to 
	 * display messages and search results depending on which action the user
	 * wants to make.
	 */
	private void initTextArea()
	{
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		textArea = new JTextArea(8,20);
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea);
		
		/** Display scroll bar */
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		textLabel = new JLabel("Messages");
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,20,20,20));
		bottomPanel.add(textLabel, BorderLayout.NORTH);
		bottomPanel.add(scroll, BorderLayout.SOUTH);
	}
	
	/** Initialize the Button Panel:
	 * Initialize the Two Buttons on the right using BoxLayout
	 */
	private void initButtonPane()
	{
		ButtonListener listener = new ButtonListener();
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		reset = new JButton("Reset");
		reset.setPreferredSize(new Dimension(120,50));
		execute = new JButton("Add");
		execute.setPreferredSize(new Dimension(120,50));
		reset.addActionListener(listener);
		execute.addActionListener(listener);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(110, 0, 110, 30));
		rightPanel.add(reset);
		rightPanel.add(Box.createVerticalGlue());
		rightPanel.add(execute);
	}
	
	/** Getters for different fields */
	public String getCallNum()
	{
		return(pIDNum.getText());
	}
	
	public String getTitle()
	{
		return(name.getText());
	}
	
	public String getYear()
	{
		return(year.getText());
	}
	
	public String getAuthorg()
	{
		return(authorg.getText());
	}
	
	public String getPublisher()
	{
		return(publisher.getText());
	}
	
	public String getEyear()
	{
		return(eyear.getText());
	}
	
	public String getPrice()
	{
		return(price.getText());
	}
	
	/** JMenu:
	 * Create the JMenu bar
	 */
	private void jMenu()
	{
		JMenuBar bar = new JMenuBar();
		JMenu commands = new JMenu();
		
		/** JMenu Commands */
		MenuListener listener = new MenuListener();
		commands = new JMenu("Commands");
		add = new JMenuItem("Add");
		search = new JMenuItem("Search");
		quit = new JMenuItem("Exit");
		add.addActionListener(listener);
		search.addActionListener(listener);
		quit.addActionListener(listener);
		commands.add(add);
		commands.add(search);
		commands.add(quit);
		bar.add(commands);
		
		/** Add JMenu bar to the JFrame so its always shown. */
		setJMenuBar(bar);
	}
	
	/**
	 * Checks if the string has only digits.
	 * 
	 * @param testStr the string value
	 * @return true if all numeric characters, otherwise false.
	 */
	private boolean isNumeric(String testStr) {
	    for (char c : testStr.toCharArray())
	    {
	        if (!Character.isDigit(c)) {
	        	return (false);
	        }
	    }
	    return (true);
	}
	
	/**
	 * Validates the year input.
	 * 
	 * @param year the product's year
	 * @return true if year is value, otherwise false
	 */
	protected boolean checkYear( String year ) {
		boolean ret = true;
		
		if (isNumeric(year) == false) {
			ret = false;
		} else if( (Integer.parseInt(year) < 1000 || Integer.parseInt(year) > 9999) ) {
			ret = false;
		}
		return (ret);
	}
	
	/**
	 * Gets user input and validate the year.
	 * 
	 * @param year the product's year
	 * @return ret true/false
	 */
	private boolean validateYear(String year) {
		boolean ret = true;
		ret = true;

		ret = checkYear(year);
		return (ret);
	}
	
	/**
	 * Gets user input and validate the productID number of the product.
	 * 
	 * @param productID the product's ID number
	 * @return ret true/false
	 */
	private boolean validateProductID(String productID) {
		boolean ret = true;
		
		/** Check if product ID input is valid */
		if (isNumeric(productID) == false) {
			ret = false;
		} else if (productID.length() != 6) {
			ret = false;
		}
		
		return (ret);
	}
	
	/**
	 * Gets user input and validate the price.
	 * 
	 * @param price the price of the product
	 * @return ret true/false
	 */
	private boolean validatePrice(String price) {
		boolean ret = true;
		String regex = "[0-9]+\\.[0-9]+";
		
		ret = true;
		ret = price.matches(regex);
		return (ret);
	}
	
	/** ActionListener class used for button presses */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/** Clear if reset is pressed */
			if (e.getSource() == reset){
				clear();
			}
			/** Execute the state that is pressed */
			if (e.getSource() == execute)
			{
				textArea.setText("");
				repaint();
				/** When the state is ADD */
				if (execute.getText() == "Add")
				{
					/** Check for empty strings in 4 mandatory fields */
					if (pIDNum.getText() == null || pIDNum.getText().isEmpty() || pIDNum.getText() == "\n") {
						textArea.append("ERROR: Product ID field is empty!\n");
					}
					if (name.getText() == null || name.getText().isEmpty() || name.getText() == "\n") {
						textArea.append("ERROR: Name field is empty!\n");
					}
					if (year.getText() == null || year.getText().isEmpty() || year.getText() == "\n") {
						textArea.append("ERROR: Year field is empty!\n");
					}
					if (price.getText() == null || price.getText().isEmpty() || price.getText() == "\n") {
						textArea.append("ERROR: Price field is empty!\n");
					}
					
					if (validatePrice(price.getText()) == false) 
					{
						textArea.append("ERROR: Price should have digits and maximum 2 decimal places (i.e. 5.99 or 16.59)!\n");
					}
					
					if (validateProductID(pIDNum.getText()) == false) {
						textArea.append("ERROR: Product ID, must be 6 characters long (numeric values [0-9] only)!\n");
					}
					
					if (validateYear(year.getText()) == false) {
						textArea.append("ERROR: Year must be between 1000 and 9999 (numeric values only)! Try Again!");
					}
					
					/** If valid the add the Product */
					if (textArea.getText().isEmpty())
					{
						estore.addObject(pIDNum.getText(), name.getText(), year.getText(), authorg.getText(), publisher.getText(), price.getText(), prodList.getSelectedIndex());
						clear();
						textArea.append("Product Added Successfully!");
					}
				}
				/** When the state is SEARCH */
				else
				{
					/** Parse the integers for the year */
					int start_year = 0;
					int end_year = 0;

					/** Check if year field is empty for exception handling */
					if (!(year.getText().isEmpty()))
					{
						try
						{
							start_year = Integer.parseInt(year.getText());
						} catch(InputMismatchException ex) {
							textArea.append("ERROR: The year input is not a number!\n");
							start_year = 1000;
						} catch(NumberFormatException ex) {
							textArea.append("ERROR: The year is not a number!\n");
							start_year = 1000;
						}
					}
					if (!(eyear.getText().isEmpty()))
					{
						try
						{
							end_year = Integer.parseInt(eyear.getText());
						} catch(InputMismatchException ex) {
							textArea.append("ERROR: The year is not a number!\n");
							end_year = 1000;
						} catch(NumberFormatException ex) {
							textArea.append("ERROR: The year is not a number!\n");
							end_year = 1000;
						}
					}
					/** Logical validation of the year range */
					if (start_year > end_year && end_year > 0)
						textArea.append("ERROR: Start year can't be greater than end year!\n");
					if (((start_year < 1000 || start_year > 9999) && start_year > 0) || ((end_year < 1000 || end_year > 9999) && end_year > 0))
						textArea.append("ERROR: Year range has to be within 1000-9999\n");
					/** Search the list if validation tests passed */
					if ((textArea.getText().isEmpty()))
					{
						/** Retrieve the results */
						String ret = estore.searchList(pIDNum.getText(), name.getText(), start_year, end_year);
						textArea.append(ret);
					}
				}
			}
				
		}
	}
	
	/** ActionListener class for the JMenu */
	private class MenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/** Always clear beforehand */
			clear();
			
			/** Make Welcome panel invisible, and display the rest of the panels */
			if (welcomePanel.isVisible())
			{
				welcomePanel.setVisible(false);
				rightPanel.setVisible(true);
				bottomPanel.setVisible(true);
				addPanel.setVisible(true);
			}
			
			/** Exit the program if QUIT is pressed */
			if (e.getSource() == quit) {
				System.exit(0);
			}
			
			/** If user selects ADD, then show the appropriate fields and hide the rest */
			else if (e.getSource() == add)
			{
				indicator.setText("EStore Add a Product: ");
				prodList.setSelectedIndex(0);
				yearLab.setText("Year: ");
				typeRow.setVisible(true);
				authRow.setVisible(true);
				priceRow.setVisible(true);
				pubRow.setVisible(true);
				endYearRow.setVisible(false);
				execute.setText("Add");
				textLabel.setText("Message Console");
			}
			/** If user selects search, then show the appropriate fields and hide the rest */
			else
			{
				indicator.setText("EStore Search for Products: ");
				yearLab.setText("Start Year: ");
				typeRow.setVisible(false);
				authRow.setVisible(false);
				pubRow.setVisible(false);
				priceRow.setVisible(false);
				endYearRow.setVisible(true);
				execute.setText("Search");
				textLabel.setText("Search Results");
			}
			repaint();
		}
		
	}
}

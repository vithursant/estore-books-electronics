/**
 * Assignment Three - EStore Search - EStoreUI Class
 * 
 * Basic estore functions as it stores books and electronics, and user can search for them as well
 * The method method resides in this EStore UI class.
 * 
 * Author: Vithursan Thangarasa
 * Last Modified: November 30, 2016
 */

import java.io.File;

public class EStoreUI {
	/** The main class which contains the estore search object and main loop */
	public static void main(String[] args) {
		/** Preliminary initializations*/
		EStoreSearch estore;
		//String action = "";
		File source = new File("output.txt");

		/** EStore search object which is used to control the estore and its
		 * objects. If there is a file that exists, loads it into the estore.
		 */
		if (source.exists()) {
			estore = new EStoreSearch(source);
		/** Otherwise setup a new estore */
		} else {
			estore = new EStoreSearch();
		}
		/** Launch the JFrame and pass the estore to it */
		EStoreGUIFrame frame = new EStoreGUIFrame(estore);
		frame.setVisible(true);
		//estore.appendList(source);
	}

}

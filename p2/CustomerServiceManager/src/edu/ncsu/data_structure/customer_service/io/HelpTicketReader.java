package edu.ncsu.csc316.customer_service.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.CustomerComparator;
import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.data.HelpTicketComparator;
import edu.ncsu.csc316.customer_service.data.Timestamp;
import edu.ncsu.csc316.customer_service.tree.SplayTree;

/**
 * HelpTicket reader class which reads the information from the file and stores them
 * in the Splay trees.
 * I have the issue of null pointer exception and I got help on that from the 
 * Teaching Assistant Rezvan Mahdavi Hezaveh during her office hours on 10/10/2017.
 * @author premsubedi
 *
 */
public class HelpTicketReader {
	
	/**
	 * Reads each line of input file, which represents single help ticket object and
	 * inserts it to the Splay tree.
	 * I have used my own code from Project1 part2, which has similar logic for this 
	 * file reader method. 
	 * @param fileName name of the input file.
	 * @return 
	 * @return hTicketQueue queue of help tickets.
	 * @throws FileNotFoundException throws exception if file cannot be found.
	 */
	static HelpTicketComparator comparator1 = new HelpTicketComparator();
	
	/**
	 * Reads input file and adds the HelpTickets sorted by priority, time and name of customer.
	 * @param fileName input filename.
	 * @return hTicketQueue queue of HelpTicket sorted by above requirements.
	 * @throws FileNotFoundException throws exception if the file cannot be found.
	 */
	public static SplayTree<HelpTicket> readHelpTicketByPriority(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		SplayTree<HelpTicket> hTicketQueue = new SplayTree<HelpTicket>();
		input.nextLine();
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			Scanner timestampScanner = null; 
			Scanner scanDate = null;
			Scanner scanTime = null;
			try {
				String timestamp = lineScan.next();
				timestampScanner = new Scanner(timestamp);
				timestampScanner.useDelimiter(" ");
				String date = timestampScanner.next();
				scanDate = new Scanner(date);
				scanDate.useDelimiter("/");
				String month = scanDate.next();
				String day = scanDate.next();
				int year = scanDate.nextInt();
				String time = timestampScanner.next();
				scanTime = new Scanner(time);
				scanTime.useDelimiter(":");
				String hour = scanTime.next();
				String min = scanTime.next();
				String sec = scanTime.next();
				int priority = lineScan.nextInt();
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String question = lineScan.next();
				Timestamp submitTime = new Timestamp(month, day, year, hour, min, sec);
				Customer c = new Customer(firstName, lastName);
				HelpTicket hTicket = new HelpTicket(submitTime, priority, c, question);
				hTicketQueue.add(hTicket, comparator1);
			} catch (NoSuchElementException e) {
				lineScan.close();
				timestampScanner.close();
				scanDate.close();
				scanTime.close();
			}
			lineScan.close();
			timestampScanner.close();
			scanDate.close();
			scanTime.close();
		}
		input.close();
		return hTicketQueue;
	}

	/**
	 * Reads each line of input file, which represents single help ticket object and
	 * inserts it to the Splay tree.
	 * I have used my own code from Project1 part2, which has similar logic for this 
	 * file reader method. 
	 * @param fileName name of the input file.
	 * @return 
	 * @return hTicketQueue queue of help tickets.
	 * @throws FileNotFoundException throws exception if file cannot be found.
	 */
	static CustomerComparator comparator2 = new CustomerComparator();
	
	/**
	 * Reads input file and adds the HelpTickets sorted by last name and first name of customer associated 
	 * with that help ticket.
	 * @param fileName input filename.
	 * @return hTicketQueue queue of HelpTicket sorted by above requirements.
	 * @throws FileNotFoundException throws exception if the file cannot be found.
	 */
	public static SplayTree<HelpTicket> readHelpTicketByName(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		SplayTree<HelpTicket> hTicketQueue = new SplayTree<HelpTicket>();
		input.nextLine();
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			Scanner timestampScanner = null; 
			Scanner scanDate = null;
			Scanner scanTime = null;
			try {
				String timestamp = lineScan.next();
				timestampScanner = new Scanner(timestamp);
				timestampScanner.useDelimiter(" ");
				String date = timestampScanner.next();
				scanDate = new Scanner(date);
				scanDate.useDelimiter("/");
				String month = scanDate.next();
				String day = scanDate.next();
				int year = scanDate.nextInt();
				String time = timestampScanner.next();
				scanTime = new Scanner(time);
				scanTime.useDelimiter(":");
				String hour = scanTime.next();
				String min = scanTime.next();
				String sec = scanTime.next();
				int priority = lineScan.nextInt();
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String question = lineScan.next();
				Timestamp submitTime = new Timestamp(month, day, year, hour, min, sec);
				Customer c = new Customer(firstName, lastName);
				HelpTicket hTicket = new HelpTicket(submitTime, priority, c, question);
				hTicketQueue.add(hTicket, comparator2);
			} catch (NoSuchElementException e) {
				lineScan.close();
				timestampScanner.close();
				scanDate.close();
				scanTime.close();
			}
			lineScan.close();
			timestampScanner.close();
			scanDate.close();
			scanTime.close();
		}
		input.close();
		return hTicketQueue;
	}

}

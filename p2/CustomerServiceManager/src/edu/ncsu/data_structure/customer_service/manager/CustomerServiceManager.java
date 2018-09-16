package edu.ncsu.data_structure.customer_service.manager;

import java.io.FileNotFoundException;
import java.util.Comparator;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.CustomerComparator;
import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.data.Timestamp;
import edu.ncsu.csc316.customer_service.io.HelpTicketReader;
import edu.ncsu.csc316.customer_service.tree.SplayTree;

/**
 * This is the main class that handles all the functionality of customer
 * service manager.
 * @author premsubedi
 *
 */
public class CustomerServiceManager {
	private Customer customer;
	private Customer customer1;
	private HelpTicket hTicket;
	private Timestamp time;
	private SplayTree<HelpTicket> customers;
	private SplayTree<HelpTicket> tickets;
	private Comparator<HelpTicket> comparator1;
	
	/**
	 * CustomerServiceManager constructor which receives the tree queue from the input file reader.
	 * @param fileName name of the input file.
	 */
	public CustomerServiceManager(String fileName) {
		comparator1 = new CustomerComparator();
		customer1 = new Customer("Shyam", "Gautam");
		time = new Timestamp("04", "15", 2017, "10", "15", "08");
		hTicket = new HelpTicket(time, 0, customer1, "How are you?");
		try {
			tickets = HelpTicketReader.readHelpTicketByPriority(fileName);
			customers = HelpTicketReader.readHelpTicketByName(fileName);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}

	}

	/**
	 * Removes the customer from the help ticket software (for example,
	 * if the customer finds the answer to their question while waiting,
	 * they may cancel their help ticket instead of waiting to be serviced)
	 * @param firstName - the customer's first named
	 * @param lastName - the customer's last name
	 */
	public void removeCustomerFromQueue(String firstName, String lastName) {
		customer = new Customer(firstName, lastName);
		if((customer.getLastName().compareTo(hTicket.getCustomer().getLastName()) == 0) &&
		        (customer.getFirstName().compareTo(hTicket.getCustomer().getFirstName()) == 0))	{
			customers.remove(hTicket, comparator1);
		}

	}

	/**
	 * Outputs the customer's place in line in the help queue,
	 * along with the help ticket information in the format
	 * (with 2nd line indentation of 4 spaces and NO newline at the end):
	 *
	 * Bob Baker is number 3 in the queue:
	 *     Priority 2 submmited on 08/14/2017 at 06:54:00: Can I change my flight?
	 * 
	 * @param firstName - the customer's first name
	 * @param lastName - the customer's last name
	 * @return the customer's place in line and help ticket information
	 */
	public String getPlaceInLine(String firstName, String lastName) {
		customer = new Customer(firstName, lastName);
		int position = 0;
		if((customer.getLastName().compareTo(hTicket.getCustomer().getLastName()) == 0) &&
				(customer.getFirstName().compareTo(hTicket.getCustomer().getFirstName()) == 0))	{
			 hTicket = customers.lookUp(hTicket, comparator1);
			 position = customers.getNumberOfSuccessors();
		}
		return customer.toString() + " is number " + position + " in the queue:\n    " +
		"Priority " + hTicket.getPriority() + " submmited on " +
		hTicket.getSubmitTime().toString().substring(0, 10) + " at " 
		+ hTicket.getSubmitTime().toString().substring(11, 19) + ": " + hTicket.getQuestion();

	}

	/**
	 * Retrieves the complete help ticket queue, sorted in order 
	 * that the customers will be served. Higher priority is served 
	 * first, and (if priorities are the same) the help ticket
	 * with the earlier submission timestamp is serviced first.
	 * 
	 * The help queue is returned in the following format
	 * (with indentation of 4 spaces and NO newline at the very end):
	 *
	 * Priority 8: submitted at 11/11/2017 23:45:00 by John Smith, Question: How much does it cost to change flights on the same day?
	 * Priority 5: submitted at 09/03/2017 10:00:00 by Suzanne Smith, Question: How do I check my mileage balance?
	 * Priority 2: submitted at 10/14/2017 06:54:00 by Bob Baker, Question: Can I change my flight?
	 * 
	 * @return the help ticket queue listed in the order customers will be serviced
	 */
	public String getHelpTicketQueue() {
		String ticketQueue = "";
		if(!tickets.isEmpty()) {
			tickets.inOrder();
		}
		return ticketQueue;
	}

}

package edu.ncsu.data_structure.customer_service.data;

import java.util.Comparator;

/**
 * Customer comparator class which compares HelpTickets by customer's
 * first name and last name.
 * @author premsubedi
 *
 */
public class CustomerComparator implements Comparator<HelpTicket> {
	
	/**
	 * Compares customer by names.
	 */
	@Override
	public int compare(HelpTicket o1, HelpTicket o2) {
		if(o1.getCustomer().getLastName().compareTo(o2.getCustomer().getLastName()) < 0) {
			return -1;
		} else if(o1.getCustomer().getLastName().compareTo(o2.getCustomer().getLastName()) > 0) {
			return 1;
		} else {
			if(o1.getCustomer().getFirstName().compareTo(o2.getCustomer().getFirstName()) < 0) {
				return -1;
			} else if(o1.getCustomer().getFirstName().compareTo(o2.getCustomer().getFirstName()) > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	

}

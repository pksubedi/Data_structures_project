package edu.ncsu.data_structure.customer_service.data;

import java.util.Comparator;

/**
 * HelpTicket comparator which compares HelpTickets by priority and time.
 * @author premsubedi
 *
 */
public class HelpTicketComparator implements Comparator<HelpTicket> {
	@Override
	public int compare(HelpTicket o1, HelpTicket o2) {
		if(o1.compareTo(o2) < 0) {
			return -1;
		} else if (o1.compareTo(o2) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}

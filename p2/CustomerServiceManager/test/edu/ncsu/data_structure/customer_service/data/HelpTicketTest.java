package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

/**
 * Tests HelpTicket class.
 * @author premsubedi
 *
 */
public class HelpTicketTest {
	Comparator<HelpTicket> c = new HelpTicketComparator();
	static Customer c1 = new Customer("Abey", "Bance");
	static Customer c2 = new Customer("Santa", "Kirat");
	static Customer c3 = new Customer("Edward", "Bance");
	static Timestamp t1 = new Timestamp("09", "13", 2017, "10", "14", "15");
	static Timestamp t2 = new Timestamp("03", "15", 2017, "02", "04", "15");
	
	/** Ticket 1 object */
	public static final HelpTicket TICKET_1 = new HelpTicket(t1, 9, c1, "How much miles I earned?");
	
	/** Ticket 2 object. */
	public static final HelpTicket TICKET_2 = new HelpTicket(t2, 5, c2, "I want to change my flight.");
	
	/** Ticket 3 object */
	public static final HelpTicket TICKET_3 = new HelpTicket(t2, 5, c3, "I want to change my flight.");

	/**
	 * Tests HelpTicket constructor.
	 */
	@Test
	public void testHelpTicketConstructor() {
		Customer cus = new Customer ("Shyam", "Sharma");
		Timestamp submitTime = new Timestamp("09", "02", 2016, "10", "15", "25");
		HelpTicket hTicket = new HelpTicket(submitTime, 6, cus, "How to cancel my flight?");
		assertEquals(cus, hTicket.getCustomer());
		assertEquals(submitTime, hTicket.getSubmitTime());
		assertEquals("How to cancel my flight?", hTicket.getQuestion());
		assertEquals(6, hTicket.getPriority());
	}
	
	/**
	 * Tests compareTo method.
	 */
	@Test
	public void testCompareToHelpTicket() {
		assertEquals(1, c.compare(TICKET_1, TICKET_2));
		assertEquals(-1, c.compare(TICKET_2, TICKET_1));
		assertEquals(1, c.compare(TICKET_2, TICKET_3));
		assertEquals(-1, c.compare(TICKET_3, TICKET_2));
		assertEquals(1, TICKET_1.compareTo(TICKET_2));
		assertEquals(-1, TICKET_2.compareTo(TICKET_1));
		assertEquals(1, TICKET_2.compareTo(TICKET_3));
		assertEquals(-1, TICKET_3.compareTo(TICKET_2));
		assertEquals(0, TICKET_1.compare(TICKET_3, TICKET_1));
	}
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testToString() {
		assertEquals("Priority 9: submitted at 09/13/2017 10:14:15 by Abey Bance," +
	" Question: How much miles I earned?", TICKET_1.toString());
	}
	
	
}

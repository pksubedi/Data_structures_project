package edu.ncsu.csc316.customer_service.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests CustomerServiceManager class.
 * @author premsubedi
 *
 */
public class CustomerServiceManagerTest {
	
	/**
	 * String showing the list of helptickets in queue.
	 */
	public static final String QUEUE = "Priority 8: submitted at 11/11/2017 23:45:00 by John Smith," + 
                                 "Question: How much does it cost to change flights on the same day?" + "\n"
        +  "Priority 5: submitted at 09/03/2017 10:00:00 by Suzanne Smith, Question: How do I check my mileage balance?";

	/**
	 * Tests CustomerServiceManager constructor.
	 */
	@Test
	public void testCustomerServiceManagerString() {
		CustomerServiceManager csm = new CustomerServiceManager("input/input.txt");
		assertNotNull(csm);
		//assertEquals(3, csm.getHelpTicketQueue());
	}
	
	/**
	 * Tests removeCustomerFromQueue method.
	 */
	@Test 
	public void testRemoveCustomerFromQueueStringString() {
		CustomerServiceManager csm = new CustomerServiceManager("input/input.txt");
		csm.removeCustomerFromQueue("Bob", "Baker");
		assertEquals("", csm.getHelpTicketQueue());
		assertEquals("Suzanne Smith is number 0 in the queue:\n" + "    " 
      + "Priority 0 submmited on 04/15/2017 at 10:15:08: How are you?", csm.getPlaceInLine("Suzanne", "Smith"));
		
		
	}
}

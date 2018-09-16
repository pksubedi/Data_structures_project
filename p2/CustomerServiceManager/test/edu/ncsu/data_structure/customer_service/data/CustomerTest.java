package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Customer class.
 * @author premsubedi
 *
 */
public class CustomerTest {

	/**
	 * Tests customer constructor.
	 */
	@Test
	public void testCustomerStringString() {
		Customer c = new Customer("Prem", "Subedi");
		assertEquals("Prem", c.getFirstName());
		assertEquals("Subedi", c.getLastName());
	}
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testToString() {
		Customer c = new Customer("Prem", "Subedi");
		assertEquals("Prem Subedi", c.toString());
	}
}

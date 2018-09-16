package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Customer class.
 * @author premsubedi
 *
 */
public class CustomerTest {
	
	/**
	 * Tests Customer constructor.
	 */
	@Test
	public void customerStringStringStringStringStringString() {
		Customer c = new Customer("Prem", "Subedi", "05/10/2016", "EK243", "RDU", "BOS");
		assertEquals("Prem", c.getFirstName());
		assertEquals("Subedi", c.getLastName());
		assertEquals("05/10/2016", c.getDate());
		assertEquals("EK243", c.getFlight());
		assertEquals("RDU", c.getOrigin());
		assertEquals("BOS", c.getDestination());
	}

}

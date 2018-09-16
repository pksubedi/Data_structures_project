package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Miles class.
 * @author premsubedi
 *
 */
public class MilesTest {
	
	/**
	 * Tests Miles constructor.
	 */
	@Test
	public void milesStringStringint() {
		Miles ml = new Miles("05/02/2016", "AA234", "RDU", "JFK");
		assertEquals("05/02/2016", ml.getDate());
		assertEquals("AA234", ml.getFlight());
		assertEquals("RDU", ml.getOrigin());
		assertEquals("JFK", ml.getDestination());
	}

}

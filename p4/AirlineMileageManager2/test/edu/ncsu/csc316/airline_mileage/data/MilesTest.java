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
		Miles ml = new Miles(1195, "JFK");
		assertEquals(1195, ml.getMiles());
		assertEquals("JFK", ml.getIataCode());
	}

}

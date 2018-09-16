package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test AirportHub class.
 * @author premsubedi
 *
 */
public class AirportHubTest {
	
	/**
	 * Tests all the methods of airporthub class.
	 */
	@Test
	public void testAllMethods() {
		AirportHub ahub1 = new AirportHub("RDU", 3);
		AirportHub ahub2 = new AirportHub("TPA", 5);
		AirportHub ahub3 = new AirportHub("JFK", 2);
		assertEquals("RDU", ahub1.getCode());
		assertEquals(3, ahub1.getConnections());
		assertTrue(ahub1.isHub());
		assertTrue(ahub2.isHub());
		assertFalse(ahub3.isHub());
		
	}


}

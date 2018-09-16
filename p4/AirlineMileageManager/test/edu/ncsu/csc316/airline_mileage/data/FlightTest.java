package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Flight class.
 * @author premsubedi
 *
 */
public class FlightTest {
	
	/**
	 * Tests Flight constructor.
	 */
	@Test
	public void flightConstructorTest() {
		Flight fl = new Flight("12/24/2015", "AA", 246, "KTM", "JFK", 12000);
		assertEquals("12/24/2015", fl.getDate());
		assertEquals("AA", fl.getAirline());
		assertEquals(246, fl.getFlNumber());
		assertEquals("KTM", fl.getOrigin());
		assertEquals("JFK", fl.getDestination());
		assertEquals(12000, fl.getDistance());
	}

}

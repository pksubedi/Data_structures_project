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
		Flight fl1 = new Flight("2015/12/26", "AA", 246, "KTM", "JFK", 12000);
		Flight fl2 = new Flight("2015/12/26", "AA", 246, "KTM", "JFK", 12000);
		Flight fl3 = new Flight("2015/12/26", "B6", 243, "KTM", "JFK", 12000);
		Flight fl4 = new Flight("2015/12/26", "AA", 246, "KTM", "JFK", 12);
		Flight fl5 = new Flight("2015/12/26", null, 246, "KTM", "JFK", 12000);
		Flight fl6 = new Flight(null, "AA", 246, "KTM", "JFK", 12000);
		Flight fl7 = null;
		assertEquals("2015/12/26", fl1.getDate());
		assertEquals("AA", fl1.getAirline());
		assertEquals(246, fl1.getFlNumber());
		assertEquals("KTM", fl1.getOrigin());
		assertEquals("JFK", fl1.getDestination());
		assertEquals(12000, fl1.getDistance());
		assertTrue(fl1.equals(fl2));
		assertFalse(fl1.equals(fl3));
		assertFalse(fl1.equals(fl4));
		assertFalse(fl1.equals(fl5));
		assertFalse(fl1.equals(fl6));
		assertFalse(fl3.equals(fl5));
		assertFalse(fl1.equals(fl7));
	}
	
	

}

package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Airline class
 * @author premsubedi
 *
 */
public class AirlineTest {
	/**
	 * Tests airline
	 */
	@Test
	public void airlineStringStringStringString() {
		Airline a1 = new Airline("United Airlines", "UA" , "United", "USA");
		Airline a2 = new Airline("United Airlines", "UA" , "United", "USA");
		Airline a3 = null;
		Airline a4 = new Airline(null, "UA" , "United", "USA");
		Airline a5 = new Airline("United Airlines", "UA" , "United", null);
		Airline a6 = new Airline("United Airlines", "UA" , null, "USA");
		assertEquals("United Airlines", a1.getDesc());
		assertEquals("UA", a1.getIataCode());
		assertEquals("United", a1.getCallSign());
		assertEquals("USA", a1.getCountry());
		assertTrue(a1.equals(a2));
		assertTrue(a2.equals(a1));
		assertFalse(a1.equals(a3));
		assertFalse(a1.equals(a4));
		assertFalse(a4.equals(a1));
		assertFalse(a5.equals(a1));
		assertFalse(a1.equals(a5));
		assertFalse(a1.equals(a6));
	}

}

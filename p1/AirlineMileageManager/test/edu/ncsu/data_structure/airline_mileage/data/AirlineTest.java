package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Airline class.
 * @author premsubedi
 *
 */
public class AirlineTest {
	
	/**
	 * Test Airline constructor
	 */
	@Test
	public void airlineStringStringStringString() {
		Airline a = new Airline("United Airlines", "UA" , "United", "USA");
		assertEquals("United Airlines", a.getDesc());
		assertEquals("UA", a.getIataCode());
		assertEquals("United", a.getCallSign());
		assertEquals("USA", a.getCountry());
	}

}

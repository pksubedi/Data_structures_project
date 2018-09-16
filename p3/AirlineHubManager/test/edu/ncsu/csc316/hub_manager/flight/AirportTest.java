package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests airport class.
 * @author premsubedi
 *
 */
public class AirportTest {
	
	/**
	 * Tests all Airport methods.
	 */
	@Test
	public void testAllMethodsOfAirport() {
		Airport a1 = new Airport("DFW", 32.89680099487305, -97.03800201416016, 1);
		Airport a2 = new Airport("DFW", 32.89680099487305, -97.03800201416016, 1);
		Airport a3 = new Airport( null, 32.89680099487305, -97.03800201416016, 1);
		Airport a4 = new Airport("DFW", 32.89680099487305, -77.03800201416016, 1);
		Airport a5 = null;
		assertEquals("DFW", a1.getCode());
		assertEquals(32.89680099487305, a1.getLatitude(), 0.0001);
		assertEquals(-97.03800201416016, a1.getLongitude(), 0.0001);
		assertEquals(32.89680099487305, a1.getLatitude(), 0.0001);
		assertTrue(a1.equals(a2));
		assertTrue(a2.equals(a1));
		assertFalse(a2.equals(a3));
		assertFalse(a3.equals(a2));
		assertFalse(a1.equals(a4));
		assertFalse(a4.equals(a1));
		assertFalse(a1.equals(a5));
		assertEquals(1, a1.getIntegerPosition());
		a2.setIntegerPosition(4);
		assertEquals(4, a2.getIntegerPosition());
		
	}
	

}

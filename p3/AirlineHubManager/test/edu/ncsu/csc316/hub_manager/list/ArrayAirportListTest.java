package edu.ncsu.csc316.hub_manager.list;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;

/**
 * Tests ArrayAirportList class.
 * @author premsubedi
 *
 */
public class ArrayAirportListTest {
	/** Valid airport object */
	public static final Airport A_1 = new Airport("DFW", 32.89680099487305, -97.03800201416016, 1);
	
	/** Valid airport object */
	public static final Airport A_2 = new Airport("MIA", 25.79319953918457, -80.29060363769531, 2);
	
	/** Valid airport object */
	public static final Airport A_3 = new Airport("ORH", 42.26729965209961, -71.87570190429688, 3);
	
	/** Valid airport object */
	public static final Airport A_4 = new Airport("RDU", 35.877601623535156, -78.7874984741211, 4);
	
	/** Valid airport object */
	public static final Airport A_5 = new Airport("SEA", 47.44900131225586, -122.30899810791016, 5);
	
	/** Valid airport object */
	public static final Airport A_6 = new Airport("SFO", 37.61899948120117, -122.375, 6);
	
	/**
	 * Tests ArrayAirportList class.
	 */
	@Test
	public void testArrayAirportList() {
		ArrayAirportList<Airport> list = new ArrayAirportList<Airport>(6);
		assertEquals(0, list.size());
		list.add(A_1);
		list.add(A_3);
		assertEquals(2, list.size());
		assertEquals(A_3, list.get(1));
		list.add(A_5);
		list.add(A_2);
		assertEquals(4, list.size());
		list.add(2, A_6);
		list.remove(0);
		list.remove(1);
		assertEquals(3, list.size());
		
		try {
			list.get(-1);
			list.add(-2, A_4);
			list.remove(9);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, list.size());
			assertEquals(A_3, list.get(0));
		}
		
		list.add(A_1);
		list.add(2, A_4);
		list.add(A_6);
		assertEquals(6, list.size());
		assertEquals(A_2, list.get(3));
		assertEquals(A_3, list.get(0));
		assertEquals(0, list.indexOf(A_3));
		assertEquals(3, list.indexOf(A_2));
		list.remove(3);
		assertEquals(-1, list.indexOf(A_2));
	
	}
	
}

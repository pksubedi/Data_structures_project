package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests FlightLeg class.
 * @author premsubedi
 *
 */
public class FlightLegTest {
	
	
	/** Valid airport object */
	public static final Airport A_1 = new Airport("DFW", 32.89680099487305, -97.03800201416016, 1);
	
	/** Valid airport object */
	public static final Airport A_1_SAME = new Airport("DFW", 32.89680099487305, -97.03800201416016, 1);
	
	/** Valid airport object */
	public static final Airport A_X = new Airport("TPA", 32.89680099487305, -97.03800201416016, 1);
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
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_1 = new FlightLeg(A_3, A_4);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_2 = new FlightLeg(A_5, A_6);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_3 = new FlightLeg(A_2, A_4);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_4 = new FlightLeg(A_1, A_4);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_5 = new FlightLeg(A_1, A_6);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_6 = new FlightLeg(A_6, A_1);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_7 = new FlightLeg(A_6, A_X);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_8 = new FlightLeg(A_6, A_1_SAME);
	
	/** Valid FlightLeg object */
	public static final FlightLeg F_9 = null;
	
	/**
	 * Tests compareTo method.
	 */
	@Test
	public void testCompareTo() {
		assertEquals(-1, F_1.compareTo(F_2));
		assertEquals(1, F_2.compareTo(F_1));
		assertEquals(-1, F_2.compareTo(F_3));
		assertEquals(1, F_3.compareTo(F_2));
		assertEquals(-1, F_5.compareTo(F_6));
		assertEquals(1, F_6.compareTo(F_5));
		assertEquals(-1, F_6.compareTo(F_7));
		assertEquals(1, F_7.compareTo(F_6));
		assertEquals(0, F_6.compareTo(F_6));
	}
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testToString() {
		assertEquals("   Flight[airport1=ORH, airport2=RDU, distance=576.4]", F_1.toString());
		assertEquals("   Flight[airport1=SEA, airport2=SFO, distance=679.6]", F_2.toString());
	}
	
	/**
	 * Tests Equals method.
	 */
	@Test
	public void testEquals() {
		assertTrue(F_6.equals(F_8));
		assertFalse(F_1.equals(F_2));
		assertFalse(F_6.equals(F_7));
		assertFalse(F_3.equals(F_9));
	}
	
}

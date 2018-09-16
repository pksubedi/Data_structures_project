package edu.ncsu.csc316.hub_manager.priority_queue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Tests MinHeap class.
 * @author premsubedi
 *
 */
public class MinHeapTest {
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
	
	/** Valid FlightLeg array */
	public static final FlightLeg[] ARRAY = {F_1, F_2, F_3, F_4, F_5, F_6};
	/**
	 * Tests minheap class
	 */
	@Test
	public void testMinHeapClass() {
		MinHeap mh = new MinHeap();
		mh.insert(F_3);
		mh.insert(F_1);
		mh.insert(F_5);
		mh.insert(F_6);
		assertEquals(4, mh.getSize());
		assertEquals(F_1, mh.deleteMin());
		
		
		
	}

}

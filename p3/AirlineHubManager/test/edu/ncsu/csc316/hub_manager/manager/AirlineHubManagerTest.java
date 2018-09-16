package edu.ncsu.csc316.hub_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests AirlineHubManager class.
 * @author premsubedi
 *
 */
public class AirlineHubManagerTest {
	
	private static final String FLIGHT_LIST = "FlightList[\n" +
   "   Flight[airport1=ORH, airport2=RDU, distance=576.4],\n" +
   "   Flight[airport1=SEA, airport2=SFO, distance=679.6],\n" +
   "   Flight[airport1=MIA, airport2=RDU, distance=702.8],\n" +
   "   Flight[airport1=DFW, airport2=RDU, distance=1059.7],\n" +
   "   Flight[airport1=DFW, airport2=SFO, distance=1462.3]\n" +
"]";

	/**
	 * String representing Hub report.
	 */
	public static final String HUB_REPORT = "HubReport[\n" + "   RDU has 3 connections.\n" + "]";

	/**
	 * Tests AirlineHubManager constructor.
	 */
	@Test
	public void testAirlineHubManagerString() {
		AirlineHubManager ahm = new AirlineHubManager("input/airport_records.txt");
		assertEquals(6, ahm.aalist.size());
	}
	
	/**
	 * Tests getMinimumFlights() method.
	 */
	@Test
	public void testGetMinimumFlights() {
		AirlineHubManager ahm = new AirlineHubManager("input/airport_records.txt");
		assertEquals(FLIGHT_LIST, ahm.getMinimumFlights());
		
	}
	
	/**
	 * Tests getPossibleHubs method.
	 */
	@Test
	public void testGetPossibleHubs() {
		AirlineHubManager ahm = new AirlineHubManager("input/airport_records.txt");
		
		assertEquals(HUB_REPORT, ahm.getPossibleHubs());
	}
}

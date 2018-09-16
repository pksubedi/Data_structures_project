package edu.ncsu.csc316.airline_mileage.manager;

import static org.junit.Assert.*;


import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.manager.AirlineMileageManager;

/**
 * Tests AirlineMileageManager class.
 * @author premsubedi
 *
 */
public class AirlineMileageManagerTest {
	private final String inputFile1 = "input/airlineFile.txt";
	private final String inputFile2 = "input/customerFile.txt";
	private final String inputFile3 = "input/flightInfoFile.txt";
	
	/**
	 * Tests getMileageReport().
	 */
	@Test
	public void testGetMileageReport() {
		AirlineMileageManager amm = new AirlineMileageManager(inputFile1, inputFile2, inputFile3);
		assertEquals(null, amm.getMiles(null, null));
		
	}

}

package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests FlightReader class.
 * @author premsubedi
 *
 */
public class FlightReaderTest {
	private static final String INPUT_FILE = "input/flightInfoFile.txt";
	
	/**
	 * Tests readFlightInfo method.
	 */
	@Test
	public void testReadFlightInfo() {
	
		try {
			ArrayBasedList<Flight> flist = FlightReader.readFlightInfo(INPUT_FILE);
			assertEquals(3, flist.size());
			assertEquals(346, flist.get(0).getFlNumber());
			assertEquals("UA", flist.get(0).getAirline());
			assertEquals("B6", flist.get(2).getAirline());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		}
	

}

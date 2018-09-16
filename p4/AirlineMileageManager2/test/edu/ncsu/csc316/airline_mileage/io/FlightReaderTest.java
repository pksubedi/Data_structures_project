package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

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
			HashTable<Flight> flist = FlightReader.readFlightInfo(INPUT_FILE);
			assertEquals(2, flist.getSize());
			
		} catch (FileNotFoundException e) {
			//e.getMessage();
		}	
		
		}
	

}

package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;

/**
 * Tests AirlineReader class.
 * @author premsubedi
 *
 */
public class AirlineReaderTest {
	private static final String INPUT_FILE = "input/airlineFile.txt";
	
	/**
	 * Tests readAirline() method.
	 */
	@Test
	public void testReadAirline() {
		try {
			ArrayBasedList<Airline> list = AirlineReader.readAirline(INPUT_FILE);
			assertEquals(3, list.size());
			assertEquals("UA", list.get(0).getIataCode());
			assertEquals("Delta Air Lines", list.get(1).getDesc());
			assertEquals("United States", list.get(2).getCountry());
			assertEquals("UNITED", list.get(0).getCallSign());	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

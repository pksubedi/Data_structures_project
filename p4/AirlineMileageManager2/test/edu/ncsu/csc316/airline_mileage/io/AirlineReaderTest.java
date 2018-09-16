package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests AirlineReader class.
 * @author premsubedi
 *
 */
public class AirlineReaderTest {
	private static final String INPUT_FILE = "input/airlineFile.txt";
	private static final Airline A_1 = new Airline("United Airlines", "UA", "UNITED", "United States");
	private static final Airline A_2 = new Airline("JetBlue Airways", "B6", "JETBLUE", "United States");
	private static final Airline A_3 = new Airline("Delta Air Lines", "DL", "DELTA", "United States");
	/**
	 * Tests readAirline() method.
	 */
	@Test
	public void testReadAirline() {
		try {
			HashTable<Airline> list = AirlineReader.readAirline(INPUT_FILE);
			list.insert(A_1);

			assertTrue(list.lookUp(A_1));
			assertTrue(list.lookUp(A_2));
			assertTrue(list.lookUp(A_3));
			assertEquals(4, list.getSize());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

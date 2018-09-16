package edu.ncsu.csc316.hub_manager.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.list.ArrayAirportList;

/**
 * Tests AirportReader
 * @author premsubedi
 *
 */
public class AirportReaderTest {
	private static final double EPSILON_PRECISION = 0.0001;
	private static final String VALID_INPUT_FILE = "input/airport_records.txt";

	/**
	 * Tests static method readAirport().
	 */
	@Test
	public void testReadAirport() {
		try {
			ArrayAirportList<Airport> list = AirportReader.readAirport(VALID_INPUT_FILE);
			assertEquals(6, list.size());
			assertEquals("DFW", list.get(0).getCode());
			assertEquals("SFO", list.get(5).getCode());
			assertEquals(35.877601623535156, list.get(3).getLatitude(), EPSILON_PRECISION);
			assertEquals(-122.375, list.get(5).getLongitude(), EPSILON_PRECISION);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

}

package edu.ncsu.csc316.hub_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.list.ArrayAirportList;

/**
 * Reads airports from the file.
 * @author premsubedi
 *
 */
public class AirportReader {

	private static int count = 0;
	/**
	 * Reads from the file with given filename and parse the necessary datas to create an airport
	 * And adds the airports to the list and returns list.
	 * @param pathToAirportFile filename containing the airport information.
	 * @return list list of airports.
	 * @throws FileNotFoundException
	 */
	public static ArrayAirportList<Airport> readAirport(String pathToAirportFile) throws FileNotFoundException {
		Scanner input = new Scanner(new File(pathToAirportFile));
		ArrayAirportList<Airport> list = new ArrayAirportList<Airport>(6);
		input.nextLine();
		while(input.hasNextLine()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			try {
				String code = lineScan.next();
				double latid = lineScan.nextDouble();
				double longitd = lineScan.nextDouble();
				Airport a = new Airport(code, latid, longitd, count);
				list.add(a);
			} catch (NoSuchElementException e) {
				lineScan.close();
			}
			count++;
			lineScan.close();	
		}
		input.close();
		return list;
	}
}

package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Flight reader class which reads information from the file and put them 
 * in the list of flights.
 * @author premsubedi
 *
 */
public class FlightReader {

	/**
	 * Static method which returns the list of flights by reading from the file.
	 * Used some ideas of scanner reader from the CSC216 course (Referred Dr. Heckman's lecture slides
	 * and my own class notes to generate the idea.
	 * @param fileName name of the file to read from.
	 * @return fList list of flights to be returned.
	 * @throws FileNotFoundException if the file can't be found.
	 */
	public static ArrayBasedList<Flight> readFlightInfo(String fileName) 
			throws FileNotFoundException {
		ArrayBasedList<Flight> fList = new ArrayBasedList<Flight>();
		Scanner input = new Scanner(new File(fileName));
		
		while(input.hasNextLine()) {
			Flight flight = null;
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			try {
				int year = lineScan.nextInt();
				int month = lineScan.nextInt();
				int day = lineScan.nextInt();
				lineScan.nextInt();
				String aline = lineScan.next();
				int flNumber = lineScan.nextInt();
				String origin = lineScan.next();
				String destination = lineScan.next();
				lineScan.nextInt();
				lineScan.nextInt();
				int distance = lineScan.nextInt();
				lineScan.nextInt();
				lineScan.nextInt();
				String date = day + "/" + month + "/" + year;
				flight = new Flight(date, aline, flNumber, origin, destination, distance);
				fList.add(flight);
			} catch(NoSuchElementException e) {
				lineScan.close();
			}
			lineScan.close();
			input.close();
		}
		return fList;
	}
}

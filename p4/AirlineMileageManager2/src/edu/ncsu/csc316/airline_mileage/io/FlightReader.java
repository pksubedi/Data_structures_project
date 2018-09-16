package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Flight reader class which reads information from the file and put them 
 * in the list of flights.
 * @author PremSubedi
 *
 */
public class FlightReader {

	/**
	 * Static method which returns the list of flights by reading from the file.
	 * Used my code from project 1.
	 * @param fileName name of the file to read from.
	 * @return fList list of flights to be returned.
	 * @throws FileNotFoundException if the file can't be found.
	 */
	public static HashTable<Flight> readFlightInfo(String fileName) 
			throws FileNotFoundException {
		HashTable<Flight> fList = new HashTable<Flight>(3);
		Scanner input = new Scanner(new File(fileName));
		input.nextLine();
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
				StringBuilder date = new StringBuilder();
				date.append(year + "/");
				date.append(month + "/");
				date.append(day);
				flight = new Flight(date.toString(), aline, flNumber, origin, destination, distance);
				fList.insert(flight);
			} catch(NoSuchElementException e) {
				e.getMessage();
			}
			lineScan.close();
			
		}
		input.close();
		return fList;
	}
}

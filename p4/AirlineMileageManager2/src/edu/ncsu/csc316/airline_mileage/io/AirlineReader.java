package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Airline reader class which reads the information from the file and turns them in to 
 * the list of airlines.
 * @author premsubedi
 *
 */
public class AirlineReader {
	
	/**
	 * Static method which reads information from the file and convert them into the list
	 * of Airlines.
	 * Used my code from project 1.
	 * and my own class notes to generate the idea.
	 * @param fileName name of the file to read from.
	 * @return aList the list airline to be returned.
	 * @throws FileNotFoundException if the file can't be found.
	 */
	public static HashTable<Airline> readAirline(String fileName) throws FileNotFoundException {
		Scanner input1 = new Scanner(new File(fileName));
		HashTable<Airline> aList = new HashTable<Airline>(10);
	    input1.nextLine();
		while(input1.hasNextLine()) {
			
			String line = input1.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			
			try { 
				String desc = lineScan.next();
				String iataCode = lineScan.next();
				String callSign = lineScan.next();
				String country = lineScan.next();
				Airline airline = new Airline(desc, iataCode, callSign, country);
				aList.insert(airline);
			} catch (NoSuchElementException e) {
				lineScan.close();
			}
			lineScan.close();
		}
		input1.close();
		return aList;
	}

}

package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;


/**
 * CustomerReader class which reads Customer info file.
 * @author premsubedi 
 *
 */
public class CustomerReader {
	
	/**
	 * Static method that returns the list of the customer after reading from the file.
	 * Used my code from project 1.
	 * @param fileName name of the file that holds the customer information.
	 * @return cList list of customer returned.
	 * @throws FileNotFoundException if file cannot be found.
	 */
	public static HashTable<Customer> readCustomerFile(String fileName) 
			throws FileNotFoundException {
		HashTable<Customer> cList = new HashTable<Customer>(3);
		Scanner input2 = new Scanner(new File(fileName));
		input2.nextLine();
		while(input2.hasNextLine()) {
			Customer customer = null;
			String line = input2.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(",");
			try {
				String firstName = lineScan.next();
				String lastName = lineScan.next();
				String date = lineScan.next();
				String flightString = lineScan.next();
				String iataCode = flightString.substring(0, 2);
				int flightNumber = Integer.parseInt(flightString.substring(2));
				String origin = lineScan.next();
				String destination = lineScan.next();
				Flight flight = new Flight(date, iataCode, flightNumber, origin, destination, 0);
				customer = new Customer(firstName, lastName, new HashTable<Flight>(2));
				cList.insert(customer);
				customer.addFlightToList(flight);
			} catch (NoSuchElementException e) {
				lineScan.close();
			}
			lineScan.close();
		}
		input2.close();
		return cList;
		
	}

}

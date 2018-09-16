package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * CustomerReader class which reads Customer info file.
 * @author premsubedi 
 *
 */
public class CustomerReader {
	
	/**
	 * Static method that returns the list of the customer after reading from the file.
	 * Used some ideas of scanner reader from the CSC216 course (Referred Dr. Heckman's lecture slides
	 * and my own class notes to generate the idea.
	 * @param fileName name of the file that holds the customer information.
	 * @return cList list of customer returned.
	 * @throws FileNotFoundException if file cannot be found.
	 */
	public static ArrayBasedList<Customer> readCustomerFile(String fileName) 
			throws FileNotFoundException {
		ArrayBasedList<Customer> cList = new ArrayBasedList<Customer>();
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
				String flight = lineScan.next();
				String origin = lineScan.next();
				String destination = lineScan.next();
				customer = new Customer(firstName, lastName, date, flight, origin, destination);
				cList.add(customer);
			} catch (NoSuchElementException e) {
				lineScan.close();
			}
			lineScan.close();
		}
		input2.close();
		return cList;
		
	}

}

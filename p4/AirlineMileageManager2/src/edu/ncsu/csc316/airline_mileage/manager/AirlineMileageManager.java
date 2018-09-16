/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
//import edu.ncsu.csc316.airline_mileage.data.Miles;
//import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;

/**
 * This is the top level class or manager class that runs the program
 * I couldn't finish implementing this class. 
 * @author PremSubedi
 */
public class AirlineMileageManager {
	
	/** File containing the list of airlines */
	@SuppressWarnings("unused")
	private HashTable<Airline> aList;
	
	/** File containing the card holder or customer information */
	
	private HashTable<Customer> cList;
	
	/** File containing the list of flights */
	private HashTable<Flight> fList;
	
	/**
	 * Constructs an AirlineMileageManager
	 * 
	 * @param pathToAirlineFile - path to the airline information file
	 * @param pathToCustomerFile - path to the customer information file
	 * @param pathToFlightFile - path to the flight information file
	 * @throws FileNotFoundException 
	 */
	public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile, String pathToFlightFile) {
		try {
			aList = AirlineReader.readAirline(pathToAirlineFile);
			cList = CustomerReader.readCustomerFile(pathToCustomerFile);
			fList = FlightReader.readFlightInfo(pathToFlightFile);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	/**
	 * Produces the mileage report for all cardholders
	 * as a String, sorted alphabetically by cardholder
	 * last name.
	 * 
	 * @return the mileage report for all customers
	 * @throws FileNotFoundException 
	 */
	public String getMileageReport () {
		StringBuilder string = new StringBuilder();
        Customer c = new Customer("Prem", "Subedi", fList);
        for (int i = 0; i < cList.getSize(); i++) {
            c = cList.get(c);
            if (i != 0) {
                string.append("\n\n");
            }
            string.append(getMiles(c.getFirstName(), c.getLastName()));
        }
        return string.toString();
        
	}
	
	/**
	 * Retrieves the frequent flier mileage for the specified
	 * cardholder with the given first name and last name.
	 * Miles are listed in descending order by distance
	 * 
	 * @param firstName - the cardholder's first name
	 * @param lastName - the cardholder's last name
	 * @return the frequent flier mileage information for the cardholder
	 */
	public String getMiles(String firstName, String lastName) {
	
		return lastName;
	    
	}
	
	
	

}

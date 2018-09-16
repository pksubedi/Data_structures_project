/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

/**
 * This programs calculates and reports the total miles traveled by the cardholders
 * Ideas of the code implementation for mergesort and binarysearch is referenced from
 * the CSC316 Dr. King lecture slides titled Dictionaries.pdf.
 * @author PremSubedi
 */
public class AirlineMileageManager {
	
	/** File containing the list of airlines */
	@SuppressWarnings("unused")
	private String airlineFile;
	
	/** File containing the card holder or customer information */
	@SuppressWarnings("unused")
	private String customerFile;
	
	/** File containing the list of flights */
	@SuppressWarnings("unused")
	private String flightFile;
	
	/**
	 * Constructs an AirlineMileageManager
	 * 
	 * @param pathToAirlineFile - path to the airline information file
	 * @param pathToCustomerFile - path to the customer information file
	 * @param pathToFlightFile - path to the flight information file
	 * @throws FileNotFoundException 
	 */
	public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile, String pathToFlightFile) {
		this.airlineFile = pathToAirlineFile;
		this.flightFile = pathToFlightFile;
		this.customerFile = pathToCustomerFile;
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
//		String report = "";
//		ArrayBasedList<Customer> list = null;
//		try {
//			list = mergeSort(CustomerReader.readCustomerFile(customerFile));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(int i = 0; i < list.size(); i++) {
//			report += list.get(i);
//		}
//		
		return null;
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
	    return null;
	}
	
	

}

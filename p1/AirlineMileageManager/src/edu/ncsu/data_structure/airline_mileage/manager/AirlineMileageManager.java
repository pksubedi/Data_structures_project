/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

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
		String report = "";
		ArrayBasedList<Customer> list = null;
		try {
			list = mergeSort(CustomerReader.readCustomerFile(customerFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < list.size(); i++) {
			report += list.get(i);
		}
		
		return report;
	}
	
	/**
	 * Sorts the list using mergeSort algorithm.
	 * I refer the algorithm from Dr. King's lecture slides titled 
	 * Dictionaries.pdf
	 * @param list list to be sorted.
	 * @return list the sorted list returned
	 */
	public ArrayBasedList<Customer> mergeSort(ArrayBasedList<Customer> list) {
		if(list.size() > 1) {
			int middle = list.size() / 2;
			ArrayBasedList<Customer> left = copy(list, 0, middle);
			ArrayBasedList<Customer> right = copy(list, middle + 1, list.size() - 1);
			left = mergeSort(left);
			right = mergeSort(right);
			list = merge(left, right, list);
			
		}
		return list;
	}
	
	/**
	 * Private helper method for merging the parts of the list 
	 * into the whole after get sorted.
	 * @param l left half list
	 * @param r right half of the list
	 * @param list whole list
	 * @return sorted list
	 */
	private ArrayBasedList<Customer> merge(ArrayBasedList<Customer> l, ArrayBasedList<Customer> r, ArrayBasedList<Customer> list) {
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = 0; i <= list.size() - 1; i++) {
			if(rightIndex >= r.size() || (leftIndex < l.size() && l.get(leftIndex).compareTo(r.get(rightIndex)) < 0)) {
				list.set(i, l.get(leftIndex));
				leftIndex++;
			} else {
				list.set(i, r.get(rightIndex));
				rightIndex++;
			}
		}
		return list;
	}

	/**
	 * Private helper method copy, which copies the list from
	 * one to the other.
	 * @param list whole list
	 * @param i initial index from where the list needs to be copied.
	 * @param f final index where to stop copying
	 * @return copied list list copied from the whole list.
	 */
	private ArrayBasedList<Customer> copy(ArrayBasedList<Customer> list, int i, int f) {
		ArrayBasedList<Customer> copiedList = new ArrayBasedList<Customer>();
		for(int j = i; j < f; j++) {
			copiedList.add(list.get(j));
		}
		return copiedList;
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
		ArrayBasedList<Customer> list = null;
		try {
			list = mergeSort(CustomerReader.readCustomerFile(customerFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String customerinfo = binarySearch(list, firstName, lastName, 0, list.size()).toString();
		
	    return customerinfo;
	}
	
	/**
	 * Searches the customer with first name and last name using binary search
	 * algorithm
	 * @param list customer list.
	 * @param firstName first name of the customer.
	 * @param lastName last name of the customer.
	 * @param low lower index in the list.
	 * @param high higher index in the list.
	 * @return customer that matched with the first name and last name.
	 */
	public Customer binarySearch(ArrayBasedList<Customer> list, String firstName, String lastName, int low, int high) {
		if(low > list.size()) {
			return null;
		} else {
			int mid = list.size() / 2;
			if(list.get(mid).getFirstName().compareTo(firstName) == 0 
					&& list.get(mid).getLastName().compareTo(lastName) == 0) {
				return list.get(mid);
				
			} else if(lastName.compareTo(list.get(mid).getLastName()) < 0) {
				return binarySearch(list, firstName, lastName, low, mid - 1);
			} else {
				return binarySearch(list, firstName, lastName, mid + 1, high);
			}	
		}
	}

}

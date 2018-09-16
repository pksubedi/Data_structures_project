package edu.ncsu.csc316.airline_mileage.data;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;
/**
 * This class represents a single customer/traveler.
 * @author premsubedi
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private HashTable<Flight> lFlights;
	/**
	 * Constructor which initializes it's fields.
	 * @param firstName first name of the passenger
	 * @param lastName last name of the passenger
	 * @param listOfFlights a list of flights the customer have.
	 */
	public Customer(String firstName, String lastName, HashTable<Flight> listOfFlights) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.lFlights = listOfFlights;
	}
	
	/**
	 * Returns the Cardholder's list of flights.
	 * @return lFlights list of flights.
	 */
	public HashTable<Flight> getList() {
		return lFlights;	
	}
	
	/**
	 * Adds flights to the Customer's list of flights.
	 * @param f given flight to be added on the list.
	 */
	public void addFlightToList(Flight f) {
		lFlights.insert(f);
	}
	
	/**
	 * Returns the number of flights the customer flew.
	 * @return size the size of the flights
	 */
	public int getNumberOfFlights() {
		return lFlights.getSize();
	}
	/**
	 * Returns Cardholder's first name
	 * @return firstName cardholde's firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	/** 
	 * Returns cardholder's last name.
	 * @return lastName cardholder's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Compares current Customer with passed customer, if the 
	 * current customer comes before the passed customer, returns -1,
	 * returns 1 if current customer comes after and 0 otherwise.
	 * @param c passed or given customer
	 * @return integer value 
	 */
	public int compareTo(Customer c) {
		if(this.getLastName().compareTo(c.getLastName()) < 0) {
			return -1;
		} else if(this.getLastName().compareTo(c.getLastName()) > 0) {
			return 1;
		} else {
			if(this.getFirstName().compareTo(c.getFirstName()) < 0) {
				return -1;
			} else if (this.getFirstName().compareTo(c.getFirstName()) > 0) {
				return 1;
			} else {
				return 0;
			}
		}	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	

}

package edu.ncsu.csc316.airline_mileage.data;

/**
 * This class represents a single customer/traveler.
 * @author premsubedi
 *
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String date;
	private String flight;
	private String origin;
	private String destination;
	/**
	 * Constructor which initializes it's fields.
	 * @param firstName first name of the passenger
	 * @param lastName last name of the passenger
	 * @param date date the customer traveled
	 * @param flight flight number 
	 * @param origin origin airport
	 * @param destination destination airport
	 */
	public Customer(String firstName, String lastName, String date, String flight, String origin, String destination) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.flight = flight;
		this.origin = origin;
		this.destination = destination;
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
	 * Returns travel date.
	 * @return the date traveled date of the cardholder
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Return the flight used by cardholder.
	 * @return the flight flight used by the cardholder.
	 */
	public String getFlight() {
		return flight;
	}
	/**
	 * Returns origin airport of the cardholder.
	 * @return the origin origin ariport.
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * Returns destination airport of the cardholder.
	 * @return destination destination airport 
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * Compares current Customer with passed customer, if the 
	 * current customer comes before the passed customer, returns -1,
	 * returns 1 if current customer comes after and 0 otherwise.
	 * @param c passed or given customer
	 * @return integer value 
	 */
	public int compareTo(Customer c) {
		if(this.getLastName().compareTo(c.getFirstName()) < 0) {
			return -1;
		} else if(this.getLastName().compareTo(c.getFirstName()) > 0) {
			return 1;
		} else {
		return 0;
		}
		
		
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", date=" + date + ", flight=" + flight
				+ ", origin=" + origin + ", destination=" + destination + "]";
	}
	
	
	
	
	

}

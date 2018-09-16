package edu.ncsu.data_structure.customer_service.data;

/**
 * Customer class which represents a single customer.
 * @author premsubedi
 *
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	/**
	 * Customer constructor which initializes it's fields.
	 * @param firstName firstName of the customer.
	 * @param lastName last name of the customer.
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Returns first name.
	 * @return firstName customer's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns last name.
	 * @return lastName last name of the customer.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns string representation of the customer.
	 * @return string representation of the name.
	 */
	public String toString() {
		return firstName + " " + lastName;
	}
}

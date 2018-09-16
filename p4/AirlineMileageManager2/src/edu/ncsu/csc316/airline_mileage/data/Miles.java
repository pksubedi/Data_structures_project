package edu.ncsu.csc316.airline_mileage.data;

/**
 * This class represents miles object traveled by the customer.
 * @author premsubedi
 *
 */
public class Miles {
	private int miles;
	private String code;
	
	/**
	 * Miles constructor which initializes it's fields.
	 * @param miles accumulated miles with the particular ailrine for a given customer.
	 * @param iataCode airline code for which the accumulated miles to be calculated.
	 */
	public Miles(int miles, String iataCode) {
		this.miles = miles;
		code = iataCode;
	}

	/**
	 * Returns accumulated miles from particular airline for a given customer.
	 * @return miles the miles.
	 */
	public int getMiles() {
		return miles;
	}

	/**
	 * Returns airline for which the mileage to be calculated.
	 * @return airline the airline.
	 */
	public String getIataCode() {
		return code;
	}


}

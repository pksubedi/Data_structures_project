package edu.ncsu.csc316.airline_mileage.data;

/**
 * This class represents miles object traveled by the customer.
 * @author premsubedi
 *
 */
public class Miles {
	private String date;
	private String flight;
	private String origin;
	private String destination;
	
	/**
	 * Miles constructor which initializes it's fields.
	 * @param date flight date
	 * @param flight flight name
	 * @param origin origin airport
	 * @param destination airport
	 */
	public Miles(String date, String flight, String origin, String destination) {
		this.date = date;
		this.flight = flight;
		this.origin = origin;
		this.destination = destination;
	}

	/**
	 * Returns date
	 * @return the date date of flight
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Returns flight name
	 * @return the flight flight name
	 */
	public String getFlight() {
		return flight;
	}

	/**
	 * Returns origin airport
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Returns destination airport.
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	
	
	
	
	
	
	

}

package edu.ncsu.csc316.airline_mileage.data;

/**
 * This class represents a flight object.
 * @author premsubedi
 *
 */
public class Flight {
	private String date;
	private String airline;
	private int flNumber;
	private String origin;
	private String destination;
	private int distance;
	/**
	 * Flight constructor which initializes it's fields.
	 * @param date flight date.
	 * @param airline flight airline.
	 * @param flNumber flight number.
	 * @param origin flight origin.
	 * @param destination flight destination.
	 * @param distance distance traveled by that flight.
	 */
	public Flight(String date, String airline, int flNumber, String origin, String destination, int distance) {
		this.date = date;
		this.airline = airline;
		this.flNumber = flNumber;
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}
	/**
	 * Returns flight date
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Returns airline name
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * Returns flight number
	 * @return the flNumber
	 */
	public int getFlNumber() {
		return flNumber;
	}
	/**
	 * Returns origin airport
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * Returns destination airport
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * Returns distance travelled by the flight
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	
	
}

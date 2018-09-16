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
	 * Returns distance traveled by the flight
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + distance;
		result = prime * result + flNumber;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (distance != other.distance)
			return false;
		if (flNumber != other.flNumber)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}
	
	
	
	
}

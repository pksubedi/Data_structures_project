package edu.ncsu.csc316.hub_manager.flight;

/**
 * This class represents an Airport object.
 * @author premsubedi
 *
 */
public class Airport {
	private String code;
	private double latitude;
	private double longitude;
	private int vertex;
	private int connection;

	/**
	 * Constructs an airport.
	 * @param code airport code.
	 * @param latid latitude of the airport location.
	 * @param longitd longitude of the airport location.
	 * @param integer integer value associated with an airport.
	 */
	public Airport(String code, double latid, double longitd, int integer) {
		this.code = code;
		this.latitude = latid;
		this.longitude = longitd;
		this.vertex = integer;
		this.connection = 0;
	}
	
	/**
	 * Sets connection to given value.
	 */
	public void setConnection() {
		this.connection++;
	}
	/**
	 * Returns connection
	 * @return the connection
	 */
	public int getConnection() {
		return connection;
	}

	/**
	 * Returns an airport code.
	 * @return the code airport code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns latitude 
	 * @return the latitude airports latitude.
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Returns airport's longitude
	 * @return the longitude airpot's longitude.
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Returns integer representation of an airport.
	 * @return vertex integer value associated with an airport.
	 */
	public int getIntegerPosition() {
		return vertex;
	}
	
	/**
	 * Sets the position field of an airport to the given integer value.
	 * @param count given integer value.
	 */
	public void setIntegerPosition(int count) {
		this.vertex = count;
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
		Airport other = (Airport) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	
	/**
	 * Compares between two airports.
	 * @param other airports to be compared
	 * @return integer value
	 */
	public int compareTo(Airport other) {
		if(this.getConnection() > other.getConnection()) return 1;
		else if (this.getConnection() < other.getConnection()) return -1;
		else {
			if(this.getCode().compareTo(other.getCode()) < 0) {
				return -1;
			} else if(this.getCode().compareTo(other.getCode()) > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}

package edu.ncsu.csc316.hub_manager.flight;

/**
 * This class gives the airports associated with that particular
 * flight.
 * @author premsubedi
 *
 */
public class FlightLeg implements Comparable<FlightLeg> {
	private Airport a1;
	private Airport a2;
	private static final double R = 3961.0;
	
	/**
	 * Represents Flight object which connects two airports and gets distance between them.
	 * @param a1 starting airport.
	 * @param a2 ending airport.
	 */
	public FlightLeg(Airport a1, Airport a2) {
		this.a1 = a1;
		this.a2 = a2;
	}
	
	/**
	 * This method takes the data of two different airports and calculates
	 * distance between them using Haversine formula.
	 * 
	 * This is the given code in the project description by Dr. King.
	 * 
	 * @param latitude1 latitude of first airport
	 * @param longitude1 longitude of first airport.
	 * @param latitude2 latitude of second airport.
	 * @param longitude2 longitude of second airport.
	 * @return d distance between two airports.
	 */
	public double getDistance(double latitude1, double longitude1, double latitude2, double longitude2)
	{
		// Convert degrees lat/lon to radians
		double lat1 = Math.toRadians(latitude1);
		double lat2 = Math.toRadians(latitude2);
		double lon1 = Math.toRadians(longitude1);
		double lon2 = Math.toRadians(longitude2);
		
		// Apply Haversine formula
		double dlon = lon2 - lon1; 
		double dlat = lat2 - lat1;
		double a  = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c  = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // great circle distance in radians
		double d = R * c;
		return d;
	}
	
	/**
	 * Returns first airport involved in a flight.
	 * @return airport1 the starting airport of the flight.
	 */
	public Airport getStartAirport() {
		return a1;
	}
	
	/**
	 * Returns second airport involved in a flight.
	 * @return airport2 ending airport of the flight.
	 */
	public Airport getEndAirport() {
		return a2;
	}
	
	
	@Override
	public String toString() {
		String truncatedDist = String.format("%1$.1f", getDistance(a1.getLatitude(), a1.getLongitude(),
				a2.getLatitude(), a2.getLongitude()));
		String s = "   Flight[airport1=" + a1.getCode() + ", airport2=";
		s +=  a2.getCode() + ", distance=" + truncatedDist + "]";
		return s;
	}
	
	/**
	 * Compares the current flight with the other given flight, returns 1 if the current
	 * flight is greater, -1 if it's smaller and 0 if it is equal to the other flight.
	 * @param other another flight given to be compared.
	 * @return integer based on the comparison.
	 */
	@Override
	public int compareTo(FlightLeg other) {
		double d1 = this.getDistance(this.getStartAirport().getLatitude(), this.getStartAirport().getLongitude(), 
				this.getEndAirport().getLatitude(), this.getEndAirport().getLongitude());
		
		double d2 = other.getDistance(other.getStartAirport().getLatitude(), other.getStartAirport().getLongitude(),
				other.getEndAirport().getLatitude(), other.getEndAirport().getLongitude());
		if(d1 > d2) return 1;
		else if(d1 < d2) return -1;
		else {
			if(this.getStartAirport().getCode().compareTo(other.getStartAirport().getCode()) < 0) {
				return -1;
			} else if(this.getStartAirport().getCode().compareTo(other.getStartAirport().getCode()) > 0) {
				return 1;
			} else {
				if(this.getEndAirport().getCode().compareTo(other.getEndAirport().getCode()) < 0) {
					return -1;
				} else if(this.getEndAirport().getCode().compareTo(other.getEndAirport().getCode()) > 0) {
					return 1;
				} else {
					return 0;
				}
			}
			
		}
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
		FlightLeg other = (FlightLeg) obj;
		if (a1 == null) {
			if (other.a1 != null)
				return false;
		} else if (!a1.equals(other.a1))
			return false;
		if (a2 == null) {
			if (other.a2 != null)
				return false;
		} else if (!a2.equals(other.a2))
			return false;
		return true;
	}

	
	
}

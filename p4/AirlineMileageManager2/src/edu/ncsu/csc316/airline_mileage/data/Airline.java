package edu.ncsu.csc316.airline_mileage.data;

/**
 * Airline class which represents an Airline object.
 * @author premsubedi
 *
 */
public class Airline {
	private String desc;
	private String iataCode;
	private String callSign;
	private String country;

	/**
	 * Contructor that initializes the fields of airline object.
	 * @param description airline description
	 * @param iataCode iata code for an airline
	 * @param callSign airline call sign.
	 * @param country airline home country.
	 */
	public Airline(String description, String iataCode, String callSign, String country) {
		this.desc = description;
		this.iataCode = iataCode;
		this.callSign = callSign;
		this.country = country;
	}

	/**
	 * Returns airline description.
	 * @return the desc airline description.
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Returns IATA code of airline.
	 * @return the iataCode airline's iata code.
	 */
	public String getIataCode() {
		return iataCode;
	}

	/**
	 * Returns airline call sign.
	 * @return the callSign airline's callsign.
	 */
	public String getCallSign() {
		return callSign;
	}

	/**
	 * Returns airline country
	 * @return country home country for that airline.
	 */
	public String getCountry() {
		return country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callSign == null) ? 0 : callSign.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((iataCode == null) ? 0 : iataCode.hashCode());
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
		Airline other = (Airline) obj;
		if (callSign == null) {
			if (other.callSign != null)
				return false;
		} else if (!callSign.equals(other.callSign))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (iataCode == null) {
			if (other.iataCode != null)
				return false;
		} else if (!iataCode.equals(other.iataCode))
			return false;
		return true;
	}
	
	


}

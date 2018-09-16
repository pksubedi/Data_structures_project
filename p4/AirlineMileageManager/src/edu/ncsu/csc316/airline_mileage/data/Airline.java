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


}

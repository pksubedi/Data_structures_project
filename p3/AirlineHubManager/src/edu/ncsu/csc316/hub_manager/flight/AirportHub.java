package edu.ncsu.csc316.hub_manager.flight;

/**
 * This class is an specialized version of an airport, 
 * meaning it is an airport serving as a hub as well.
 * @author premsubedi
 *
 */
public class AirportHub {
	private String code;
	private int connections;
	
	/**
	 * AirportHub constructor whcih initializes it's fields.
	 * @param code airport code
	 * @param numOfConnection number of connection that an airport has.
	 */
	public AirportHub(String code, int numOfConnection) {
		this.code = code;
		this.connections = numOfConnection;
	}
	
	/**
	 * Returns airport code.
	 * @return the code airport code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns the number of connections.
	 * @return the connections.
	 */
	public int getConnections() {
		return connections;
	}

	/**
	 * Returns true if an airport has more than or equal to three connnections,
	 * false otherwise.
	 * @return boolean if or not an airport is hub.
	 */
	public boolean isHub() {
		return this.getConnections() >= 3;
	}

}

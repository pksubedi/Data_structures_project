package edu.ncsu.csc316.hub_manager.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.hub_manager.disjoint_set.UpTree;
import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.io.AirportReader;
import edu.ncsu.csc316.hub_manager.list.ArrayAirportList;
import edu.ncsu.csc316.hub_manager.priority_queue.MinHeap;


/**
 * Top level class among all the model classes, which manages all the 
 * airline hub system.
 * @author premsubedi
 *
 */
public class AirlineHubManager {
	ArrayAirportList<Airport> aalist;
	private ArrayAirportList<FlightLeg> mst;
	@SuppressWarnings("unused")
	private double distance;
	private FlightLeg fl;
	private MinHeap mhp;
	private UpTree utree;

	/**
	 * AirlineHubManager constructor which initializes all of it's fields.
	 * @param fileNamePath path to the input file.
	 */
	public AirlineHubManager(String fileNamePath) {
		try {
			aalist = AirportReader.readAirport(fileNamePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mhp = new MinHeap();
		mst = new ArrayAirportList<FlightLeg>();
		utree = new UpTree(aalist.size());
	}

	/**
	 * Returns a string representation of the list of Flights contained in the 
	 * minimum spanning set of flights that connect all airports. The returned string is in
	 * the following format, where the flights are sorted in increasing order
	 * by distance. If multiple flights have the same distance, order by airport code
	 * in ascending alphabetical order.
	 *  - Distance should be displayed to 1 decimal place
	 *  - Each flight line is indented by 3 spaces
	 * 
	 * FlightList[
	 *    Flight[airport1=ORH, airport2=RDU, distance=576.4],
	 *    Flight[airport1=SEA, airport2=SFO, distance=679.6],
	 *    Flight[airport1=MIA, airport2=RDU, distance=702.8],
	 *    Flight[airport1=DFW, airport2=RDU, distance=1059.7],
	 *    Flight[airport1=DFW, airport2=SFO, distance=1462.3]
	 * ]
	 * 
	 * @return a string representation of the minimum spanning set of flights
	 */
	public String getMinimumFlights() {
		for(int i = 0; i < aalist.size(); i++) {
			for(int j = i; j < aalist.size(); j++) {
				if(i != j) {
					fl = new FlightLeg(aalist.get(i), aalist.get(j));
					this.distance = fl.getDistance(aalist.get(i).getLatitude(), aalist.get(i).getLongitude(),
							aalist.get(j).getLatitude(), aalist.get(j).getLongitude());
					mhp.insert(fl);
				}
			}
		}
		mst = findMST();
		String s = "FlightList[\n";
		for(int i = 0; i < mst.size() - 1; i++) {
			s += mst.get(i).toString() + ",\n";
		}
		s += mst.get(mst.size() - 1).toString() + "\n]";
		return s;
	}

	/**
	 * Returns the list of possible airport hubs (airports with at least 
	 * 3 connecting flights in the minimum spanning set of flights).
	 * The list should be output in the following format, where the
	 * airports are listed in descending order by number of connecting flights. 
	 * If multiple airports have the same number of connecting flights, order
	 * the airports alphabetically by airport code.
	 *  - Each airport line is indented by 3 spaces
	 *  
	 * HubReport[
	 *   RDU has 3 connections.
	 * ]
	 * 
	 * @return the string representation of the list of possible airport hubs
	 */
	public String getPossibleHubs() {
	
		ArrayAirportList<Airport> list = new ArrayAirportList<Airport>();
		
		for(int i = 0; i < aalist.size(); i++) {
			if(aalist.get(i).getConnection() >= 3) {
				list.add(aalist.get(i));
			}
		}
		System.out.println(list.size());
		//Use of insertion sort from the Dictionaries.pdf of Dr. King lecture slides.
		for(int i = 0; i < list.size(); i++) {
			Airport a = list.get(i);
			int j = i - 1;
			while(j >= 0 && list.get(j).compareTo(a) > 0) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, list.get(i));
		}
		String s = "HubReport[\n";
		for(int i = 0; i < list.size(); i++) {
			s += "   " + list.get(i).getCode() + " has " + list.get(i).getConnection() + " connections.";
		}
		s += "]\n";
		return s;
	}
	
	/**
	 * Methods for finding Minimum Spanning Tree.
	 * @return mst minimum spanning tree.
	 */
	public ArrayAirportList<FlightLeg> findMST() {
		int components = aalist.size();
		while (true) {
			fl = mhp.deleteMin();
			int x = utree.find(fl.getStartAirport().getIntegerPosition());
			int y = utree.find(fl.getEndAirport().getIntegerPosition());
			if (!utree.isCycle(x, y)) {
				utree.union(x, y);
				mst.add(fl);
				fl.getStartAirport().setConnection();
				fl.getEndAirport().setConnection();
			}
			if(components - 1 == mst.size()) break;
		} 
		return mst;
	}
}

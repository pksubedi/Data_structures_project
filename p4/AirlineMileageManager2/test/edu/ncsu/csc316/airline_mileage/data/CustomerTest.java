package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests Customer class.
 * @author premsubedi
 *
 */
public class CustomerTest {
	
	/**
	 * Tests Customer constructor.
	 */
	@Test
	public void customerStringStringStringStringStringString() {
		HashTable<Flight> list = new HashTable<Flight>(4);
	    Flight fl1 = new Flight("2015/10/24", "UA", 234, "RDU", "JFK", 1198);
	    list.insert(fl1);
	    Flight fl2 = new Flight("2014/10/24", "AA", 234, "CLT", "TPA", 455);
	    list.insert(fl2);
		Customer c1 = new Customer("Prem", "Subedi", list);
		Customer c2 = new Customer("Aita", "Subedi", list );
		Customer c3 = new Customer("John", "Henderson", list);
		Customer c4 = new Customer("Prem", "Subedi", list);
		assertEquals("Prem", c1.getFirstName());
		assertEquals("Subedi", c1.getLastName());
		assertEquals(list, c1.getList());
		assertEquals(2, ((HashTable<Flight>) c1.getList()).getSize());
		
		assertEquals(1, c1.compareTo(c2));
		assertEquals(-1, c2.compareTo(c1));
		assertEquals(1, c1.compareTo(c3));
		assertEquals(-1, c3.compareTo(c1));
		assertEquals(0, c1.compareTo(c4));
		assertEquals(0, c4.compareTo(c1));
		
		
		
	}

}

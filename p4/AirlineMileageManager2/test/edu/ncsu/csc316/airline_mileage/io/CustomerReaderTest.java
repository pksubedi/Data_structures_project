package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.dictionary.HashTable;

/**
 * Tests CustomerReader class.
 * @author PremSubedi
 *
 */
public class CustomerReaderTest {
	private static final String INPUT_FILE = "input/customerFile.txt";
	
	/**
	 * Tests readCustomerFile method.
	 */
	@Test
	public void testReadCustomerFile() {
		try {
			HashTable<Customer> cList = CustomerReader.readCustomerFile(INPUT_FILE);
			HashTable<Flight> list = new HashTable<Flight>(4);
			
		    Flight fl1 = new Flight("12/20/2015", "UA", 346, "ORD", "MIA", 1197);
		    list.insert(fl1);
			Customer c1 = new Customer("Erick", "Mcfarland", list);
			Customer c2 = new Customer("Rita", "Baniya", list);
			cList.insert(c1);
			assertTrue(cList.lookUp(c1));
			assertFalse(cList.lookUp(c2));
			
			assertEquals(2, cList.getSize());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

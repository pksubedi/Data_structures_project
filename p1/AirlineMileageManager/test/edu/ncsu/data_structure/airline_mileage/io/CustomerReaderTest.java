package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.list.ArrayBasedList;

/**
 * Tests CustomerReader class.
 * @author premsubedi
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
			ArrayBasedList<Customer> cList = CustomerReader.readCustomerFile(INPUT_FILE);
			assertEquals(10, cList.size());
			assertEquals("Erick", cList.get(0).getFirstName());
			assertEquals("Stiltner", cList.get(4).getLastName());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

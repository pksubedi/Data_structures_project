package edu.ncsu.csc316.airline_mileage.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests HashTable class.
 * @author premsubedi
 *
 */
public class HashTableTest {
	
	/**
	 * Tests HashTable
	 */
	@Test
	public void testHashTable() {
		HashTable<String> table = new HashTable<String>(5);

		table.insert("Java>C");

		assertTrue(table.lookUp("Java>C"));
		assertFalse(table.lookUp("Hahaha"));
		assertEquals(1, table.getSize());
	}

}

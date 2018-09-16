package edu.ncsu.csc316.airline_mileage.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.dictionary.ArrayBasedList;

/**
 * Tests ArrayBasedList
 * @author premsubedi
 *
 */
public class ArrayBasedListTest {
	
	/**
	 * Tests ArrayBasedList constructor.
	 */
	@Test
	public void testArrayBasedList() {
		ArrayBasedList<String> l = new ArrayBasedList<String>();
		assertEquals(0, l.size());

		l.add(0, "prem");
		l.add(1, "kumar");
		l.add(1, "subedi");
		assertEquals(3, l.size());

		try {
			l.add(0, null);
			//fail();
		} catch (NullPointerException e) {
			assertEquals(3, l.size());
		}

		try {
			l.add(9, "lion");
			//fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(3, l.size());
		}

		try {
			l.add(-1, "lion");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(5, l.size());
		}

		try {
			l.add(0, "prem");
		} catch (IllegalArgumentException e) {
			assertEquals(3, l.size());
		}

		l.add(0, "lion");
		l.add(1, "dipty");
		assertEquals(8, l.size());

		l.add(0, "apple");
		l.add(0, "pear");
		l.add(0, "banana");
		l.add(0, "peach");
		l.add(0, "coconut");
		l.add(0, "strawberry");

		assertEquals("strawberry", l.remove(0));
		assertEquals(13, l.size());

		try {
			l.remove(12);
		} catch (IndexOutOfBoundsException e) {
			assertEquals(10, l.size());
		}

		try {
			l.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(12, l.size());
		}

		assertEquals("coconut", l.get(0));
		assertEquals(12, l.size());

		try {
			l.get(12);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(12, l.size());
		}

		try {
			l.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(12, l.size());
		}

		l.set(0, "pabitra");
		assertEquals(12, l.size());

	}


}

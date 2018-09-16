package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests Timestamp class.
 * @author premsubedi
 *
 */
public class TimestampTest {
	Timestamp t1 = new Timestamp("12", "15", 2005, "04", "15", "45");
	Timestamp t2 = new Timestamp("11", "17", 2015, "14", "15", "45");
	Timestamp t3 = new Timestamp("10", "10", 2005, "14", "15", "45");
	Timestamp t4 = new Timestamp("10", "08", 2005, "14", "15", "45");
	Timestamp t5 = new Timestamp("10", "10", 2005, "10", "15", "45");
	Timestamp t6 = new Timestamp("10", "10", 2005, "18", "15", "45");
	Timestamp t7 = new Timestamp("10", "10", 2005, "18", "12", "45");
	Timestamp t8 = new Timestamp("10", "10", 2005, "18", "12", "15");
	
	/**
	 * Tests toString method.
	 */
	@Test
	public void testToString() {
		assertEquals("12/15/2005 04:15:45", t1.toString());
		assertEquals("11/17/2015 14:15:45", t2.toString());
	}
	
	/**
	 * Tests compareTo method.
	 */
	@Test
	public void testCompareTo() {
		assertEquals(-1, t1.compareTo(t2));
		assertEquals(1, t2.compareTo(t1));
		assertEquals(1, t1.compareTo(t3));
		assertEquals(-1, t3.compareTo(t1));
		assertEquals(1, t3.compareTo(t4));
		assertEquals(-1, t4.compareTo(t3));
		assertEquals(1, t6.compareTo(t5));
		assertEquals(-1, t5.compareTo(t6));
		assertEquals(1, t6.compareTo(t5));
		assertEquals(-1, t5.compareTo(t6));
		assertEquals(1, t6.compareTo(t7));
		assertEquals(-1, t7.compareTo(t6));
		assertEquals(1, t7.compareTo(t8));
		assertEquals(-1, t8.compareTo(t7));
	}

}

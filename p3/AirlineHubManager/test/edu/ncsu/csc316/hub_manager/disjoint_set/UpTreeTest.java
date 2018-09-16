package edu.ncsu.csc316.hub_manager.disjoint_set;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests UpTree class.
 * @author premsubedi
 *
 */
public class UpTreeTest {
	
	/**
	 * Tests all the Uptree methods.
	 */
	@Test
	public void testUpTree() {
		UpTree utree = new UpTree(10);
		utree.union(1, 2);
		utree.union(3, 4);
		utree.union(2, 3);
		assertEquals(1, utree.find(1));
		assertEquals(1, utree.find(2));
		utree.union(2, 4);
		assertTrue(utree.isCycle(2, 4));
		assertTrue(utree.isCycle(1, 3));
		utree.union(6, 8);
		assertFalse(utree.isCycle(6, 3));
		
	}

}

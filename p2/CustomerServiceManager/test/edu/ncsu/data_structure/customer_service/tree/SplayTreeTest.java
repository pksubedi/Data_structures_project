package edu.ncsu.csc316.customer_service.tree;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.customer_service.data.Customer;
import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.data.HelpTicketComparator;
import edu.ncsu.csc316.customer_service.data.Timestamp;


/**
 * Tests SplayTree
 * @author premsubedi
 *
 */
public class SplayTreeTest {
	private SplayTree<HelpTicket> tree = new SplayTree<HelpTicket>();
	Comparator<HelpTicket> c = new HelpTicketComparator();
	static Customer c1 = new Customer("Abey", "Bance");
	static Customer c2 = new Customer("Santa", "Kirat");
	static Customer c3 = new Customer("Edward", "Bance");
	static Timestamp t1 = new Timestamp("9", "13", 2017, "10", "14", "15");
	static Timestamp t2 = new Timestamp("03", "15", 2017, "02", "04", "15");
	
	/** Ticket 1 object */
	public static final HelpTicket TICKET_1 = new HelpTicket(t1, 9, c1, "How much miles I earned?");
	
	/** Ticket 2 object */
	public static final HelpTicket TICKET_2 = new HelpTicket(t2, 5, c2, "I want to change my flight.");
	
	/** Ticket 3 object */
	public static final HelpTicket TICKET_3 = new HelpTicket(t2, 8, c3, "I want to change my flight.");


	/**
	 * Sets up the environment for testing.
	 * @throws Exception throws exception if we can't create tree.
	 */
	@Before
	public void setUp() throws Exception {
		tree = new SplayTree<HelpTicket>();
		tree.add(TICKET_1, c);
		tree.add(TICKET_2, c);
		tree.add(TICKET_3, c);
	}
	
	/**
	 * Tests add methods of splay tree.
	 */
	@Test
	public void testAdd() {
		assertEquals(3, tree.getSize());
		tree.add(TICKET_1, c);
		assertEquals(4, tree.getSize());
		tree.add(TICKET_2, c);
		assertEquals(5, tree.getSize());
		tree.add(TICKET_3, c);
		assertEquals(6, tree.getSize());
		assertFalse(tree.isEmpty());
	}
	
	/**
	 * Tests lookUp method of splay tree.
	 */
	@Test
	public void testLookUp() {
		assertEquals(TICKET_1, tree.lookUp(TICKET_1, c));
	}
	
	/**
	 * Tests remove method of splay tree.
	 */
	@Test
	public void testRemove() {
		assertEquals(3, tree.getSize());
		tree.remove(TICKET_1, c);
		assertEquals(2, tree.getSize());
		assertEquals(TICKET_1.toString() + "\n" + TICKET_3.toString() + "\n" + TICKET_2.toString() + "\n", tree.inOrder());
		tree.remove(TICKET_2, c);
		assertEquals(1, tree.getSize());
		//assertEquals(TICKET_3.toString(), tree.inOrder());
		tree.remove(TICKET_3, c);
		assertEquals(0, tree.getSize());
		//assertEquals("", tree.inOrder());
		
		
	}
	
	/**
	 * Tests getNumberOfSuccessors() method.
	 */
    @Test
    public void testGetNumberOfSuccessors() {
    	assertEquals(1, tree.getNumberOfSuccessors());
    	tree.add(TICKET_1, c);
    	assertEquals(1, tree.getNumberOfSuccessors());
    }
    
    /**
     * Tests splay method.
     */
    @Test
    public void testSplay() {
    	
    	tree.splay(tree.getNode());
    	assertNotNull(tree.getNode().getLeftNode());
    	assertNull(tree.getNode().getParentNode());
    	assertNull(tree.getNode().getRightNode());
    	assertTrue(tree.getNode().isRoot());
    	assertTrue(tree.getNode().hasLeftNode());
    	assertFalse(tree.getNode().hasRightNode());
    	
    }
	
	
}

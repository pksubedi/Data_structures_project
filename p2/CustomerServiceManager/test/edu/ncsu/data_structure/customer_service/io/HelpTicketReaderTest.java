package edu.ncsu.csc316.customer_service.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.customer_service.data.HelpTicket;
import edu.ncsu.csc316.customer_service.tree.SplayTree;

/**
 * Tests HelpTicketReader class.
 * @author premsubedi
 *
 */
public class HelpTicketReaderTest {
	/** Constant for file path */
	public static final String FILE_PATH = "input/input.txt";
	SplayTree<HelpTicket> queue;
	
	/**
	 * Tests readerByPriority() method.
	 */
	@Test
	public void testReaderByPriority() {
		try {
			queue = HelpTicketReader.readHelpTicketByPriority(FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		assertEquals(3, queue.getSize());
	}
	
	/**
	 * Tests readerByName() method.
	 */
	@Test
	public void testReaderByName() {
		try {
			queue = HelpTicketReader.readHelpTicketByName(FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		assertEquals(3, queue.getSize());
	}
	
	
	

}

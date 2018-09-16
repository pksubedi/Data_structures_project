package edu.ncsu.data_structure.customer_service.data;

import java.util.Comparator;

/**
 * This class represents single HelpTicket object.
 * @author premsubedi
 *
 */
public class HelpTicket implements Comparator<HelpTicket>  {
	private Timestamp submitTime;
	private Customer customer;
	private int priority;
	private String question;


	/**
	 * HelpTicket constructor which initializes it's fields.
	 * @param time time which is the combination of date and time.
	 * @param priority priority of the help ticket.
	 * @param c customer object
	 * @param question customer's question.
	 */
	public HelpTicket(Timestamp time, int priority, Customer c, String question) {
		this.customer = c;
		this.submitTime = time;
		this.priority = priority;
		this.question = question;
	}

	/**
	 * Returns submit time.
	 * @return submitTime submit time.
	 */
	public Timestamp getSubmitTime() {
		return submitTime;
	}

	/**
	 * Returns customer.
	 * @return customer customer holding the help ticket.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns priority.
	 * @return priority of the help ticket.
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Returns customer's question.
	 * @return question question from the helpticket.
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Compares two helpticket, by priority and time. If they are same
	 * then by last name and first name of the customer holding the help ticket.
	 * @param ticket help ticket.
	 * @return positive zero or negative if current ticket is greater than, 
	 * equal to or less than the given help ticket.
	 */
	public int compareTo(HelpTicket ticket) {
		if((this.getPriority() - ticket.getPriority()) < 0) {
			return -1;
		} else if((this.getPriority() - ticket.getPriority()) > 0) {
			return 1;
		} else {
			if(this.getSubmitTime().compareTo(ticket.getSubmitTime()) < 0) {
				return -1;
			} else if(this.getSubmitTime().compareTo(ticket.getSubmitTime()) > 0) {
				return 1;
			} else {
				if(this.getCustomer().getLastName().compareTo(ticket.getCustomer().getLastName()) < 0) {
					return -1;
				} else if (this.getCustomer().getLastName().compareTo(ticket.getCustomer().getLastName()) > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	}

	
	@Override
	public int compare(HelpTicket o1, HelpTicket o2) {
		return 0;
	}
	
	/**
	 * Returns String representation of help ticket.
	 * @return string string representation of help ticket.
	 */
	public String toString() {
		return "Priority " + priority + ": submitted at " + submitTime.toString() +
				 " by " + customer.toString() + ", Question: " + question;
	}
	
}

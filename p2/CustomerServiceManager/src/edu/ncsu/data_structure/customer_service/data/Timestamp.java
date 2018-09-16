package edu.ncsu.data_structure.customer_service.data;

/**
 * This class stores date and time and the combination forms the 
 * point of time.
 * @author premsubedi
 *
 */
public class Timestamp {
	private int year;
	private String month;
	private String day;
	private String hour;
	private String min;
	private String second;
	
	/**
	 * Constructors which initializes it's fields.
	 * @param month month of submission of help request.
	 * @param day day of submission of help request.
	 * @param year year of submission of help request.
	 * @param hour hour of submission of help request.
	 * @param min minute of submission of help request.
	 * @param second second of submission of help request.
	 */
	public Timestamp(String month, String day, int year, String hour, String min, String second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.second = second;
	}

	/**
	 * Returns year
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Returns month
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * Returns day
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Returns hour
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * Returns min.
	 * @return the min
	 */
	public String getMin() {
		return min;
	}

	/**
	 * Returns second of timestamp.
	 * @return the second
	 */
	public String getSecond() {
		return second;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return month + "/" + day + "/" + year + " " + hour + ":" + min + ":" + second;
		
	}
	/**
	 * Compares two timestamp by year, month, day, hour, minute, and second.
	 * I got this idea from Dr. King in his office hours on 10/09/2017. We disscussed 
	 * about timestamp comparison.
	 * @param s given timestmap object.
	 * @return integer value of -1, 0 and 1 for a timestamp smaller, equal to and bigger 
	 * than the other timestamp.
	 */
	public int compareTo(Timestamp s) {
		if((this.getYear() - s.getYear()) < 0) {
			return -1;
		} else if((this.getYear() - s.getYear()) > 0) {
			return 1;
		} else {
			if ((this.getMonth().compareTo(s.getMonth())) < 0) {
				return -1;
			} else if ((this.getMonth().compareTo(s.getMonth())) > 0) {
				return 1;
			} else {
				if ((this.getDay().compareTo(s.getDay())) < 0) {
					return -1;
				} else if ((this.getDay().compareTo(s.getDay())) > 0) {
					return 1;
				} else {
					if ((this.getHour().compareTo(s.getHour())) < 0) {
						return -1;
					} else if ((this.getHour().compareTo(s.getHour())) > 0) {
						return 1;
					} else {
						if ((this.getMin().compareTo(s.getMin())) < 0) {
							return -1;
						} else if ((this.getMin().compareTo(s.getMin())) > 0) {
							return 1;
						} else {
							if ((this.getSecond().compareTo(s.getSecond())) < 0) {
								return -1;
							} else if ((this.getSecond().compareTo(s.getSecond())) > 0) {
								return 1;
							} else {
								return 0;
							}
						}
					}
				}
			}
 		}
	}
}

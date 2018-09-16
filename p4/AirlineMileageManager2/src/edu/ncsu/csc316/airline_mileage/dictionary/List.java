package edu.ncsu.csc316.airline_mileage.dictionary;

/**
 * Interface which holds all the methods.
 * @author premsubedi
 *
 * @param <E> generic parameter
 */
public interface List<E> {
	
	/**
	 * Adds element to the particular index.
	 * @param idx index to add element on.
	 * @param value value to be added.
	 */
	void add(int idx, E value);
	
	/**
	 * Removes and returns the value from the index.
	 * @param idx index from where the value to be removed.
	 * @return E generic value
	 */
	E remove(int idx);
	
	/**
	 * Returns the value from the particular index.
	 * @param idx index from where the value is returned.
	 * @return E generic value to be returned.
	 */
	E get(int idx);
	
	/**
	 * Sets or replaces the given value in that index.
	 * @param idx index where the value to be replaced.
	 * @param value value to be replaced.
	 */
	void set(int idx, E value);
	
	/**
	 * Adds value to the end of the list.
	 * @param value value to be added.
	 */
	void add(E value);
}

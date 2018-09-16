package edu.ncsu.csc316.hub_manager.list;

/**
 * Interface or abstract data type implemented by the list.
 * @author premsubedi
 *
 * @param <E> generic parameter.
 */
public interface List<E> {
	/**
	 * Appends at the end of the list.
	 * @param value value to be added.
	 */
	void add(E value);
	
	/**
	 * Adds the element at the given index.
	 * @param idx index of the list.
	 * @param value value to be added.
	 */
	void add(int idx, E value);
	
	/**
	 * Removes the value from the given index.
	 * @param idx index from where the value to be removed.
	 */
	void remove(int idx);
	
	/**
	 * Search and returns the value at that index.
	 * @param idx index of the arrayBased list from where the value 
	 * to be returned.
	 * @return idx index of an array list.
	 */
	E get(int idx);

}

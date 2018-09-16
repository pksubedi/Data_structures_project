package edu.ncsu.csc316.airline_mileage.dictionary;

/**
 * Dictionary interface that is implemented by Hash table in the project.
 * @author premsubedi
 *
 * @param <E> generic parameter
 */
public interface Dictionary<E> {

	/**
	 * This method search the key from the dictionary.
	 * @param e item to search.
	 * @return e a searched item
	 */
	E lookUp(E e);
	
	/**
	 * It inserts an element e into the dictionary.
	 * @param e item to be inserted.
	 */
	void insert(E e);
	
	/**
	 * This method deletes an item from the dictionary.
	 * @param e item to be deleted.
	 */
	void delete(E e);
}

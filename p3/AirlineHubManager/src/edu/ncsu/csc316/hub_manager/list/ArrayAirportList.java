package edu.ncsu.csc316.hub_manager.list;

import java.util.Arrays;

/**
 * Represents the list of objects.
 * @author premsubedi
 *
 * @param <E> generic parameter.
 */
public class ArrayAirportList<E> implements List<E> {
	
	private static final int DEFAULT_SIZE = 5;
	private E[] list;
	private int size;
	
	/**
	 * Constructs the list.
	 * @param capacity capacity of the list.
	 */
	@SuppressWarnings("unchecked")
	public ArrayAirportList(int capacity) {
		list = (E[]) new Object[capacity];
		size = 0;
	}
	
	/**
	 * Default constructor for ArrayAirportList.
	 */
	public ArrayAirportList() {
		this(DEFAULT_SIZE);
	}

	@Override
	public void add(int idx, E e) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		checkCapacity(size + 1);
		for (int i = size - 1; i >= idx; i--) {
			list[i + 1] = list[i];
		}
		list[idx] = e;
		size++;
	}

	@Override
	public void remove(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		
	}

	@Override
	public void add(E e) {
		checkCapacity(size + 1);
		list[size] = e;
		size++;
		
	}

	@Override
	public E get(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		return list[idx];
	}
	
	/**
	 * Returns the temporary variable.
	 * @param idx given index.
	 * @param e given value.
	 * @return temp variable.
	 */
	public E set(int idx, E e) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(e == null) {
			throw new NullPointerException();
		}
		E temp = list[idx];
		list[idx] = e;
		return temp;
	}
	
	private void checkCapacity(int length) {
		if (length > list.length) {
			int newCapacity = list.length * 2 + 1;
			if (length > newCapacity) {
				newCapacity = length;
				
			}
			list = Arrays.copyOf(list,  newCapacity);
		}
	}
	
	/**
	 * Returns index of the first occurence of the given value, 
	 * returns -1 if not found.
	 * @param e given value whose index need to be determined
	 * @return integer index
	 */
	public int indexOf(E e) {
		for(int i = 0; i < size; i++) {
			if(e.equals(list[i])) {
				return i;
			} 
		}
		return -1;
	}
	
	/**
	 * Returns size of the list.
	 * @return size the current size of the list.
	 */
	public int size() {
		return size;
	}

}

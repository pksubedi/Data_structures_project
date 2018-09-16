package edu.ncsu.csc316.airline_mileage.dictionary;

import java.util.Arrays;

/**
 * Array based list class which automatically resizes as we add or remove 
 * the elements from it.
 * @author premsubedi
 *
 * @param <E> generic parameter.
 */
public class ArrayBasedList<E> implements List<E> {

	private E[] list;
	private int size;
	
	/**
	 * ArrayBasedList constructor which initializes fields.
	 * @param capacity initial capacity of the list.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		list = (E[]) (new Object[capacity]);
		size = 0;
	}
	
	@Override
	public void add(int index, E element) {
		ensureCapacity(size + 1);
		for (int i = size - 1; i >= index; i--) {
			list[i + 1] = list[i];
		}
		list[index] = element;
		size++;
		
	}

	private void ensureCapacity(int capacity) {
		if (capacity > list.length) {
			int newCapacity = list.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
				
			}
			list = Arrays.copyOf(list,  newCapacity);
		}
		
	}

	@Override
	public E remove(int index) {
		E rtn = list[index];
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return rtn;
		
	}

	@Override
	public E get(int idx) {
		if (idx < 0 || idx > list.length - 1) {
			throw new IndexOutOfBoundsException("" + idx);
		}
		return list[idx];
		
	}

	@Override
	public void add(E element) {
		ensureCapacity(size + 1);
		list[size] = element;
		size++;
		
	}
	
	@Override
	public void set(int idx, E e) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("" + idx);
		}
		list[idx] = e;
		
	}

	/**
	 * Returns size of an array.
	 * @return size size of an array.
	 */
	public int size() {
		return size;
	}

	    
}

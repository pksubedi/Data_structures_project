package edu.ncsu.csc316.hub_manager.priority_queue;

import java.util.Arrays;

import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Array based implementation of Min Heap data structure.
 * I have used the algorithm from Dr. King's Lecture slides named Priority_Queues.pdf
 * to implement the operations of min heap. 
 * @author premsubedi
 *
 */
public class MinHeap {
	/**Array to store the FlightLeg, which is used for min heap later.*/
	private FlightLeg heap[];
	/**Size of the min heap*/
	private int size;
	private static final int DEFAULT_SIZE = 15;


	/**
	 * Constructor for min heap.
	 */
	public MinHeap() {
		heap = new FlightLeg[DEFAULT_SIZE];
		size = 0;


	}

	/**
	 * Inserts element to the min heap.
	 * This code uses an idea from Dr.King's lecture slides PriorityQueues.pdf slide number 52/109.
	 * @param fl FlightLeg to be inserted to min heap.
	 */
	public void insert(FlightLeg fl) {
		checkCapacity(size + 1);
		heap[size] = fl;
		size++;
		upHeap(size - 1);


	}

	/**
	 * This sorts the elements in min heap, while inserting the element.
	 * If an element inserted has the value less than it's parent value, it swaps 
	 * until the heap property maintained.
	 * @param array array with n elements from which the element to be added to 
	 * the heap.
	 * @param i index of an array.
	 */
	private void upHeap(int i) {
		FlightLeg f1 =  heap[(i - 1) / 2];
		FlightLeg f2 =  heap[i];
		if(i > 0 && f1.compareTo(f2) > 0) {
			swap((i - 1) / 2, i);
			upHeap((i - 1) / 2);
		}
	}

	/**
	 * Deletes the element with minimum key, which basically done from the root 
	 * of the tree.
	 * @return FlightLeg object.
	 */
	public FlightLeg deleteMin() {
		FlightLeg fl = heap[0];
		size--;
		swap(0, size);
		downHeap(0);
		return fl;
	}

	/**
	 * This swaps the element, if it's key is greater than it's child.
	 * This code uses an idea from Dr.King's lecture slides PriorityQueues.pdf slide number 55/109.
	 * @param fl
	 * @param m
	 */
	private void downHeap(int m) {
		int i = 0;
		if(( 2 * m + 2) < size) {
			if(heap[2 * m + 2].compareTo(heap[2 * m + 1]) <= 0) {
				i = 2 * m + 2;
			} else {
				i = 2 * m + 1;
			}
		} else if ((2 * m + 1) < size) {
			i = 2 * m + 1;
		}
		if(i > 0 && heap[m].compareTo(heap[i]) > 0) {
			swap(m, i);
			downHeap(i);
		}

	}

	/**
	 * This methods swaps the elements between two indices of an array.
	 * I used the idea of this implementation from the our csc316 book page No.377
	 * Code fragment 9.8
	 * @param i first index of an array.
	 * @param j second indes of an array.
	 */
	private void swap(int i, int j) {
		FlightLeg temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	/**
	 * Returns size of the heap.
	 * @return size current size of the heap.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Checks if the given length of the min heap exceeds the current size of the min heap.
	 * @param length given length to check with the size of the heap.
	 */
	private void checkCapacity(int length) {
		if (length > heap.length) {
			int newCapacity = heap.length * 2 + 1;
			if (length > newCapacity) {
				newCapacity = length;

			}
			heap = Arrays.copyOf(heap,  newCapacity);
		}
	}




}

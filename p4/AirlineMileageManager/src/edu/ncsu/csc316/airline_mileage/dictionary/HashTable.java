/**
 * Package for this class.
 */
package edu.ncsu.csc316.airline_mileage.dictionary;

/**
 * HashTable data structure
 * @author premsubedi
 * @param <E> generic parameter
 *
 */
public class HashTable<E> implements Dictionary<E> {
	//private static final double GOLDEN_RATIO = 0.61803399;

	private int size;
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private Bucket[] hTable;
	
	@SuppressWarnings("unused")
	private int numOfProbe;
	
	@SuppressWarnings("unused")
	private int numOfLookUp;
	
	/**
	 * HashTable constructor.
	 * @param n number of entry in the hash table.
	 */
	public HashTable(int n) {
		size = (int) (n / 0.5);
		hTable = new Bucket[size];
		numOfProbe = 0;
		numOfLookUp = 0;
		
	}

	@Override
	public E lookUp(E e) {
		
		return null;
	}

	@Override
	public void insert(E e) {
		
		size++;
	}

	@Override
	public void delete(E e) {
		// TODO Auto-generated method stub
		size--;
	}
	
	/**
	 * This method compresses the hash code to fit in the hash table
	 * 
	 * @param hashCode hashCode generated by hashing function
	 * @return compressedValue a value that is compressed to be returned.
	 */
//	private int compress(long hashCode) {
//		int compressedValue = (int) Math.floor(size * ((hashCode * GOLDEN_RATIO) - Math.floor(hashCode * GOLDEN_RATIO)));
//		return compressedValue;
//	}
	
	/**
	 * Inner class which represents each bucket of list representing each 
	 * index of the HashTable.
	 * @author premsubedi
	 * @param <E> generic parameter
	 */
	@SuppressWarnings("hiding")
	private class Bucket<E> {
		private E entry;
		private Bucket<E> next;
		
		@SuppressWarnings({ "unused"})
		public Bucket(E e, Bucket<E> next) {
			this.setEntry(e);
			this.setNext(next);
		}

		@SuppressWarnings("unused")
		public Bucket<E> getNext() {
			return next;
		}

		public void setNext(Bucket<E> next) {
			this.next = next;
		}

		@SuppressWarnings("unused")
		public E getEntry() {
			return entry;
		}

		public void setEntry(E entry) {
			this.entry = entry;
		}
	}

}
package edu.ncsu.csc316.hub_manager.disjoint_set;

/**
 * This class represents UpTree data structure.
 * @author premsubedi
 *
 */
public class UpTree {
	private int[] upTree;
	private int size;
	private int[] count;
	
	/**
	 * UpTree constructor
	 * @param num number of elements in the set.
	 */
	public UpTree(int num) {
		size = num;
		upTree = new int[size];
		this.count = new int[size];
		for(int iterator = 0; iterator < num; iterator++) {
			upTree[iterator] = iterator;
			count[iterator] = 1;
		}
		
	}
	
	/**
	 * I used the idea from the Dr. King's lecture slides Disjoint_sets.pdf
	 * Returns the set containing the given value.
	 * @param x integer value in the set.
	 * @return parent of the integer.
	 */
	public int find(int x) {
		if(upTree[x] == x) {
			return x;
		} else {
			return find(upTree[x]);
		}
	}
	
	/**
	 * This method makes the root of the tree representing the smallest set 
	 * point to the root of the tree representing the largestset.
	 * I used the idea from the Dr. King's lecture slides of Disjoint_Sets.pdf.
	 * @param x first set element.
	 * @param y second set element.
	 */
	public void union(int x, int y) {
		int rootContainingX = find(x);
		int rootContainingY = find(y);
		if(rootContainingX == rootContainingY) {
			return;
		}
		
		if(count[rootContainingY] >= count[rootContainingX]) {
			count[rootContainingX] += count[rootContainingY];
			upTree[rootContainingY] = rootContainingX;
		} else {
			count[rootContainingY] += count[rootContainingX];
			upTree[rootContainingX] = rootContainingY;
		}
	}
	
	/**
	 * Returns true if the adding the vertex to the set creates 
	 * a cycle, false othersise.
	 * @param i first element
	 * @param j second element.
	 * @return boolean if or not is a cycle.
	 */
	public boolean isCycle(int i, int j) {
		if(this.find(i) == this.find(j)) {
			return true;
		}
		return false;
	}
	
	
	
	

}

package edu.ncsu.data_structure.customer_service.tree;

import java.util.Comparator;

/**
 * This is the SplayTree data structure.
 * @author premsubedi
 *
 * @param <E> generic parameter
 */
public class SplayTree<E extends Comparator<E>> {

	private TreeNode overallRoot;
	private int size;

	/**
	 * Splay tree constructor.
	 */
	public SplayTree() {
		E e = null;
		overallRoot = new TreeNode(e);
		size = 0;
	}


	/**
	 * This methods adds an element 
	 * @param e object to be added.
	 * @param c Comparator object which compares by priority and time.
	 */
	public void add(E e, Comparator<E> c) {
		overallRoot = add(e, overallRoot, c);
		size++;
		splay(overallRoot);
	}
	/**
	 * This private helper method adds an element into the splay tree.
	 * @param e element to be added.
	 */
	private TreeNode add(E e, TreeNode node, Comparator<E> c) {
		if (node == null || node.data == null) {
			node = new TreeNode(e);
		} else if (c.compare(e, node.data) < 0) {
			node.left = add(e, node.left, c);
		} else if (c.compare(e, node.data) > 0) {
			node.right = add(e, node.right, c);
		}
		return node;

	}

	/**
	 * Returns true if the tree is empty, false otherwise.
	 * @return boolean (true or false) 
	 */
	public boolean isEmpty() {
		return overallRoot == null;
	}

	/**
	 * Finds, splays and removes the element from the tree.
	 * @param e key to remove
	 * @param c Comparator that compares HelpTickets.
	 */
	public void remove(E e, Comparator<E> c) {
		if (overallRoot == null) {
			throw new NullPointerException();
		} else {
			overallRoot = remove(e, overallRoot, c);
			if(overallRoot != null && overallRoot.parent != null) {
				if (overallRoot.data != lookUp(e, c)) {
					splay(overallRoot.parent);
				} else {
					splay(overallRoot);
				}
				TreeNode node1 = overallRoot.left;
				TreeNode node2 = overallRoot.right;
				overallRoot.parent = null;
				overallRoot = null;

				TreeNode newRoot = node1;
				while (node1.right != null) {
					newRoot = new TreeNode(this.getMax());

				}
				splay(newRoot);
				newRoot.right = node2;
			}
		}
		size--;

	}

	/**
	 * Returns the maximum value among all the nodes.
	 * @return maximum value.
	 */
	private E getMax() {
		if(overallRoot == null) {
			return null;
		}
		return getMax(overallRoot);
	}

	/**
	 * Private helper method that return max value
	 * @param currentNode current working node.
	 * @return maximum data.
	 */
	private E getMax(TreeNode currentNode) {
		if(currentNode == null){
			return null;
		} else if (currentNode.hasRightNode()){
			return getMax(currentNode.getRightNode());
		} else {
			return currentNode.data;
		}
	}

	/**
	 * Private helper method that removes the node from the tree.
	 * @param e value of the node
	 * @param root root of the tree.
	 * @param c Comparator that compares to help tickets.
	 * @return node that to be removed.
	 */
	private TreeNode remove(E e, TreeNode root, Comparator<E> c) {
		if(root != null) {
			if(c.compare(e, root.data) < 0){
				return remove(e, root.left, c);
			} else if(c.compare(e, root.data) > 0) {
				return remove(e, root.right, c);
			} else {
				return root;
			}
		}
		return null;
	}

	/**
	 * Returns size of the tree.
	 * @return size size of the tree.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns node that we are looking for.
	 * @param e key to lookup.
	 * @param c comparator object
	 * @return node associated with the key.
	 */
	public E lookUp(E e, Comparator<E> c) {
		if(overallRoot == null) {
			return null;
		}
		overallRoot.data = lookUp(e, overallRoot, c);
		splay(overallRoot);
		return overallRoot.data;
	}

	/**
	 * Private helper method that looks up the key.
	 * @param e element
	 * @param current current node
	 * @param c comparator object
	 * @return node data.
	 */
	private E lookUp(E e, TreeNode current, Comparator<E> c) {
		while (current != null && current.data != null) {
			if (c.compare(e, current.data) < 0) {
				current = current.left;
			} else if (c.compare(e,  current.data) > 0) {
				current = current.right;
			} else {
				return current.data;
			}
		}
		return null;
	}

	/**
	 * Returns StringBuffer or String representation of all the roots.
	 * @return StringBuffer of all the nodes.
	 */
	public String inOrder() {
		return inOrder(overallRoot);
	}

	/**
	 * Private helper method used for public inOrder method.
	 * @param currentNode current node where the ordering is currently taking place.
	 * @return String containing info of the elements of all the nodes.
	 */
	private String inOrder(TreeNode currentNode) {
		String s = "";
		if (currentNode != null) {
			s += inOrder(currentNode.right);
			s +=  currentNode.data + "\n";
			s += inOrder(currentNode.left);
		}
		return s;
	}
	
	/**
	 * Returns node of the tree.
	 * @return overallRoot root of the tree.
	 */
	public TreeNode getNode() {
		return overallRoot;
	}

	/**
	 * This methods splays the given node to the top root level.
	 * I used the idea of the implementation of code from our CSC316 book,
	 * Chapter 11 Page No. 494 (Code Fragment 11.13)
	 * @param node node to be splayed.
	 */
	public void splay(TreeNode node) {
		while (!node.isRoot()) {
			TreeNode parent = node.getParentNode();
			TreeNode grand = parent.getParentNode();
			if (grand == null) {
				if (node == parent.getLeftNode()) {  // Zig case
					rotateRight(node, parent);
				} else {      // Zag case 
					rotateLeft(node, parent); 
				}         
			} else {
				if (node == parent.getLeftNode() && parent == grand.getLeftNode()) {    // Zig-Zig case
					rotateRight(parent, grand);
					rotateRight(node, parent);
				} else if (node == parent.getLeftNode() && parent == grand.getRightNode()) {  // Zig-Zag case
					rotateRight(node, node.getParentNode());
					rotateLeft(node, node.getParentNode());        
				} else if (node == parent.getRightNode() && parent == grand.getLeftNode()) { // Zag-Zig case
					rotateLeft(node, node.getParentNode());
					rotateRight(node, node.getParentNode());
				} else {                                      // Zag-Zag case
					rotateLeft(parent, grand);     
					rotateLeft(node, parent);
				}
			}
		}

		overallRoot = node;
	}


	/**
	 * This method rotates element from the left child node to the parent node,
	 * which basically means rotate right. 
	 * I used the idea of visually rotating node from the Dr. King's lecture slides, then 
	 * implemented into the code.
	 * @param child node on child position.
	 * @param parent node on parent position.
	 */
	private void rotateRight(TreeNode child, TreeNode parent) {
		child.parent = parent.getParentNode();
		parent.parent = child;
		parent.left = child.getRightNode();
		child.right = parent;

	}

	/**
	 * This method rotates right child to the parent position and the parent 
	 * to the left child position, so it is called rotate left.
	 * I used the idea of visually rotating node from the Dr. King's lecture slides, then 
	 * implemented into the code.
	 * @param child beginning child node.
	 * @param parent beginning parent node.
	 */
	private void rotateLeft(TreeNode child, TreeNode parent) { 
		child.parent = parent.getParentNode();
		parent.parent = child;
		parent.right = child.getLeftNode();
		child.left = parent;

	}

	/**
	 * Calculates the number of successors or in special case here the number 
	 * of customer ahead of the current customer.
	 * @return integer value of the number of customers ahead.
	 */
	public int getNumberOfSuccessors() {
		if (overallRoot != null) {
			return successors(overallRoot);
		}
		return 0;
	}

	/**
	 * Private helper method to calculate the number of the customers.
	 * @param current current node.
	 * @return integer value of the number of the customers.
	 */
	private int successors(TreeNode current) {
		int position = 1;
		if (current != null) {
			while (current.right != null) {
				current = current.right;
				position++;
				if(current.hasLeftNode()) {
					current = current.left;
					position++;
				} else {
					current = current.right;
					position++;
				}

			} 
		}
		return position;
	}



	/**
	 * This inner class represents a node object. It has multiple constructors
	 * that we need in different situations. 
	 * I used the idea for implementing this TreeNode class from my past CSC316 book.
	 * @author premsubedi
	 *
	 */
	public class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;
		private E data;

		@SuppressWarnings("unused")
		private int count;

		/**
		 * Node constructor containing data only.
		 * @param data value of the node.
		 */
		public TreeNode(E data) {
			this(data, null, null, null, 0);
		}

		/**
		 * TreeNode constructor with all the instances it needs. It initializes 
		 * it's all the fields.
		 * @param data value the node contains.
		 * @param left it's left child.
		 * @param parent it's parent node.
		 * @param right it's right child.
		 * @param count number of node the tree contains.
		 */
		public TreeNode(E data, TreeNode left, TreeNode parent, TreeNode right, int count) {
			this.data = data;
			this.left = left;
			this.parent = parent;
			this.right = right;
			this.count = count;
		}

		/**
		 * Returns left node.
		 * @return left left node.
		 */
		public TreeNode getLeftNode() {
			return left;
		}

		/**
		 * Returns true if the current node has left node.
		 * @return boolean true or false.
		 */
		public boolean hasLeftNode() {
			return this.left != null;

		}

		/**
		 * Returns right child node.
		 * @return right right child node.
		 */
		public TreeNode getRightNode() {
			return right;
		}

		/**
		 * Returns true if the current node has right node.
		 * @return boolean true or false.
		 */
		public boolean hasRightNode() {
			return this.right != null;
		}

		/**
		 * Returns parent node.
		 * @return parent parent node.
		 */
		public TreeNode getParentNode() {
			return parent;
		}

		/**
		 * Returns true if the current node is root node.
		 * @return boolean true or false.
		 */
		public boolean isRoot() {
			return parent == null;
		}
	}
}

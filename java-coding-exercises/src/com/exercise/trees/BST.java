package com.exercise.trees;

import java.util.ArrayDeque;
import java.util.Deque;

/* Binary Search Tree implementation
 * Author: jmunoz 
 * 
 */
public class BST {
	
	private Node root;
	
	public void insert(int value) {
		insert(value, root);
	}
	
	
	private void insert(int value, Node subBSTRoot) {
		if (subBSTRoot == null) {
			subBSTRoot = new Node(value);
		}
		else if (value <= subBSTRoot.data) {
			insert(value, subBSTRoot.left);
		}
		else {
			//value > subBSTRoot->data
			insert(value, subBSTRoot.right);
		}
	}
	
	
	public boolean searchTree(int value) {
		return searchTree(value, root);
	}
	
	
	private boolean searchTree(int value, Node subBSTRoot) {
		if (subBSTRoot == null) {
			return false;
		}
		else if (subBSTRoot.data == value) {
			return true;
		}
		else if (value <= subBSTRoot.data) {
			return searchTree(value, subBSTRoot.left);
		}
		else {
			return searchTree(value, subBSTRoot.right);
		}
	}
	
	
	public void deleteNode(int value) {
		root = deleteNode(value, root);
	}
	
	
	private Node deleteNode(int value, Node subBSTRoot) {
		if (subBSTRoot == null) {
			return null;
		}
		else if (value < subBSTRoot.data) {
			subBSTRoot.left = deleteNode(value, subBSTRoot.left);
		}
		else if (value > subBSTRoot.data) {
			subBSTRoot.right = deleteNode(value, subBSTRoot.right);
		}
		else {
			// case 1: Target Node has no children
			if (subBSTRoot.left == null && subBSTRoot.right == null) {
				return null;
			}
			// case 2: Target Node has only one child
			if (subBSTRoot.left == null) {
				return subBSTRoot.right;
			}
			if (subBSTRoot.right == null) {
				return subBSTRoot.left;
			}
			// case 3: Target Node has two children
			int nextSuccessor = getMin(subBSTRoot.right);
			subBSTRoot.data = nextSuccessor;
			subBSTRoot.right = deleteNode(nextSuccessor,subBSTRoot.right);
		}
		return subBSTRoot;
	}

	
	public int getMin(Node subBSTRoot) {
		if (subBSTRoot.left == null) {
			return subBSTRoot.data;
		}
		return getMin(subBSTRoot.left);
	}
	
	
	public void traverseInOrder(Node subBSTRoot) {
		if (subBSTRoot != null) {
			traverseInOrder(subBSTRoot.left);
			System.out.println(" " + subBSTRoot);
			traverseInOrder(subBSTRoot.right);
		}
	}
	
	
	public void traversePostOrderNonRec(Node subBSTRoot) {

		Deque<Node> stack = new ArrayDeque<>();
		Node current = root;
		Node lastVisited = null;
		
		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				// no left subtree so get node atop the stack and traverse its right
	            // subtree or print it.
				Node stackNode = stack.peek();
				if (stackNode.right != null && lastVisited != stackNode.right) {
					current = stackNode.right;
				}
				else {
					System.out.print(stackNode.data + " ");
					stack.pop();
					lastVisited = stackNode;
				}
			}
		}
	}
	
	
	public static class Node {
		
		private int data;
		private Node right;
		private Node left;
		
		public Node(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	
		
	}

}

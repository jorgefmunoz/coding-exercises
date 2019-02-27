package com.exercise.lists;

/* Singly linked list implementation
 * Author: jmunoz 
 * 
 */
public class SinglyLinkedList {

	private Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public Node getHead() {
		return head;
	}
	
	public void insert(String val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
		}
		else {
			Node current = head;			
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
	}
	
	public void insert(Node node) {
		if (head == null) {
			head = node;
		}
		else {
			Node current = head;			
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(node);
		}
	}
	
	public void remove(String target) {
		
		// Case: List is empty
		if (null == head) {
			return;
		}
		// Case: target is head
		if (target == head.getValue()) {
			head = head.getNext();
		}
		// Case: target is somewhere in list other than head		
		Node current = head; 
		Node prev = null;
		while (current != null) {			
			if (target == current.getValue()) {
				prev.setNext(current.getNext());
				break;
			}
			prev = current;
			current = current.getNext();			
		}
	}
	
	public Node detectCycle() {
		
		// based on Floyd's Cycle Detection algorithm
		Node slow_ptr = head, fast_ptr = head;
		while (fast_ptr != null && fast_ptr.getNext() != null) {
			slow_ptr = slow_ptr.getNext();
			fast_ptr = fast_ptr.getNext().getNext();			
			if (slow_ptr == fast_ptr) {
				return fast_ptr;
			}
		}		
		return null;
	}
	
	public void reverse() {		
		if (head == null) {
			return;
		}
		Node prev = null;
		Node next = null;
		while (head != null) {
			next = head.getNext();
			head.setNext(prev);
			prev = head;
			head = next;
		}
		head = prev;
	}
	
	public void printList() {
		Node current = head;
		while (null != current) {
			System.out.print(current + " ");
			current = current.getNext();
		}
	}
		
	public static class Node {
		
		private String value;
		private Node next;
		
		public Node(String value) {
			this.value = value;
			this.next = null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return this.value;
		}		
		
	}

	
}

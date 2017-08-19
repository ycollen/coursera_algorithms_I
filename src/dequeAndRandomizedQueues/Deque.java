package dequeAndRandomizedQueues;

import java.util.Iterator;


public class Deque<Item> implements Iterable<Item>{
	
	public Deque() {
		size = 0;
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;
		size++;
	}
	
	public void addLast(Item item) {
		
	}
	
	public Item removeFirst() {
		Item a = null;
		return a;
	}
	
	public Item removeLast() {
		Item a = null;
		return a;
	}
	
	class Node{
		public Item item;
		public Node next;
	}
	
	public java.util.Iterator<Item> iterator(){
		return new DequeIterator();
	}
	
	class DequeIterator implements Iterator<Item>{
		public DequeIterator() {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		private Node current;
		
	}
	
	private Node first;
	private Node last;
	private int size;
	
}

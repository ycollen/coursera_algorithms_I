package dequeAndRandomizedQueues;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

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

	public void addFirst(Item item) throws java.lang.IllegalArgumentException{
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to add null item");
		}
		Node node = new Node();
		node.item = item;
		node.next = first;
		node.previous = null;
		if (size == 0) {
			last = node;
		}
		node.previous = null;
		first = node;
		size++;
	}

	public void addLast(Item item) throws java.lang.IllegalArgumentException{
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to add null item");
		}
		Node node = new Node();
		node.item = item;
		node.next = null;
		node.previous = last;
		last.next = node;
		last = node;
		size++;
	}

	public Item removeFirst() throws java.util.NoSuchElementException {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		Node currentFirst = first;
		first = first.next;
		first.previous = null;
		size--;
		return currentFirst.item;
	}

	public Item removeLast() throws java.util.NoSuchElementException {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		Node currentLast = last;
		last = currentLast.previous;
		last.next = null;
		size--;
		return currentLast.item;
	}

	class Node {
		public Item item;
		public Node next;
		public Node previous;
	}

	public java.util.Iterator<Item> iterator() {
		return new DequeIterator();
	}

	class DequeIterator implements Iterator<Item> {
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

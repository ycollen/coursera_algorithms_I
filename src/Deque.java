import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	public Deque() {
		size = 0;
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to add null item");
		}
		Node node = new Node();
		node.item = item;
		// new node next points to old head
		node.next = head;
		node.previous = null;
		if (size == 0) {
			tail = node;
		}
		node.previous = null;
		// previous head (if any e.g head will be null in case of previously empty deque)
		// points to new node backwards
		if(head!=null) {
			head.previous = node;
		}
		// new head points to new node
		head = node;
		size++;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to add null item");
		}
		Node newNode = new Node();
		newNode.item = item;
		newNode.next = null;
		// previous item is old tail
		newNode.previous = tail;
		// next item of previous tail (if not null e.g previously empty) points to new
		// item
		if (tail != null) {
			tail.next = newNode;
		}
		// new tail points to new node
		tail = newNode;

		if (size == 0) {
			// just one element, head = tail
			head = newNode;
		}
		size++;
	}

	public Item removeFirst() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		Node currentFirst = head;
		// new head points to previous head
		head = head.next;
		// head can be null in case of size == 1
		if (head != null) {
			head.previous = null;
		}
		size--;
		if (size == 0) {
			tail = head;
		}
		return currentFirst.item;
	}

	public Item removeLast() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		Node currentLast = tail;
		tail = currentLast.previous;
		// tail can be null in case of size == 1
		if (tail != null) {
			tail.next = null;
		}
		size--;
		if (size == 0) {
			head = tail;
		}
		return currentLast.item;
	}

	private class Node {
		public Item item;
		public Node next;
		public Node previous;
	}

	public java.util.Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {
		public DequeIterator() {
			current = head;
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

	private Node head;
	private Node tail;
	private int size;

}

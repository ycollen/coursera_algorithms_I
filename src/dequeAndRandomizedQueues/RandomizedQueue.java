package dequeAndRandomizedQueues;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	public RandomizedQueue() {

	}

	public boolean isEmpty() {
		return this.nbElts == 0;
	}

	public int size() {
		return nbElts;
	}

	public void enqueue(Item item) {
		// initial capacity
		if (this.isEmpty()) {
			array = (Item[]) new Object[capacity];
		}
		// check if full, resize
		if (last == array.length) {
			// if full, resize
			if (nbElts == array.length) {
				// resize to twice the current capacity
				resize(capacity * 2);
				capacity = capacity * 2;
			}
			// if not full, compact
			// TODO possible optimization?
			else if (nbElts < array.length) {
				// compact
			}
		}
		// add item at last position and increment last
		array[last++] = item;
		this.nbElts++;
	}

	public Item dequeue() {
		// choose a random item
		int i = StdRandom.uniform(first, last);
		return this.dequeue(i);
	}

	public Item dequeue(int i) {
		Item item = array[i];
		array[i] = null;
		if (first == i) {
			first++;
		}
		if (last == i + 1) {
			last--;
		}
		return item;
	}

	public Item sample() {
		return null;
	}

	private void resize(int newCapacity) {
		// new temp array
		Item[] temp = (Item[]) new Object[newCapacity];
		for (int i = 0; i < capacity; i++) {
			// copy all current elements to the new array
			// assume array is always full for the time being
			temp[i] = array[i];
		}
		array = temp;
	}

	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	class RandomizedQueueIterator implements Iterator<Item> {
		public boolean hasNext() {
			return true;
		}

		public Item next() {
			return null;
		}

	}

	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @return the last
	 */
	public int getLast() {
		return last;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return the nbElts
	 */
	public int getNbElts() {
		return nbElts;
	}

	private int last = 0; // pointing just after last item of the queue
	private int nbElts = 0; // nb of elements in the queue
	private int capacity = 2;
	private int first = 0; // first item in the queue
	private Item[] array;

}

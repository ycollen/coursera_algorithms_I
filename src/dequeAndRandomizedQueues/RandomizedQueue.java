package dequeAndRandomizedQueues;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	public RandomizedQueue() {
		array = (Item[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return this.nbElts == 0;
	}

	public int size() {
		return nbElts;
	}

	public void enqueue(Item item) throws java.lang.IllegalArgumentException {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to enqueue null item");
		}
		// check if full, resize
		if (last == capacity) {
			// if there are holes, compact before resizing
			if (nbElts < capacity) {
				this.compact();
			} else {
				// if full, resize twice the current capacity
				this.resize(capacity * 2);
				capacity = capacity * 2;
			}
		}
		// add item at last position and increment last
		array[last++] = item;
		this.nbElts++;
	}

	private void compact() {
		Item[] tmp = (Item[]) new Object[capacity];
		// iterate through from position 0 to last item
		// pointer to next element after last in tmp array
		int j = 0;
		for (int i = 0; i < last; i++) {
			// if an item is present copy it
			if (array[i] != null) {
				tmp[j] = array[i];
				j++;
			}
		}
		array = tmp;
		// update last pointer
		last = j;
	}

	public Item dequeue() throws java.util.NoSuchElementException {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException("Trying to dequeue from an empty queue");
		}
		int i = StdRandom.uniform(last);
		while (array[i] == null) {
			i = StdRandom.uniform(last);
		}
		return dequeue(i);
	}

	private Item dequeue(int i) {
		System.out.println("dequeuing " + i);
		System.out.println("capacity " + capacity);
		System.out.println("nbElts " + this.size());
		Item item = array[i];
		array[i] = null;
		nbElts--;
		// if last item of queue was removed, update last pointer item
		if (last == i + 1) {
			last--;
			// if previous item is null continue to go back until a non null item is reached
			while (last != 0 && array[last] == null) {
				last--;
			}
		}
		// shrink if quarter empty
		if (!this.isEmpty() && capacity / nbElts > 3) {
			// shrink
			System.out.println("shrinking...");
			Item[] tmp = (Item[]) new Object[capacity / 4];
			// point to after last item in tmp
			int j = 0;
			for (int k = 0; k < capacity; k++) {
				if (array[k] != null) {
					tmp[j] = array[k];
					j++;
				}
			}
			array = tmp;
			last = j;
			capacity = capacity / 4;
		}
		return item;
	}

	public Item sample() throws java.util.NoSuchElementException {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException("Trying to sample from empty queue");
		}
		int i = StdRandom.uniform(last);

		while (array[i] == null) {
			i = StdRandom.uniform(0, last);
		}
		return array[i];
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
		return new RandomizedQueueIterator(this);
	}

	class RandomizedQueueIterator implements Iterator<Item> {

		public RandomizedQueueIterator(RandomizedQueue<Item> randomizedQueue) {
			iteratorArray = (Item[]) new Object[randomizedQueue.size()];
			RandomizedQueue<Item> copy = new RandomizedQueue();
			current = 0;
			for (int i = 0; i < randomizedQueue.capacity; i++) {
				if (randomizedQueue.array[i] != null) {
					copy.enqueue(array[i]);
				}
			}
			// fill iterator array by dequeuing the copy of randomized array
			int k = 0;
			while (copy.isEmpty() == false) {
				this.iteratorArray[k] = copy.dequeue();
				k++;
			}
			System.out.println("finished building iterator");
		}

		public boolean hasNext() {
			return current != iteratorArray.length;
		}

		public Item next() throws java.util.NoSuchElementException {
			if (hasNext()) {
				return iteratorArray[current++];
			} else {
				throw new java.util.NoSuchElementException("Iterator does not have next items");
			}

		}

		private Item[] iteratorArray;
		private int current;

	}

	private int last = 0; // pointing just after last item of the queue
	private int nbElts = 0; // nb of elements in the queue
	private int capacity = 2;
	private Item[] array;

}


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

	public void enqueue(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException("Trying to enqueue null item");
		}
		array[nbElts] = item;
		nbElts++;
		// check if full, resize
		if (nbElts == capacity) {
			// if full, resize twice the current capacity
			this.resize(capacity * 2);
			capacity = capacity * 2;

		}

	}

	public Item dequeue() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException("Trying to dequeue from an empty queue");
		}
		int i = StdRandom.uniform(nbElts);
		Item item = array[i];
		array[i] = array[--nbElts];
		array[nbElts] = null;
		if (nbElts <= capacity / 4) {
			this.resize(capacity/4);
			capacity = capacity / 4;
		}
		return item;
	}


	public Item sample() {
		if (this.isEmpty()) {
			throw new java.util.NoSuchElementException("Trying to sample from empty queue");
		}
		int i = StdRandom.uniform(nbElts);
		return array[i];
	}

	private void resize(int newCapacity) {
		// new temp array
		Item[] temp = (Item[]) new Object[newCapacity];
		for (int i = 0; i < nbElts; i++) {
			// copy all current elements to the new array
			// assume array is always full for the time being
			temp[i] = array[i];
		}
		array = temp;
	}

	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator(this);
	}

	private class RandomizedQueueIterator implements Iterator<Item> {

		public RandomizedQueueIterator(RandomizedQueue<Item> randomizedQueue) {
			iteratorArray = (Item[]) new Object[randomizedQueue.size()];
			RandomizedQueue<Item> copy = new RandomizedQueue();
			current = 0;
			int k = 0;
			for (int i = 0; i < randomizedQueue.capacity; i++) {
				if (randomizedQueue.array[i] != null) {
					iteratorArray[k] = array[i];
					k++;
				}
			}
			StdRandom.shuffle(iteratorArray);
		}

		public boolean hasNext() {
			return current != iteratorArray.length;
		}

		public Item next() {
			if (hasNext()) {
				return iteratorArray[current++];
			} else {
				throw new java.util.NoSuchElementException("Iterator does not have next items");
			}

		}

		private Item[] iteratorArray;
		private int current;

	}

	private int nbElts = 0; // nb of elements in the queue
	private int capacity = 2;
	private Item[] array;

}

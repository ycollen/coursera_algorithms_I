package dequeAndRandomizedQueues;

import static org.junit.Assert.*;

import java.io.Console;
import java.util.Iterator;

import org.junit.Test;

public class RandomizedQueueTest {

	@Test
	public void testIsEmpty() {
		RandomizedQueue<String> rQueue = new RandomizedQueue<String>();
		assertEquals("queue empty at construction", true, rQueue.isEmpty());
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		q.enqueue("Item enqueued 1");
		assertEquals("not empty", false, q.isEmpty());
	}

	@Test
	public void testEnqueue() {
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		q.enqueue("Item 1");
		assertEquals("size is 1", 1, q.size());
		q.enqueue("Item 2");
		assertEquals("size is 2", 2, q.size());
		q.enqueue("Item 3");
		assertEquals("size is 3", 3, q.size());

	}

	@Test
	public void testDequeue() {
		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
		int max = 64;
		for (int i = 0; i < max; i++) {
			q.enqueue(i);
		}
		int j = max;
		int i = 1;
		while (q.isEmpty() == false) {
			System.out.println("successfully dequeued " + i + " " + q.dequeue());
			System.out.println("size is now " + q.size());
			j--;
			i++;
			System.out.println("j = " + j);
			System.out.println("Is empty? " + q.isEmpty());
			assertEquals("size ", j, q.size());
		}
		assertEquals("empty", true, q.isEmpty());
	}

	@Test
	public void testIterator() {

		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
		int max = 64;
		for (int i = 0; i < max; i++) {
			q.enqueue(i);
		}
		Iterator<Integer> it = q.iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			Integer itValue = it.next();
			assertNotNull("should not be null", itValue);
			System.out.println("iterator value " + itValue);
		}
		assertEquals("Iterator should have iterated 64 times", 64, i);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void enqueueNullItemException() {
		RandomizedQueue<Integer> q = new RandomizedQueue();
		q.enqueue(null);
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void sampleFromEmptyQueue() {
		RandomizedQueue<Integer> q = new RandomizedQueue();
		q.sample();
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void dequeueFromEmptyQueue() {
		RandomizedQueue<Integer> q = new RandomizedQueue();
		q.dequeue();
	}

	@Test(expected = java.lang.UnsupportedOperationException.class)
	public void testRemoveFromIterator() {

		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
		int max = 64;
		for (int i = 0; i < max; i++) {
			q.enqueue(i);
		}
		Iterator<Integer> it = q.iterator();
		it.remove();

	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void testNextOnEmptyIterator() {

		RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
		int max = 64;
		for (int i = 0; i < max; i++) {
			q.enqueue(i);
		}
		Iterator<Integer> it = q.iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			Integer itValue = it.next();
			assertNotNull("should not be null", itValue);
			System.out.println("iterator value " + itValue);
		}
		it.next();
	}

}

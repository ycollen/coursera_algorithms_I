package dequeAndRandomizedQueues;

import static org.junit.Assert.*;

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

//	@Test
//	public void testSize() {
//		//fail("Not yet implemented");
//	}
//
	@Test
	public void testEnqueue() {
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		q.enqueue("Item 1");
		assertEquals("capacity = 2", 2, q.getCapacity());
		assertEquals("first = 0", 0, q.getFirst());
		assertEquals("last = 1", 1, q.getLast());
		q.enqueue("Item 2");
		assertEquals("capacity = 2", 2, q.getCapacity());
		assertEquals("first = 0", 0, q.getFirst());
		assertEquals("last=2", 2, q.getLast());
		q.enqueue("Item 3");
		assertEquals("capacity = 4", 4, q.getCapacity());
		assertEquals("first = 0", 0, q.getFirst());
		assertEquals("last = 3", 3, q.getLast());
	}
//
//	@Test
//	public void testDequeue() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSample() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	public void testIterator() {
//		//fail("Not yet implemented");
//	}

}

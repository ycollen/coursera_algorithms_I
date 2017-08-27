package dequeAndRandomizedQueues.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import dequeAndRandomizedQueues.Deque;

public class DequeTest {

	@Test
	public void addFirstTest() {
		Deque<String> myDeque = new Deque<String>();
		assertEquals("empty deque", true, myDeque.isEmpty());
		// add a first item
		myDeque.addFirst("Item 1");
		assertEquals("Size == 1 after adding one item", 1, myDeque.size());
		assertEquals("not empty after adding one item", false, myDeque.isEmpty());
		assertEquals("first item should be Item 1", "Item 1", myDeque.iterator().next());
		assertEquals("hasNext() should return true", true, myDeque.iterator().hasNext());
		// Add a second item first
		myDeque.addFirst("Item 2");
		assertEquals("Size == 2", 2, myDeque.size());
		Iterator<String> iterator = myDeque.iterator();
		assertEquals("hasNext() is true", true, iterator.hasNext());
		assertEquals("first item should be Item 2", "Item 2", iterator.next());
		assertEquals("hasNext() is true", true, iterator.hasNext());
		assertEquals("second item should be Item 1", "Item 1", iterator.next());
		assertEquals("no item left", false, iterator.hasNext());
		
		myDeque.addLast("last item");
		assertEquals("Size == 3", 3, myDeque.size());
		Iterator<String> iterator2 = myDeque.iterator();
		assertEquals("hasNext() is true", true, iterator2.hasNext());
		assertEquals("first item should be Item 2", "Item 2", iterator2.next());
		assertEquals("hasNext() is true", true, iterator2.hasNext());
		assertEquals("second item should be Item 1", "Item 1", iterator2.next());
		assertEquals("hasNext() is true", true, iterator2.hasNext());
		assertEquals("third item should be last item", "last item", iterator2.next());
		assertEquals("no item left", false, iterator2.hasNext());
		
		String firstItem = myDeque.removeFirst();
		assertEquals("Size == 2", 2, myDeque.size());
		assertEquals("first item was Item 2", "Item 2", firstItem);
		Iterator<String> iterator3 = myDeque.iterator();
		assertEquals("hasNext() is true", true, iterator3.hasNext());
		assertEquals("second item should be Item 1", "Item 1", iterator3.next());
		assertEquals("hasNext() is true", true, iterator3.hasNext());
		assertEquals("third item should be last item", "last item", iterator3.next());
		assertEquals("no item left", false, iterator3.hasNext());
		
		String lastItem = myDeque.removeLast();
		assertEquals("last item was last item", "last item", lastItem);
		assertEquals("Size == 1", 1, myDeque.size());
		assertEquals("first item was Item 2", "Item 2", firstItem);
		Iterator<String> iterator4 = myDeque.iterator();
		assertEquals("hasNext() is true", true, iterator4.hasNext());
		assertEquals(" item should be Item 1", "Item 1", iterator4.next());
		assertEquals("no item left", false, iterator4.hasNext());
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void exceptionRemoveFromEmptyDeque() {
		Deque<String> deque = new Deque<String>();
		deque.removeFirst();
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void exceptionRemoveLastFromEmptyQueue() {
		Deque<String> deque = new Deque<String>();
		deque.removeLast();
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void addNullItem() {
		Deque<String> deque = new Deque<String>();
		deque.addFirst(null);
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void addLastNullItem() {
		Deque<String> deque = new Deque<String>();
		deque.addLast(null);
	}
}

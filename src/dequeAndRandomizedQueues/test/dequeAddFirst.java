package dequeAndRandomizedQueues.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dequeAndRandomizedQueues.Deque;

public class dequeAddFirst {

	@Test
	public void AddOne() {
		Deque<String> myDeque = new Deque<String>();
		myDeque.addFirst("Item 1");
		assertEquals("Size == 1 after adding one item", 1, myDeque.size());
	}

}

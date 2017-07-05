import static org.junit.Assert.*;

import org.junit.Test;

public class PercolationConstructionUnitTest {

	@Test
	public void testConstructor() throws java.lang.IllegalArgumentException {
		Percolation myPercolation = new Percolation(10);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals("failure site is not blocked", false, myPercolation.isOpen(i+1, j+1));
			}
		}
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testExceptionMinusOne() throws java.lang.IllegalArgumentException {
		Percolation myPercolation = new Percolation(-1);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testExceptionZero() throws java.lang.IllegalArgumentException {
		Percolation myPercolation = new Percolation(0);
	}
}

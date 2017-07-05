import static org.junit.Assert.*;

import org.junit.Test;

public class PercolationOpenUnitTest {

	@Test
	public void test() {
		Percolation myPercolation = new Percolation(10);
		assertEquals("failure - site should be blocked", false, myPercolation.isOpen(1, 1));
		myPercolation.open(1, 1);
		assertEquals("failure - site should be opened", true, myPercolation.isOpen(1, 1));
	}

	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentZeroRow() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(0, 2);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentZeroCol() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(1, 0);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentNegativeCol() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(1, -2);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentNegativeRow() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(-2, 2);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentMinusOne() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.open(0, 1);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentOutsidePrescribedRangeCol() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.open(1, 6);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentOutsidePrescribedRangeRow() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.open(6, 2);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentOutsidePrescribedRangeColIsOpen() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(0, 6);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testIllegalArgumentOutsidePrescribedRangeRowIsOpen() {
		Percolation myPercolation = new Percolation(5);
		myPercolation.isOpen(6, 2);
	}
}

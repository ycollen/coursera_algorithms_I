import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testCompareTo() {
		Point point = new Point(2, 1);
		assertEquals("(2,1) is smaller than (2,2)", -1, point.compareTo(new Point(1, 2)));
		assertEquals("(2,1) is equal to (2,1)", 0, point.compareTo(new Point(2, 1)));
		assertEquals("(2,1) is smaller than (3,1)", -1, point.compareTo(new Point(3, 1)));
		assertEquals("(2,1) is smaller than (0,4)", -1, point.compareTo(new Point(0, 4)));
		assertEquals("(2,1) is greater than (2,0)", 1, point.compareTo(new Point(2, 0)));
		assertEquals("(2,1) is greater than (1,0)", 1, point.compareTo(new Point(1, 0)));
		assertEquals("(2,1) is greater than (1,1)", 1, point.compareTo(new Point(1, 1)));
	}

	@Test
	public void testSlopeTo() {
		Point point = new Point(2, 3);
		Double value = point.slopeTo(new Point(2, 3));
		assertEquals(Double.NEGATIVE_INFINITY,
				point.slopeTo(new Point(2, 3)), 0.0);
		// vertical line
		assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(new Point(2,1)), 0.0);
		assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(new Point(2,4)), 0.0);
		assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(new Point(2,0)), 0.0);
		
		// horizontal line
		assertEquals(0, point.slopeTo(new Point(3, 3)), 0);
		assertEquals(0, point.slopeTo(new Point(1, 3)), 0);
		
		// slope 1
		assertEquals(1, point.slopeTo(new Point(3, 4)), 0);
		// slope 1
		assertEquals(1, point.slopeTo(new Point(1, 2)), 0);
		// slope 0.5
		assertEquals(0.5, point.slopeTo(new Point(0, 2)), 0);
		// slope -1
		assertEquals(-1, point.slopeTo(new Point(3, 2)), 0);
		// slope -1
		assertEquals(-1, point.slopeTo(new Point(1, 4)), 0);
		// slope -0.33
		assertEquals(-0.333, point.slopeTo(new Point(5, 2)), 0.0004);






	}

	@Test
	public void testSlopeOrder() {
		// fail("Not yet implemented");
	}

}

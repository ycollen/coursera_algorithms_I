import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testCompareTo() {
		Point point = new Point(2,1);
		assertEquals("(2,1) is smaller than (2,2)", -1, point.compareTo(new Point(1, 2)));
		assertEquals("(2,1) is equal to (2,1)", 0, point.compareTo(new Point(2,1)));
		assertEquals("(2,1) is smaller than (3,1)", -1, point.compareTo(new Point(3,1)));
		assertEquals("(2,1) is smaller than (0,4)", -1, point.compareTo(new Point(0,4)));
		assertEquals("(2,1) is greater than (2,0)", 1, point.compareTo(new Point(2,0)));
		assertEquals("(2,1) is greater than (1,0)", 1, point.compareTo(new Point(1,0)));
		assertEquals("(2,1) is greater than (1,1)", 1, point.compareTo(new Point(1,1)));
	}

	@Test
	public void testSlopeOrder() {
		//fail("Not yet implemented");
	}

}

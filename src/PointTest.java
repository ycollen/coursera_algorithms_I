import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testCompareTo() {
		Point point = new Point(2,1);
		assertEquals("(2,1) is smaller than (1,2)", -1, point.compareTo(new Point(1, 2)));
	}

	@Test
	public void testSlopeOrder() {
		//fail("Not yet implemented");
	}

}

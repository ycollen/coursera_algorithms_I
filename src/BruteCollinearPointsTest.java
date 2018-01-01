import static org.junit.Assert.*;

import org.junit.Test;

public class BruteCollinearPointsTest {

	@Test
	public void testBruteOrderedCollinearPoints() {
		// create an array of 4 collinear points in order
		Point [] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(0, 0);
		fourCollinearPoints[1] = new Point(1, 1);
		fourCollinearPoints[2] = new Point(2, 2);
		fourCollinearPoints[3] = new Point(3, 3);
		
		// call constructor of brute collinear point
		BruteCollinearPoints collPoints = new BruteCollinearPoints(fourCollinearPoints);
		// check that the number of line segments is 1
		assertEquals("one line segment found", 1, collPoints.numberOfSegments());
		// check that the line segment contains the 4 points
		LineSegment[] lineSegment = collPoints.segments();
		System.out.println("collinear points line segment: " + lineSegment[0].toString());
	}

	@Test
	public void testBruteUnorderedCollinearPoints() {
		// create an array of 4 collinear points in order
		Point [] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = new Point(2, 2);
		fourCollinearPoints[3] = new Point(3, 3);
		
		// call constructor of brute collinear point
		BruteCollinearPoints collPoints = new BruteCollinearPoints(fourCollinearPoints);
		// check that the number of line segments is 1
		assertEquals("one line segment found", 1, collPoints.numberOfSegments());
		// check that the line segment contains the 4 points
		LineSegment[] lineSegment = collPoints.segments();
		System.out.println("collinear points line segment: " + lineSegment[0].toString());

	}

	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testNullConstructor() {
		BruteCollinearPoints points = new BruteCollinearPoints(null);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testNullPointInArray() {
		Point [] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = null;
		fourCollinearPoints[3] = new Point(3, 3);
		BruteCollinearPoints points = new BruteCollinearPoints(fourCollinearPoints);
	}
	
	@Test (expected = java.lang.IllegalArgumentException.class)
	public void testRepeatedPointInArray() {
		Point [] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = new Point(0, 0);
		fourCollinearPoints[3] = new Point(3, 3);
		BruteCollinearPoints points = new BruteCollinearPoints(fourCollinearPoints);
	}
}

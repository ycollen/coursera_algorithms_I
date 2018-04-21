import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPointsTest {

	@Test
	public void testFastOrderedCollinearPoints() {
		// create an array of 4 collinear points in order
		Point[] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(0, 0);
		fourCollinearPoints[1] = new Point(1, 1);
		fourCollinearPoints[2] = new Point(2, 2);
		fourCollinearPoints[3] = new Point(3, 3);

		// call constructor of fast collinear point
		FastCollinearPoints collPoints = new FastCollinearPoints(fourCollinearPoints);
		// check that the number of line segments is 1
		assertEquals("one line segment found", 1, collPoints.numberOfSegments());
		// check that the line segment contains the 4 points
		LineSegment[] lineSegment = collPoints.segments();
		//System.out.println("collinear points line segment: " + lineSegment[0].toString());
	}

	@Test
	public void testFastUnorderedCollinearPoints() {
		// create an array of 4 collinear points in order
		Point[] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = new Point(2, 2);
		fourCollinearPoints[3] = new Point(3, 3);

		// call constructor of brute collinear point
		FastCollinearPoints collPoints = new FastCollinearPoints(fourCollinearPoints);
		// check that the number of line segments is 1
		assertEquals("one line segment found", 1, collPoints.numberOfSegments());
		// check that the line segment contains the 4 points
		LineSegment[] lineSegment = collPoints.segments();
		//System.out.println("collinear points line segment: " + lineSegment[0].toString());

	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullConstructor() {
		FastCollinearPoints points = new FastCollinearPoints(null);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullPointInArray() {
		Point[] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = null;
		fourCollinearPoints[3] = new Point(3, 3);
		FastCollinearPoints points = new FastCollinearPoints(fourCollinearPoints);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRepeatedPointInArray() {
		Point[] fourCollinearPoints = new Point[4];
		fourCollinearPoints[0] = new Point(1, 1);
		fourCollinearPoints[1] = new Point(0, 0);
		fourCollinearPoints[2] = new Point(0, 0);
		fourCollinearPoints[3] = new Point(3, 3);
		FastCollinearPoints points = new FastCollinearPoints(fourCollinearPoints);
	}

	public Point[] readFile(String fileName) {
		// read the n points from a file
		In in = new In(fileName);
		int n = in.readInt();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			int x = in.readInt();
			int y = in.readInt();
			points[i] = new Point(x, y);
			System.out.println("x = " + x);
		}
		// draw the points
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		for (Point p : points) {
			p.draw();
		}
		StdDraw.show();
	    // print and draw the line segments
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
		return points;
	}

	@Test
	public void testInput1() {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		Point[] points = readFile("testdata/collinear/input20.txt");
	}
}
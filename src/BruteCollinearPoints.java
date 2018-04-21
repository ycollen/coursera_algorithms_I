import java.util.Vector;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class BruteCollinearPoints {

	public BruteCollinearPoints(Point[] points) {

		if (points == null) {
			throw new java.lang.IllegalArgumentException("null argument");
		}
		this.numberOfSegments = 0;
		segments = new Vector<LineSegment>();
		Point previousPoint = null;
		for (int i = 0; i < points.length; i++) {
			if (points[i] == null) {
				throw new java.lang.IllegalArgumentException("null argument");
			}
		}
		Arrays.sort(points);
		for (int i = 0; i < points.length; i++) {
			if (previousPoint != null && previousPoint.compareTo(points[i]) == 0) {
				throw new java.lang.IllegalArgumentException("same point");
			}
			previousPoint = points[i];
		}
		// finds all line segments containing 4 points

		// iterate on all subset of 4 points to check if they are collinear
		Point min;
		Point max;
		for (int p = 0; p < points.length; p++) {
			for (int q = p + 1; q < points.length; q++) {
				if (points[q] == null) {
					throw new java.lang.IllegalArgumentException("null argument");
				}
				for (int r = q + 1; r < points.length; r++) {
					if (points[r] == null) {
						throw new java.lang.IllegalArgumentException("null argument");
					}
					for (int s = r + 1; s < points.length; s++) {
						if (points[s] == null) {
							throw new java.lang.IllegalArgumentException("null argument");
						}

						if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r])
								&& points[p].slopeTo(points[r]) == points[p].slopeTo(points[s])) {
//							System.out.println("p = " + points[p]);
//							System.out.println("q = " + points[q]);
//							System.out.println("r = " + points[r]);
//							System.out.println("s = " + points[s]);
//
//							System.out.println("slope from p to q =" + points[p].slopeTo(points[q]));
//							System.out.println("slope from p to r =" + points[p].slopeTo(points[r]));
//							System.out.println("slope from p to s =" + points[p].slopeTo(points[s]));
							
							Point[] collinearPoints = new Point[4];
							collinearPoints[0] = points[p];
							collinearPoints[1] = points[q];
							collinearPoints[2] = points[r];
							collinearPoints[3] = points[s];
							Arrays.sort(collinearPoints);
							// points are collinear
							this.numberOfSegments++;
							// add line segment
							segments.add(new LineSegment(collinearPoints[0], collinearPoints[3]));
						}
					}
				}
			}
		}
	}

	/**
	 * @return the number of line segments
	 */
	public int numberOfSegments() {
		return numberOfSegments;
	}

	/**
	 * @return the line segments
	 */
	public LineSegment[] segments() {
		LineSegment[] value = new LineSegment[segments.size()];
		for (int i = 0; i < segments.size(); i++) {
			value[i] = segments.elementAt(i);
		}
		return value;
	}

	private int numberOfSegments;

	private Vector<LineSegment> segments;

}

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

/**
 * 
 */

/**
 * @author Yan Collendavelloo
 *
 */
public class FastCollinearPoints {

	/**
	 * 
	 */
	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new java.lang.IllegalArgumentException("null argument");
		}
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
		// examine each point one by one to find its corresponding collinear points
		for (int i = 0; i < points.length; i++) {
			// Think of p as the origin.
			Point p = points[i];
			
			// Sort the points according to the slopes they make with p.
			Arrays.sort(points, p.slopeOrder());
			// Check if any 3 (or more) adjacent points in the sorted order have equal
			// slopes with respect to p. If so, these points, together with p, are
			// collinear
			int consecutivePointsWithSameSlope = 1;
			// index 0 is p as a point has slope negative infinity wrt itself
			double previousSlope = p.slopeTo(points[1]);
			for (int j = 2; j < points.length; j++) {
				double slopeTo = p.slopeTo(points[j]);
				if (slopeTo == previousSlope) {
					consecutivePointsWithSameSlope++;
				}
				if (consecutivePointsWithSameSlope > 2 && (j == points.length - 1 || p.slopeTo(points[j]) != previousSlope)) {
					// collinear points - get min and max point and add as segment
					Point minPoint = points[j - 1];
					Point maxPoint = points[j - 1];
					for (int k = 1; k < consecutivePointsWithSameSlope; k++) {
						if (minPoint.compareTo(points[j - 1 - k]) == 1) {
							// minPoint is greater than point being examined, change minPoint
							minPoint = points[j - 1 - k];
						}
						if (maxPoint.compareTo(points[j - 1 - k]) == -1) {
							// maxPoint is smaller than point being examined, change maxPoint
							maxPoint = points[j - 1 - k];
						}
					}
					consecutivePointsWithSameSlope = 1;
					// add segment based on min and max point if segment is not already existing
					
					segments.add(new LineSegment(minPoint, maxPoint));
					numberOfSegments++;
				}
				previousSlope = p.slopeTo(points[j]);
			}
			// remove point already examined
			points = Arrays.copyOfRange(points, 1, points.length);
		}
	}

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

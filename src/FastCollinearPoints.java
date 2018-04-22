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
	public FastCollinearPoints(Point[] inputPoints) {
		if (inputPoints == null) {
			throw new java.lang.IllegalArgumentException("null argument");
		}
		segments = new Vector<LineSegment>();
		Point previousPoint = null;
		for (int i = 0; i < inputPoints.length; i++) {
			if (inputPoints[i] == null) {
				throw new java.lang.IllegalArgumentException("null argument");
			}
		}
		// copy array to avoid modifying it
		Point[] pointsForLoop = Arrays.copyOf(inputPoints, inputPoints.length);
		Arrays.sort(pointsForLoop);
		for (int i = 0; i < pointsForLoop.length; i++) {
			if (previousPoint != null && previousPoint.compareTo(pointsForLoop[i]) == 0) {
				throw new java.lang.IllegalArgumentException("same point");
			}
			previousPoint = pointsForLoop[i];
		}
		// examine each point one by one to find its corresponding collinear points
		for (int i = 0; i < inputPoints.length; i++) {
			// Think of p as the origin.
			Point p = pointsForLoop[0];
			// Sort the points according to the slopes they make with p.
			Point[] points = Arrays.copyOf(pointsForLoop, pointsForLoop.length);
			Arrays.sort(points, p.slopeOrder());
			// Check if any 3 (or more) adjacent points in the sorted order have equal
			// slopes with respect to p. If so, these points, together with p, are
			// collinear
			int consecutivePointsWithSameSlope = 1;
			double previousSlope = Double.NEGATIVE_INFINITY;
			// index 0 is p as a point has slope negative infinity wrt itself, start with 1
			for (int j = 1; j < points.length; j++) {
				double slopeTo = p.slopeTo(points[j]);
				if (slopeTo == previousSlope) {
					// same slope as previous
					consecutivePointsWithSameSlope++;
					// if last point and we have a line segment, add it
					if (j == (points.length - 1) && consecutivePointsWithSameSlope > 2) {
						computeLineSegments(points, p, j - consecutivePointsWithSameSlope + 1, j,
								consecutivePointsWithSameSlope);
					}
				} else {
					// we move to a new slope, compute line segment
					if (consecutivePointsWithSameSlope > 2) {
						computeLineSegments(points, p, j - consecutivePointsWithSameSlope, j - 1,
								consecutivePointsWithSameSlope);
					}
					// slope has changed, reinitialise to 1
					consecutivePointsWithSameSlope = 1;
				}
				previousSlope = slopeTo;
			}
			// remove point already examined
			pointsForLoop = Arrays.copyOfRange(pointsForLoop, 1, pointsForLoop.length);
		}

	}

	public int numberOfSegments() {
		return numberOfSegments;
	}

	private void computeLineSegments(Point[] pointArray, Point referencePoint, int indexFirstPoint, int indexLastPoint,
			int nbConsecutivePoints) {
		// collinear points - get min and max point and add as segment
		Point[] collinearPoints = new Point[nbConsecutivePoints + 1];
		collinearPoints[0] = referencePoint;
		for (int i = 0; i < nbConsecutivePoints; i++) {
			collinearPoints[i + 1] = pointArray[indexFirstPoint + i];
		}
		Arrays.sort(collinearPoints);
		// add segment based on min and max point if segment is not already existing
		segments.add(new LineSegment(collinearPoints[0], collinearPoints[nbConsecutivePoints]));
		numberOfSegments++;
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

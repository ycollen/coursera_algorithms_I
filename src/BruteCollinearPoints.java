import java.util.Vector;
import java.util.Set;
import java.util.TreeSet;

public class BruteCollinearPoints {

	public BruteCollinearPoints(Point[] points) {
		if (points == null) {
			throw new java.lang.IllegalArgumentException("null argument");
		}
		this.numberOfSegments = 0;
		segments = new Vector<LineSegment>();
		pointsSet = new TreeSet<Point>();
		// finds all line segments containing 4 points
		
		// iterate on all subset of 4 points to check if they are collinear
		Point min;
		Point max;
		for (int p = 0; p < points.length; p++) {
			if (points[p] == null) {
				throw new java.lang.IllegalArgumentException("null argument");
			}
			if (pointsSet.contains(points[p])) {
				throw new java.lang.IllegalArgumentException("same point");
			}
			pointsSet.add(points[p]);

			min = points[p];
			max = points[p];
			for (int q = p + 1; q < points.length; q++) {
				if (points[q] == null) {
					throw new java.lang.IllegalArgumentException("null argument");
				}
				if (points[q].compareTo(min) < 0) {
					min = points[q];
				}
				else if (points[q].compareTo(max) > 0) {
					max = points[q];
				}

				for (int r = q + 1; r < points.length; r++) {
					if (points[r] == null) {
						throw new java.lang.IllegalArgumentException("null argument");
					}
					if(points[r].compareTo(min) < 0) {
						min = points[r];
					}
					else if(points[r].compareTo(max) > 0) {
						max = points[r];
					}
					for (int s = r + 1; s < points.length; s++) {
						if (points[s] == null) {
							throw new java.lang.IllegalArgumentException("null argument");
						}
						if (points[s].compareTo(min) < 0) {
							min = points[s];
						}
						else if (points[s].compareTo(max) > 0) {
							max = points[s];
						}
						
						// check if two points are similar
						// check if the 4 points are collinear
						//System.out.println("p = " + points[p]);
						//System.out.println("q = " + points[q]);
						//System.out.println("r = " + points[r]);
						//System.out.println("s = " + points[s]);

						//System.out.println("slope from p to q =" + points[p].slopeTo(points[q]));
						//System.out.println("slope from p to r =" + points[p].slopeTo(points[r]));
						//System.out.println("slope from p to s =" + points[p].slopeTo(points[s]));

						if (points[p].slopeTo(points[q]) == points[p].slopeTo(points[r])
								&& points[p].slopeTo(points[r]) == points[p].slopeTo(points[s])) {
							// points are collinear
							this.numberOfSegments++;
							// add line segment
							segments.add(new LineSegment(min, max));
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
		for(int i = 0; i < segments.size(); i++) {
			value[i] = segments.elementAt(i);
		}
		return value;
	}


	private int numberOfSegments;
	
	private Vector<LineSegment> segments;
	
	private Set<Point> pointsSet;


	
		

}
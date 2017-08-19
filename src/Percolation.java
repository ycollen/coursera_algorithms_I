
//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	public Percolation(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		try {
			_unionFind = new WeightedQuickUnionUF((n * n) + 1);
			this._sites = new int[n][n];
			this._width = n;
			this._nbOfOpenSites = 0;
			// connect virtual top site to all sites in the top row to facilitate isFull
			for (int i = 0; i < _width; i++) {
				this._unionFind.union(_width * _width, i);
			}
			// connect virtual bottom site to all bottom to facilitate percolates
			// int bottomLeftPosition = this.getPositionInUFDataStructure(_width-1, 0);
			// int bottomRightPosition = this.getPositionInUFDataStructure(_width-1,
			// _width-1);
			// for (int i = bottomLeftPosition; i <= bottomRightPosition; i++) {
			// this._unionFind.union( (_width * _width) + 1, i);
			// }
		} catch (NegativeArraySizeException e) {
			IllegalArgumentException ex = new IllegalArgumentException();
			throw ex;
		} catch (ArrayIndexOutOfBoundsException e) {
			IllegalArgumentException ex = new IllegalArgumentException();
			throw ex;
		}
	}

	/**
	 * opens site
	 * 
	 * @param row
	 *            row index
	 * @param col
	 *            column index
	 */
	public void open(int row, int col) {
		if (this.isOutOfRange(row, col)) {
			throw new java.lang.IllegalArgumentException();
		}
		if (!this.isOpen(row, col)) {
			// index correction
			final int rowArrayIndex = row - 1;
			final int colArrayIndex = col - 1;

			final int unionFindPosition = this.getPositionInUFDataStructure(rowArrayIndex, colArrayIndex);

			// open site
			this._sites[rowArrayIndex][colArrayIndex] = Percolation.OPEN;
			this._nbOfOpenSites++;
			// connect the site to all its neighbor sites that are open
			// top site. check for existence first of row above
			if (rowArrayIndex != 0 && this.isOpen(row - 1, col)) {
				this._unionFind.union(unionFindPosition - _width, unionFindPosition);
			}
			// if (row == 1) {
			// // this is a top row site. Connect to virtual top row
			// this._unionFind.union(unionFindPosition, _width * _width);
			// }
			// bottom site. check for existence first
			if (rowArrayIndex != _width - 1 && this.isOpen(row + 1, col)) {
				this._unionFind.union(unionFindPosition + _width, unionFindPosition);
			}
			// if (row == _width) {
			// // this site is on the bottom row. Connect to virtual bottom row
			// this._unionFind.union(unionFindPosition, (_width*_width) + 1);
			// }
			// left site. check for existence first
			if (colArrayIndex != 0 && this.isOpen(row, col - 1)) {
				this._unionFind.union(unionFindPosition - 1, unionFindPosition);
			}
			// right site. Check for existence first
			if (colArrayIndex != _width - 1 && this.isOpen(row, col + 1)) {
				this._unionFind.union(unionFindPosition + 1, unionFindPosition);
			}
		}
	}

	/**
	 * is site at position row, column open
	 * 
	 * @param row
	 *            row position of site
	 * @param col
	 *            column position of site
	 * @return true if site is open. false if site is blocked
	 */
	public boolean isOpen(int row, int col) {
		if (this.isOutOfRange(row, col)) {
			throw new java.lang.IllegalArgumentException();
		}
		return _sites[row - 1][col - 1] == Percolation.OPEN;
	}

	/**
	 * 
	 * @param row
	 *            row number
	 * @param col
	 *            column number
	 * @return true if site is full. Else returns false.
	 */
	public boolean isFull(int row, int col) {
		// index correction
		final int rowArrayIndex = row - 1;
		final int colArrayIndex = col - 1;
		// check if n*n+1 is connected to current site. check is open as top row is
		// always connected to the virtual site
		return this.isOpen(row, col) && this._unionFind
				.connected(this.getPositionInUFDataStructure(rowArrayIndex, colArrayIndex), _width * _width);
	}

	public int numberOfOpenSites() {
		return this._nbOfOpenSites;
	}

	private boolean isOutOfRange(int row, int col) {
		if (row < 1 || col < 1 || row > _width || col > _width) {
			return true;
		} else {
			return false;
		}
	}

	public boolean percolates() {
		// a site percolates if at least one of its bottom sites is a full site
		for (int i = 1; i <= _width; i++) {
			if (this.isFull(_width, i)) {
				return true;
			}
		}
		// a site percolates if the bottom virtual site connects to the top virtual site
		// boolean percolates = this._unionFind.connected(_width * _width, (_width *
		// _width) + 1);
		// return percolates;
		return false;
	}

	private int getPositionInUFDataStructure(int row, int col) {
		return row * _width + col;
	}

	// array of array saying if site is open or blocked
	private int[][] _sites;
	// union find
	private WeightedQuickUnionUF _unionFind;
	private int _width;
	private int _nbOfOpenSites;
	static private final int OPEN = 1;

}

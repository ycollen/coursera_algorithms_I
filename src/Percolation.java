
public class Percolation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Percolation(int n) throws java.lang.IllegalArgumentException {
		if (n < 1) {
			throw new java.lang.IllegalArgumentException();
		} else {
			this.size = n;
			this.sites = new int[this.size][this.size];
			for (int i = 0; i < this.size; i++) {
				for (int j = 0; j < this.size; j++) {
					// initialize all sites to blocked
					sites[i][j] = this.BLOCKED;
				}
			}
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
	public void open(int row, int col) throws java.lang.IllegalArgumentException {
		if (this.isOutOfRange(row, col)) {
			throw new java.lang.IllegalArgumentException();
		}
		this.sites[row - 1][col - 1] = this.OPEN;
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
	public boolean isOpen(int row, int col) throws java.lang.IllegalArgumentException {
		if (this.isOutOfRange(row, col)) {
			throw new java.lang.IllegalArgumentException();
		}
		return sites[row - 1][col - 1] == this.OPEN;
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
		return false;
	}

	private boolean isOutOfRange(int row, int col) {
		if (row < 1 || col < 1 || row > size || col > size) {
			return true;
		} else {
			return false;
		}
	}

	private int size;
	private int[][] sites;
	private final int BLOCKED = 0;
	private final int OPEN = 1;

}

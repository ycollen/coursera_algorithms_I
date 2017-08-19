
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		PercolationStats aPercolationStats = new PercolationStats(n, trials);
		System.out.println("mean \t\t = " + aPercolationStats.mean());
		System.out.println("stddev \t\t = " + aPercolationStats.stddev());
		System.out.println("95% confidence interval \t\t[" + aPercolationStats.confidenceLo() + ", "
				+ aPercolationStats.confidenceHi());
	}

	/**
	 * Performs trials independent experiments on percolation grid
	 * 
	 * @param n
	 *            size of n-by-n grid
	 * @param trials
	 *            number of trials
	 */
	public PercolationStats(int n, int trials) {
		if (trials <= 0) {
			throw new IllegalArgumentException("Negative value for trials not accepted");
		}

		this.percolationFractionOfOpenSites = new double[trials];
		for (int i = 0; i < trials; i++) {
			Percolation percolation = new Percolation(n);
			int nbOpenSites = 0;
			while (!percolation.percolates()) {
				// open a site at random
				percolation.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
				nbOpenSites++;
			}
			this.percolationFractionOfOpenSites[i] = ((double) percolation.numberOfOpenSites()) / ((double) (n * n));
		}
		this.mean = StdStats.mean(percolationFractionOfOpenSites);
		this.stddev = StdStats.stddev(percolationFractionOfOpenSites);
		double confidenceInterval = (1.96 * this.stddev) / Math.sqrt(trials);
		this.confidenceLo = mean - confidenceInterval;
		this.confidenceHi = mean + confidenceInterval;
	}

	/**
	 * 
	 * @return sample mean of percolation threshold
	 */
	public double mean() {
		return this.mean;
	}

	/**
	 * 
	 * @return sample standard deviation of percolation threshold
	 */
	public double stddev() {
		return this.stddev;
	}

	/**
	 * 
	 * @return low endpoint of 95% confidence interval
	 */
	public double confidenceLo() {
		return this.confidenceLo;
	}

	/**
	 * @return high endpoint of 95% confidence interval
	 */
	public double confidenceHi() {
		return this.confidenceHi;
	}

	private double[] percolationFractionOfOpenSites;
	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;

}

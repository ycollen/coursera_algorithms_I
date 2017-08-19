
import org.junit.Test;

public class PercolationStatsUnitTest {

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionForNegativeN() {
		PercolationStats a = new PercolationStats(-1, 10);
		a.mean();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionForNegativeTrials() {
		PercolationStats a = new PercolationStats(10, -1);
		a.mean();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionForZeroN() {
		PercolationStats a = new PercolationStats(0, 10);
		a.mean();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionForZeroTrials() {
		PercolationStats a = new PercolationStats(10, 0);
		a.mean();
	}

}

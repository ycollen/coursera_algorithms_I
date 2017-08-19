import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
//import edu.princeton.cs.algs4.StdIn;

public class PercolationIsFullUnitTest {

	String folder = new String("testdata/");

	@Test
	public void testUnit3() throws IOException {
		// construct the percolation by reading input file
		try (BufferedReader br = new BufferedReader(new FileReader(folder + "input3.txt"))) {
			String line;
			int i = 0;
			Percolation myPercolation = null;
			// for each line, open the required site
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (i == 0) {
					// create percolation object whose size is given on first line
					myPercolation = new Percolation(Integer.parseInt(line));
					i++;
				} else if (line.length() > 0) {
					// not first line -> site to be opened, so open it
					String row = line.substring(1, 2);
					String col = line.substring(3, 4);
					myPercolation.open(Integer.parseInt(row), Integer.parseInt(col));
				}
			}
			assertEquals("(1, 1) is not open, error!!!", true, myPercolation.isOpen(1, 1));
			assertEquals("Number of open sites is not correct. Should be 6", 6, myPercolation.numberOfOpenSites());
			// Test that (1,1) is a full site
			assertEquals("(1,1) is not recognised as a full site, error!!!", true, myPercolation.isFull(1, 1));
			// Test that (1,2) is not a full site
			assertEquals("(1,2) is recognised as a full site, error!!!", false, myPercolation.isFull(1, 2));
			// Test that (1,3) is a full site
			assertEquals("(1,1) is not recognised as a full site, error!!!", true, myPercolation.isFull(1, 3));
			// Test that (2,1) is a full site
			assertEquals("(2,1) is  not recognised as a full site, error!!!", true, myPercolation.isFull(2, 1));
			// Test that (2,2) is not a full site
			assertEquals("(2,2) is recognised as a full site, error!!!", false, myPercolation.isFull(2, 2));
			// Test that (3,2) is not full site
			assertEquals("(3,2) is recognised as a full site, error!!!", false, myPercolation.isFull(3, 2));

		} catch (Exception e) {
			System.err.println("error " + e.getMessage() + " " + e.getClass());
		}
	}

}

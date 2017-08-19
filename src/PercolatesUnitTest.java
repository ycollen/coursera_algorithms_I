import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.omg.CORBA.portable.InputStream;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class PercolatesUnitTest {

	String folder = new String("testdata/");

	private Percolation readFile(String fileName) throws IOException {
		In stream = new In(new File(folder + fileName));
		int size = stream.readInt();
		Percolation myPercolation = new Percolation(size);
		while(!stream.isEmpty())
		{
			int row = stream.readInt();
			int col = stream.readInt();
			System.out.println("row: " + row + " col: " + col);
			myPercolation.open(row, col);
		}
		return myPercolation;
	}
	
	@Test
	public void testUnit1No() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("input1-no.txt");
		assertEquals("unit 1-no should not percolate ", false, myPercolation.percolates());
	}

	@Test
	public void testUnit1() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("input1.txt");
		assertEquals("unit 1 should percolate ", true, myPercolation.percolates());
	}
	
	@Test
	public void testUnit3() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("input3.txt");
		assertEquals("unit 3 should percolate ", true, myPercolation.percolates());
	}
	
	@Test
	public void testUnit4() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("input4.txt");
		assertEquals("Unit 4 should percolate ", true, myPercolation.percolates());
	}
	
	@Test
	public void testUnit5() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("input5.txt");
		assertEquals("Unit 5 should percolate ", true, myPercolation.percolates());
	}
	
	
	@Test
	public void testHeart25() throws IOException{
		// construct the percolation by reading input file
		Percolation myPercolation = this.readFile("heart25.txt");
		assertEquals("heart25 should not percolate ", false, myPercolation.percolates());
	}
	
	@Test
	public void testUnit10() throws IOException{
		Percolation myPercolation = this.readFile("input10.txt");
		assertEquals("(9,1) is not a full site", false, myPercolation.isFull(9, 1));
	}
}

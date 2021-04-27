import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class TransposeMatrixTests {

	final private Solution solution = new Solution();
	Random rnd = new Random();
	
	@Test
    void emptyMatrix() {
		int[] ref=new int[0];
		int[] matrix=new int[0];
		solution.transpose(matrix, 0, 0);
        assertTrue(Arrays.equals(matrix, ref));
		solution.transpose(matrix, 0, 10);
        assertTrue(Arrays.equals(matrix, ref));
		solution.transpose(matrix, 10, 0);
        assertTrue(Arrays.equals(matrix, ref));
    }
	
	@Test
	void singleRowCol() {
		int[] ref = new int[] {0, 1, 2, 3, 4};
		int[] matrix = new int[] {0, 1, 2, 3, 4};
		solution.transpose(matrix, 1, 5);
        assertTrue(Arrays.equals(matrix, ref));
		solution.transpose(matrix, 5, 1);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[4], 4);
	}
	
	@Test
	void singleNumber() {
		int[] ref = new int[] {10};
		int[] matrix = new int[] {10};
		solution.transpose(matrix, 1, 1);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 10);
	}
	
	@Test
	void squareMatrix2x2() {
		int[] ref = new int[] {0, 1, 2, 3};
		int[] matrix = new int[] {0, 2, 1, 3};
		solution.transpose(matrix, 2, 2);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[3], 3);
	}
	
	@Test
	void squareMatrix3x3() {
		int[] ref = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		int[] matrix = new int[] {0, 3, 6, 1, 4, 7, 2, 5, 8};
		solution.transpose(matrix, 3, 3);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[8], 8);
	}
	
	@Test
	void rectMatrix3x4() {
		int[] ref = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		int[] matrix = new int[] {0, 4, 8, 1, 5, 9, 2, 6, 10, 3, 7, 11};
		solution.transpose(matrix, 4, 3);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[11], 11);
	}
	
	@Test
	void rectMatrix3x7() {
		int[] ref = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[] matrix = new int[] {0, 7, 14,
				                  1, 8, 15,
				                  2, 9, 16, 
				                  3, 10, 17,
				                  4, 11, 18,
				                  5, 12, 19,
				                  6, 13, 20};
		solution.transpose(matrix, 7, 3);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[20], 20);
	}
	
	@Test
	void rectNegMatrix3x7() {
		int[] ref = new int[] {0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12, -13, -14, -15, -16, -17, -18, -19, -20};
		int[] matrix = new int[] {0, -7, -14,
				                  -1, -8, -15,
				                  -2, -9, -16, 
				                  -3, -10, -17,
				                  -4, -11, -18,
				                  -5, -12, -19,
				                  -6, -13, -20};
		solution.transpose(matrix, 7, 3);
        assertTrue(Arrays.equals(matrix, ref));
        assertEquals(matrix[0], 0);
        assertEquals(matrix[20], -20);
	}
	
	@Test
	void randomMatrix() {
		int nRows = rnd.nextInt(100);
		int nCols = rnd.nextInt(100);
		int[] ref = new int[nRows*nCols];
		int[] matrix = new int[nRows*nCols];
		
		for (int i=0; i<nRows; i++) {
			for (int j=0; j<nCols; j++) {
				int val = rnd.nextInt(500000000) - 250000000;
				matrix[i * nCols + j] = val;
				ref[j * nRows + i] = val;
			}
		}
		solution.transpose(matrix, nRows, nCols);
        assertTrue(Arrays.equals(matrix, ref));
        // two more transpositions
        solution.transpose(matrix, nCols, nRows);
        solution.transpose(matrix, nRows, nCols);
        assertTrue(Arrays.equals(matrix, ref));
		
	}
}

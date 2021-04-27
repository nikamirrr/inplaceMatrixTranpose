public class Solution {
	
	int nextI(int nRows, int nCols, int i) {
		return ((i % nCols) * nRows) + (i / nCols);
	}
	
	// added 31st bit for positives and removed 31st bit for negatives
	int getProcessed(int value) {
		final int mask = 1 << 30;
		final int nmask = ~mask;
		if (value < 0) {
			return value & nmask;
		} else {
			return value | mask;
		}
	}
	
    public void transpose(int[] matrix, int nRows, int nCols) {
    	// 0 or 1 dimension size, the same matrix 
        if (nRows <= 1 || nCols <= 1) {
        	return;
        }
        // square matrix is easy, swap i, j data with j, i data
        if (nRows == nCols) {
        	for (int i = 1; i < nRows; i++) {
        		for (int j = 0; j < i; j++) {
        			int ind1 = i * nCols + j;
        			int ind2 = j * nCols + i;
        			int temp = matrix[ind1];
        			matrix[ind1] = matrix[ind2];
        			matrix[ind2] = temp;
        		}
        	}
        } else {
        	// non square matrix
        	
        	// use masking (bit 30) to indicate the processed numbers
    		final int mask = 1 << 30;
    		final int nmask = ~mask;
        	
    		// scan the matrix
        	for (int i = 0; i < matrix.length; i++) {
        		int curr = i;
        		int val = matrix[curr];
        		// get tne same value marked as processed
        		int procVal = getProcessed(val);
        		// found unprocessed value
        		while (val != procVal) {
        			// calculate where is moves
        			curr = nextI(nRows, nCols, curr);
        			val = matrix[curr];
        			matrix[curr] = procVal;
        			// get tne same value marked as processed
        			procVal = getProcessed(val);
        		}
        	}
        	
        	// remove the bit marks from every value in the matrix
        	for (int i = 0; i < matrix.length; i++) {
        		if (matrix[i] < 0) {
        			matrix[i] |= mask;
        		} else {
        			matrix[i] &= nmask;
        		}
        	}
        }
    }
}
package bp;

public class MatrixPrintSpiralForm {
	public static void main(String[] args) {
		int[][] m = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		}; 
		
		//printSpiralMatrix(m.length, m[0].length, m);
		//printDiagnoalMatrix(m.length, m);
		printMatrixDiagonally(m);
	}

	private static void printDiagnoalMatrix(int length, int[][] mat) {
		// n - size 
        // mode - switch to derive up/down traversal 
        // it - iterator count - increases until it 
        // reaches n and then decreases 
        int n = length , mode = 0, it = 0, lower = 0; 
  
        // 2n will be the number of iterations 
        for (int t = 0; t < (2 * n - 1); t++) { 
            int t1 = t; 
            if (t1 >= n) { 
                mode++; 
                t1 = n - 1; 
                //it--; 
                lower++; 
            } 
            else { 
                lower = 0; 
                //it++; 
            } 
            for (int i = t1; i >= lower; i--) { 
                if ((t1 + mode) % 2 == 0) { 
                    System.out.println(mat[i][t1 + lower - i]); 
                } 
                else { 
                    System.out.println(mat[t1 + lower - i][i]); 
                } 
            } 
        } 
	}

	private static void printSpiralMatrix(int m, int n, int[][] mat) {
		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n -1;
		
		while(top <= bottom && left <= right) {
			//Print Top Row
			for(int i = left ; i <= right ; i++) {
				System.out.println(mat[top][i]);
			}
			top++;
			
			//Print Right column top to bottom
			for(int i = top ; i <= bottom ; i++) {
				System.out.println(mat[i][right]);
			}
			right--;
			
			
			//Print bottom row right to left
			if(top <= bottom) {
				for(int i = right ; i >= left ; i--) {
					System.out.println(mat[bottom][i]);
				}
				bottom--;
			}
			
			
			//Print left column from bottom to top
			if(left <= right) {
				for(int i = bottom ; i >= top ; i--) {
					System.out.println(mat[i][left]);
				}
				left++;
			}
			
			
		}
	}
	
    public static void printMatrixDiagonally(int[][] matrix) {
    	
    	int[][] m = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
        int row, col;
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        for (int k = 0; k < rowCount; k++) {
            for (row = k, col = 0; row >= 0 && col < columnCount; row--, col++) {
                System.out.print(matrix[row][col] + " " );
            }
            System.out.println();
        }

        for (int k = 1; k < columnCount; k++) {
            for (row = rowCount - 1, col = k; row >= 0 && col < columnCount; row--, col++) {
                System.out.print(matrix[row][col] + " " );
            }
            System.out.println();
        }
    }
}

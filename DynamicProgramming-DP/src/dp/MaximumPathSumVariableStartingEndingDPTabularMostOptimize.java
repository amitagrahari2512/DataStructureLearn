package dp;

import java.util.Arrays;

/**
 * 
 * Problem statement
You have been given an N*M matrix filled with integer numbers, find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.

From a cell in a row, you can move to another cell directly below that row, or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.

Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50
1 <= N <= 100
1 <= M <= 100
-10^4 <= matrix[i][j] <= 10^4

Where 'T' is the number of test cases.
Where 'N' is the number of rows in the given matrix, and 'M' is the number of columns in the given matrix.
And, matrix[i][j] denotes the value at (i,j) cell in the matrix.

Time Limit: 1sec
Input 1 :
2
4 4
1 2 10 4
100 3 2 1
1 1 20 2
1 2 2 1
3 3
10 2 3
3 7 2
8 1 5
Output 1 :
105
25
Explanation Of Input 1 :
In the first test case for the given matrix,

The maximum path sum will be 2->100->1->2, So the sum is 105(2+100+1+2).

In the second test case for the given matrix, the maximum path sum will be 10->7->8, So the sum is 25(10+7+8).
Input 2 :
2
3 3
1 2 3
9 8 7
4 5 6
4 6
10 10 2 -13 20 4
1 -9 -81 30 2 5
0 10 4 -79 2 -10
1 -5 2 20 -11 4
Output 2 :
17
74
Explanation Of Input 2 :
In the first test case for the given matrix, the maximum path sum will be 3->8->6, So the sum is 17(3+8+6).

In the second test case for the given matrix, the maximum path sum will be 20->30->4->20, So the sum is 74(20+30+4+20).
 *
 */

public class MaximumPathSumVariableStartingEndingDPTabularMostOptimize {
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 10, 4},
				{100, 3, 2, 1},
				{1, 1, 20, 2},
				{1, 2, 2, 1}
		};
		
		int m = arr.length;
		int n = arr[0].length;
		
		int[][] dp = new int[m][n];
		Arrays.stream(dp).forEach(a->Arrays.fill(a, -1));
		
		MaximumPathSumVariableStartingEndingDPTabularMostOptimize p = new MaximumPathSumVariableStartingEndingDPTabularMostOptimize();
		System.out.println("MaxPathvariableStartEnd " + p.maxPathvariableStartEnd(arr));
		
	}
	
	public int maxPathvariableStartEnd(int[][] arr) {
		
		int m = arr.length;
		int n = arr[0].length;
		
		int[] prev = new int[n];
		
		for(int i = 0 ;i < n; i++) {
			prev[i] = arr[0][i];
		}
		
		for(int i = 1 ; i < m; i++) {
			int[] curr = new int[n];
			for(int j = 0 ; j < n; j++) {
				int up = arr[i][j] + prev[j];
				
				int leftDiagnol = arr[i][j];
				if(j > 0 ) 
				{
					leftDiagnol+= prev[j-1];
				}
				else {
					leftDiagnol+= (int)Math.pow(-10, 9);
				}
				
				int rightDiagnol = arr[i][j];
				if(j < n-1 ) {
					rightDiagnol+= prev[j+1];
				}
				else {
					rightDiagnol+= (int)Math.pow(-10, 9);
				}
				
				curr[j] = Math.max(up, Math.max(leftDiagnol, rightDiagnol));
			}
			
			prev = curr;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			max = Math.max(max, prev[i]);
		}
		
		return max;
	}
}

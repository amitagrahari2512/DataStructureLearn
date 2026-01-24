package recurssion;

/**
 * 
 * Problem statement
Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns. Each point in the grid has some cost associated with it.



Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1) which minimizes the sum of the cost of all the numbers along the path. You need to tell the minimum sum of that path.



Note:
You can only move down or right at any point in time.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 100   
1 <= N, M <= 10^2
1 <= GRID[i][j] <= 10^5

Where 'GRID[i][j]' denotes the value of the cell in the matrix.

Time limit: 1 sec
Sample Input 1:
2
2 3
5 9 6
11 5 2
1 1
5
Sample Output 1:
21
5
Explanation For Sample Output 1:
In test case 1, Consider a grid of 2*3:

For this the grid the path with minimum value is (0,0) -> (0,1) -> (1,1) -> (1,2). And the sum along this path is 5 + 9 +5 + 2 = 21. So the ans is 21.

In test case 2, The given grid is:

For this the grid the path with minimum value is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2).The sum along this path is 1 + 2 + 3 + 4 + 9 = 19.
Sample Input 2:
2
2 2
5 6
1 2
3 3
1 2 3
4 5 4
7 5 9
Sample Output 2:
8
19
Explanation For Sample Output 2:
In test case 1, For this the grid the path with minimum value is (0,0) -> (1,0) -> (1,1). The sum along this path is 5 + 1 + 2 = 8.
 *
 */

public class MinPathSumRecurssion {
	public static void main(String[] args) {
		
		  int[][] arr = { 
				  {1,2,3}, 
				  {4,5,4}, 
				  {7,5,9} 
				 };
		
		int m = arr.length;
		int n = arr[0].length;
		
		MinPathSumRecurssion min = new MinPathSumRecurssion();
		System.out.println("Min Path Value : " + min.minPathSum(arr, m-1, n-1));
		
	}
	
	public int minPathSum(int[][] arr, int i, int j) {
		if(i == 0 && j == 0) return arr[i][j];
		if(i < 0 || j < 0) return (int) Math.pow(10, 9);
		
		int up = arr[i][j] + minPathSum(arr, i-1, j);
		int left = arr[i][j] + minPathSum(arr, i, j-1);
		
		
		return Math.min(up, left);
		
	}
	
	
}

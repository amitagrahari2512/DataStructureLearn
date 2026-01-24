package ebay;

/*
 * The problem is similar, 
 * but now movement is in four directions: up, down, left, right. 
 * We need to count paths from (0,0) to (n,m) through 1s only.
 */

public class FindAllPathInFourDirection {
	
	static int row, col; 

	public static void main(String[] args) {
		 int[][] fort = {
				 {1, 0, 0, 0}, 
                 {1, 1, 0, 1}, 
                 {1, 1, 0, 0}, 
                 {0, 1, 1, 1}}; //2 paths exist
		 int[][] fort1= {
				 {1, 0, 0, 0,0 }, 
                 {1, 0, 1, 1,1}, 
                 {1, 1, 1, 0,1}, 
                 {0, 0, 0, 0,1},
                 {0, 0, 0, 0,1}};
                 
		 int[][] fort2=  {
				 {1, 0, 1, 1, 1,1 }, 
                 {1, 0, 1, 0, 0,1},
                 {1, 0, 1, 1, 0,1}, 
                 {1, 0, 0, 1, 0,1},
                 {1, 1, 1, 1, 0,1}, 
                 {0, 0, 0, 0, 0,1}};
		 
		 int[][] fort3=  {
				 {1, 0, 1, 1, 1,1 }, 
                 {1, 0, 1, 0, 0,1},
                 {1, 0, 1, 0, 0,1}, 
                 {1, 0, 0, 1, 0,1},
                 {1, 1, 1, 1, 0,1}, 
                 {0, 0, 0, 0, 0,1}};
		 
		 System.out.println("Path for fort : " + findPath(fort));
		 System.out.println("Path for fort1 : " + findPath(fort1));
		 System.out.println("Path for fort2 : " + findPath(fort2));
		 System.out.println("Path for fort3 : " + findPath(fort3));
		 
	}
	
	public static int findPath(int[][] fort) {
		row = fort.length;
		col = fort[0].length;
		
		if(fort[0][0] == 0 || fort[row-1][col-1] == 0)
			return 0;
		
		boolean[][] visited = new boolean[row][col];
		return dfs(0, 0, fort, visited);
		
	}
	
	public static int dfs(int i, int j, int[][] fort, boolean[][] visited) {
		
		if(i == row-1 && j == col-1)
			return 1;
		
		if(i < 0 || i >= row || j < 0 || j >= col || fort[i][j] == 0 || visited[i][j])
			return 0;
		
		visited[i][j] = true;
		int way = 0;
		way+=dfs(i+1, j, fort, visited); //down
		way+=dfs(i, j+1, fort, visited); //right
		way+=dfs(i-1, j, fort, visited); //up
		way+=dfs(i, j-1, fort, visited); //left
		
		visited[i][j] = false;//backtrace
		
		return way;
		
	}

}

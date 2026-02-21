package dp;

public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = {
		                        {'1','1','1','1','0'},
		                        {'1','1','0','1','0'},
		                        {'1','1','0','0','0'},
		                        {'0','0','0','0','0'}
						};
		
		System.out.println(numIslands(grid));
		
		char[][] grid1 = {
				  {'1','1','0','0','0'},
				  {'1','1','0','0','0'},
				  {'0','0','1','0','0'},
				  {'0','0','0','1','1'}
				};
		
		System.out.println(numIslands(grid1));
	}
	
	public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // boundary check
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;

        // mark visited
        grid[i][j] = '0';

        // explore 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}

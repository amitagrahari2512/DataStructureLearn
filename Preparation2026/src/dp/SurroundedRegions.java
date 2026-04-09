package dp;

import java.util.Arrays;

public class SurroundedRegions {
	
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		
		System.out.println(Arrays.deepToString(board));
	}
	
	
	public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // 1 Mark boundary-connected O's
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);       // left boundary
            dfs(board, i, n - 1);   // right boundary
        }

        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);       // top boundary
            dfs(board, m - 1, j);   // bottom boundary
        }

        // 2 Convert surrounded O -> X, and T -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }
	
	 private static void dfs(char[][] board, int i, int j) {

	        int m = board.length;
	        int n = board[0].length;

	        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O')
	            return;

	        board[i][j] = 'T';

	        dfs(board, i + 1, j);
	        dfs(board, i - 1, j);
	        dfs(board, i, j + 1);
	        dfs(board, i, j - 1);
	    }
}

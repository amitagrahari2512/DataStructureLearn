package dp;

import java.util.Arrays;

public class LongestCommonSubstringDp {
	 public static void main(String[] str) {
		 	String s= "horse";
			String t ="ros";
			int  m = s.length();
			int n = t.length();
			int dp[][] = new int[m][n];
			Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
			int lcs = lcs(s,t,dp,m-1,n-1);
			System.out.println("Longest common Substring : " + lcs);
	    }
		public static int lcs(String s, String t,int[][] dp, int i, int j) {
			if( i < 0 || j < 0) return 0;
			if(dp[i][j] != -1) return dp[i][j];
			if(s.charAt(i) == t.charAt(j)) return dp[i][j] = 1 + lcs(s,t, dp, i-1 , j-1);
	
			return dp[i][j] = 0 + Math.max(lcs(s, t, dp, i-1 , j) , lcs(s, t, dp, i , j-1));
		 }
}


package dp;

import java.util.Arrays;

/**
 * 
 * In how many ways can you reach the top if you can take 1 or 2 steps?
 *
 */
public class ClimbingStairs {

	
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println("Recurssion Way");
		System.out.println(climbStairs(n));
		
		System.out.println("*********************************");
		
		System.out.println("Top To bottom Approach - Memorization Way");
		int[] dp = new int[n  + 1];
		Arrays.fill(dp, -1);
		System.out.println(climbStairsTopDownMemorization(n, dp));
		
		System.out.println("*********************************");
		
		System.out.println("Bottom UP Approach");
		System.out.println(climbStairsBottomUp(n));
		
		System.out.println("*********************************");
		
		System.out.println("Space Optimized Approach");
		System.out.println(speceOptimizedApproach(n));
	}
	
	public static int climbStairs(int n) {
		if(n == 0 || n == 1)
			return 1;
		
		return climbStairs(n-1) + climbStairs(n-2);
	}
	
	public static int climbStairsTopDownMemorization(int n, int[] dp) {
		if(n == 0 || n == 1)
			return 1;
		
		if(dp[n] != -1)
			return dp[n];
		
		
		return dp[n] = climbStairsTopDownMemorization(n-1, dp) + climbStairsTopDownMemorization(n-2 , dp);
	}
	
	public static int climbStairsBottomUp(int n) {
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2 ; i <= n ;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		
		return dp[n];
	}

	public static int speceOptimizedApproach(int n) {
		int prev1 = 1;
		int prev2 = 1;
		
		for(int i = 2 ; i <= n ;i++) {
			int curr = prev1 + prev2;
			prev2 = prev1;
			prev1 = curr;
		}
		
		
		return prev1;
	}
}

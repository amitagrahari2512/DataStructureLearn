package dp;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElementsDPTabular {

	public static void main(String[] args) {
		int[] arr = {2, 1,4, 9};
		int n = arr.length;
		
		MaximumSumOfNonAdjacentElementsDPTabular m = new MaximumSumOfNonAdjacentElementsDPTabular();
		System.out.println("Max non adjacent sum : " + m.maxSum(arr));
	}
	
	public int maxSum(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		
		dp[0] = arr[0];
		int negative = 0;
		
		for(int  i = 1 ;i < n ;i++) {
			int pick = arr[i] ; //Pick = arr[i] + dp[i-2] *** //Because we can not pick adjacent // Suppose this is even index
			if(i > 1) pick += dp[i - 2]; //*** But as their is a chances i< 1 so we need to add condition, else we get stackoverflow exception
			
			int notPick = 0 + dp[i - 1]; // Suppose this is odd index
			
			dp[i] = Math.max(pick, notPick);
		}
		
		return dp[n-1];
	}

}

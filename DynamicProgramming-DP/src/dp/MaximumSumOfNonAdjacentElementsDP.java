package dp;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElementsDP {

	public static void main(String[] args) {
		int[] arr = {2, 1,4, 9};
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		MaximumSumOfNonAdjacentElementsDP m = new MaximumSumOfNonAdjacentElementsDP();
		System.out.println("Max non adjacent sum : " + m.maxSum(arr, n-1, dp));
	}
	
	public int maxSum(int[] arr, int index, int[] dp) {
		
		if(index == 0) return arr[index];
		if(index < 0) return 0;
		
		if(dp[index] != -1) return dp[index];
		
		int pick = arr[index] + maxSum(arr, index - 2, dp); //Because we can not pick adjacent // Suppose this is even index
		int notPick = 0 + maxSum(arr, index - 1, dp); // Suppose this is odd index
		
		return dp[index] = Math.max(pick, notPick);
	}

}

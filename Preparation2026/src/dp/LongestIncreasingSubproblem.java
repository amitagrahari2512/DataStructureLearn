package dp;

import java.util.Arrays;

public class LongestIncreasingSubproblem {

	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,7,101,18};
		
		int n = arr.length;
		System.out.println("Lis From Recurssions : " + lisRecurssion(arr, 0, -1));
		
		System.out.println("*************************************");
		
		//As we have index [-1], but in java we don't have index [-1], So we do coordinate shift and pick length as n+1, for dp array;
		int[][] dp = new int[n+1][n+1];
		Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
		System.out.println("Lis From Top To Bottom : " + lisTopToBottom(arr, dp, 0, -1));
	}
	
	public static int lisRecurssion(int[] arr, int i, int prev_i) {
		if(i == arr.length - 1) return 0;
		
		int notTake = 0 + lisRecurssion(arr, i + 1, prev_i);
		int take = Integer.MIN_VALUE;
		if(prev_i == -1 || (arr[i] > arr[prev_i])) {
			take = 1 + lisRecurssion(arr, i + 1, i);
		}
		
		int length = Math.max(notTake, take);
		return length;
	}
	
	public static int lisTopToBottom(int[] arr, int[][] dp, int i, int prev_i) {
		if(i == arr.length - 1) return 0;
		if(dp[i][prev_i+1] != -1) return dp[i][prev_i+1];
		
		int notTake = 0 + lisTopToBottom(arr, dp, i + 1, prev_i);
		int take = Integer.MIN_VALUE;
		if(prev_i == -1 || (arr[i] > arr[prev_i])) {
			take = 1 + lisTopToBottom(arr,dp, i + 1, i);
		}
		
		int length = Math.max(notTake, take);
		return dp[i][prev_i+1] = length;
	}
	
}

package dp;

import java.util.Arrays;

/*
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 */

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] stairsCost = {1,100,1,1,1,100,1,1,100,1};
		//int[] stairsCost  = {10,15,20};
		int n = stairsCost.length;
		
		System.out.println("Min Stair climb through Recurssion : " + minCostClimbingStairsRecursion(stairsCost, n - 1));
		
		System.out.println("*********************************");
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println("Min Stair climb Top To Bottom Approach : " + minCostClimbingStairsTopToBottomApproach(stairsCost, dp, n - 1));
		
		
		System.out.println("*********************************");
		System.out.println("Min Stair climb Bottom Up Approach : " + minCostClimbingStairsBottomUpApproach(stairsCost));
		
		
		System.out.println("*********************************");
		System.out.println("Min Stair climb Space Optimize Approach : " + minCostClimbingStairsSpaceOptimizedApproach(stairsCost));
	}
	
	public static int minCostClimbingStairsRecursion(int[] stairsCost, int i) {
		if(i == 0) return stairsCost[i];
		
		int one = stairsCost[i-1] + minCostClimbingStairsRecursion(stairsCost, i-1);
		int two = Integer.MAX_VALUE;
		if(i > 1) {
			two = stairsCost[i-2] + minCostClimbingStairsRecursion(stairsCost, i-2);
		}
		
		return Math.min(one, two);
			
	}
	
	public static int minCostClimbingStairsTopToBottomApproach(int[] stairsCost, int[] dp, int i) {
		if(i == 0) return stairsCost[i];
		if(dp[i] != -1) return dp[i];
		int one = stairsCost[i-1] + minCostClimbingStairsTopToBottomApproach(stairsCost, dp, i-1);
		int two = Integer.MAX_VALUE;
		if(i > 1) {
			two = stairsCost[i-2] + minCostClimbingStairsTopToBottomApproach(stairsCost, dp, i-2);
		}
		
		return dp[i] = Math.min(one, two);
	}
	
	public static int minCostClimbingStairsBottomUpApproach(int[] stairsCost) {
		int n = stairsCost.length;
		
	    if (n == 0) return 0;
	    if (n == 1) return stairsCost[0];
	    
		int[] dp = new int[n];
		
		dp[0] = stairsCost[0];
		dp[1] = stairsCost[1];
		
		for(int i = 2 ;i < n ;i++) {
			dp[i] = stairsCost[i] + Math.min(dp[i-1], dp[i-2]);
		}
		return Math.min(dp[n-1], dp[n-2]);
	}
	
	public static int minCostClimbingStairsSpaceOptimizedApproach(int[] stairsCost) {
		int n = stairsCost.length;
		if (n == 0) return 0;
		if (n == 1) return stairsCost[0];
		    
		int prev2 = stairsCost[0];
		int prev = stairsCost[1];
		
		for(int i = 2 ;i <n ; i++ ) {
			int curr = stairsCost[i] + Math.min(prev2 ,  prev);
			prev2 = prev;
			prev = curr;
		}
		return Math.min(prev2, prev);
	}

	
	
	

}

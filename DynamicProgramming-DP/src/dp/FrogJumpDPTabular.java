package dp;

import java.util.Arrays;

import recurssion.FrogJumpRecurssion;

/*
 * Given an integer array height[] where height[i] represents the height of the i-th stair, 
 * a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: 
 * it can either jump to the (i+1)-th stair or the (i+2)-th stair. T
 * he cost of a jump is the absolute difference in height between the two stairs. 
 * The task is to find the minimum total cost required for the frog to reach the top.
 */
public class FrogJumpDPTabular {

	public static void main(String[] args) {
		int[] arr = {20, 30, 40, 20};
		
		//int[] arr = {30, 20, 50, 10, 40}; 
		FrogJumpDPTabular d = new FrogJumpDPTabular();
		int jump = d.frogJump(arr);
		System.out.println("Jump required : " + jump);
	}

	public int frogJump(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 0;
		
		for(int i = 1 ; i < n; i++) {
			int first = dp[i-1] + Math.abs(arr[i] - arr[i-1]);
			
			int second = Integer.MAX_VALUE;
			if(i > 1) {
				second = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
			}
			
			dp[i] = Math.min(first, second);
		}
		
		return dp[n-1];
		
 	}
}

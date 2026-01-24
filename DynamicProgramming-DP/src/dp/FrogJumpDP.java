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
public class FrogJumpDP {

	public static void main(String[] args) {
		//int[] arr = {20, 30, 40, 20};
		
		int[] arr = {30, 20, 50, 10, 40}; 
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		FrogJumpDP d = new FrogJumpDP();
		int jump = d.frogJump(arr , n - 1, dp);
		System.out.println("Jump required : " + jump);
	}

	public int frogJump(int[] arr , int index, int[] dp) {
		if(index == 0) return 0;
		
		if(dp[index] != -1) return dp[index];
		
		int left = frogJump(arr, index - 1, dp) + Math.abs(arr[index] - arr[index-1]);
		
		int right = Integer.MAX_VALUE;
		if(index > 1) {
			 right = frogJump(arr, index - 2, dp) + Math.abs(arr[index] - arr[index-2]);
		}
		
		return dp[index] = Math.min(left, right);
 	}
}

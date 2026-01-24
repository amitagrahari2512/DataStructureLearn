package dp;

import java.util.Arrays;

import recurssion.FrogJumpRecurssion;

/*
 * Given an integer array height[] where height[i] represents the height of the i-th stair, 
 * a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: 
 * the frog is allowed to jump up to ‘K’ steps at a time.
 * The cost of a jump is the absolute difference in height between the two stairs. 
 * The task is to find the minimum total cost required for the frog to reach the top.
 */
public class FrogJumpKthIndexDP {

	public static void main(String[] args) {
		//int[] arr = {20, 30, 40, 20};
		
		int[] arr = {30, 10, 60, 10, 60, 50 }; 
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		int k = 2;
		FrogJumpKthIndexDP d = new FrogJumpKthIndexDP();
		int jump = d.frogJump(arr , n - 1, k, dp);
		System.out.println("Jump required : " + jump);
	}

	public int frogJump(int[] arr , int index, int k, int[] dp) {
		int  n = arr.length;
		if(index == 0) return 0;
		
		if(dp[index] != -1) return dp[index];

		int minJump = Integer.MAX_VALUE;
		
		for(int i = 1 ;i <= k ;i++) {
			
			if(index - i >= 0) {
				int jump = frogJump(arr, index -i, k, dp) + Math.abs(arr[index] - arr[index-i]);
				minJump = Math.min(minJump, jump);
			}
			
		}		
		return dp[index] = minJump;
 	}
}

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
public class FrogJumpKthIndexDPTabular {

	public static void main(String[] args) {
		//int[] arr = {20, 30, 40, 20};
		
		int[] arr = {30, 10, 60, 10, 60, 50 }; 
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		int k = 2;
		FrogJumpKthIndexDPTabular d = new FrogJumpKthIndexDPTabular();
		int jump = d.frogJump(arr, k, dp);
		System.out.println("Jump required : " + jump);
	}

	/**
	 * @param arr
	 * @param k
	 * @param dp
	 * @return
	 */
	public int frogJump(int[] arr ,int k, int[] dp) {
		int  n = arr.length;
		dp[0] = 0;
		
		for(int i = 1 ; i < n ; i++) {
			int minJump = Integer.MAX_VALUE;
			for(int j = 1 ;j <= k ;j++) {
				
				if(i - j >= 0) {
					int jump = dp[i - j] + Math.abs(arr[i] - arr[i-j]);
					minJump = Math.min(minJump, jump);
				}
				
				dp[i] = minJump;
			}
		}
		
		
		return dp[n-1];
 	}
}

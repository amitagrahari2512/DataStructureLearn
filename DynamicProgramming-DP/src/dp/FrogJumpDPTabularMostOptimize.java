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
public class FrogJumpDPTabularMostOptimize {

	public static void main(String[] args) {
		//int[] arr = {20, 30, 40, 20};
		
		int[] arr = {30, 20, 50, 10, 40}; 
		FrogJumpDPTabularMostOptimize d = new FrogJumpDPTabularMostOptimize();
		int jump = d.frogJump(arr);
		System.out.println("Jump required : " + jump);
	}

	public int frogJump(int[] arr) {
		int n = arr.length;
		int prev = 0;
		int prev2 = 0;
		for(int i = 1 ; i < n; i++) {
			int first = prev + Math.abs(arr[i] - arr[i-1]);
			
			int second = Integer.MAX_VALUE;
			if(i > 1) {
				second = prev2 + Math.abs(arr[i] - arr[i-2]);
			}
			
			int curr = Math.min(first, second);
			prev2 = prev;
			prev = curr;
		}
		
		return prev;
		
 	}
}

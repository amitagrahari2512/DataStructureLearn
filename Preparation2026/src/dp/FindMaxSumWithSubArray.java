package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 
 * Kadane's Algorithm
 * 
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
 */

public class FindMaxSumWithSubArray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		System.out.println(maxSubArrayWithPrintSubArrray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
		for(int  i = 0 ; i < nums.length; i++) {
			sum += nums[i];
			
			if(sum > max) {
				max = sum;
			}
			
			if(sum < 0)
			{
				sum = 0;
			}
			
		}
		return max;
    }
	
	public static int maxSubArrayWithPrintSubArrray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;
		for(int  i = 0 ; i < nums.length; i++) {
			if(sum == 0) start = i;
			
			sum += nums[i];
			
			if(sum > max) {
				max = sum;
				ansStart = start;
				ansEnd = i;
			}
			
			if(sum < 0)
			{
				sum = 0;
			}
			
		}
		
		int[] maxSubArray = IntStream.range(ansStart, ansEnd+1).map(i -> nums[i]).toArray();
		System.out.println(Arrays.toString(maxSubArray));
		
		return max;
    }

}

package dp;

/**
 * 
 * You are a professional robber planning to rob houses along a street. But those house is in circle form.
 * So first and last house is adjacent to each other.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1,2]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 *
 */

//This problem is same like MaximumSumOfNonAdjacentElementsDPTabularMostOptimize.java problem
//Only change is first and last element are adjacent as this is in circle.

public class HouseRobberDPTabularMostOptimize {

	public static void main(String[] args) {
		//int[] arr = {1,2,3,1};
		int[] arr = {2,7,9,3,1, 2};
		HouseRobberDPTabularMostOptimize h = new HouseRobberDPTabularMostOptimize();
		System.out.println("Maximum Money steal by Robber : " + h.robber(arr));
	}
	
	public int robber(int[] arr) {
		int n = arr.length;
		int[] arrRemoveFirst = new int[n-1];
		int[] arrRemoveLast = new int[n-1];
		
		int indexForArrRemoveFirst = 0;
		int indexForArrRemoveLast = 0;
		for(int i = 0 ; i < n; i++) {
			if(i != 0) arrRemoveFirst[indexForArrRemoveFirst++] = arr[i];
			if(i != n -1) arrRemoveLast[indexForArrRemoveLast++] = arr[i];
		}
		
		
		return Math.max(maxSum(arrRemoveFirst), maxSum(arrRemoveLast));
	}

	public int maxSum(int[] arr) {
		int n = arr.length;
		int prev = arr[0];
		int prev2 = 0;
		
		for(int  i = 1 ;i < n ; i++) {
			int pick = arr[i];
			if(i > 1) pick += prev2;
			int notPick = 0 + prev;
			int curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;
		}
		
		return prev;
	}
}

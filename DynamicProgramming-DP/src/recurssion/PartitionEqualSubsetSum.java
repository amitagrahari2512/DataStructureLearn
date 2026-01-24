package recurssion;

import java.util.Arrays;

/**
 * 
 * Problem statement
You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.

For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

Follow Up:

Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= 'T' <= 10
1 <= 'N' <= 100 
1 <= 'ARR'[i] <= 100

Time Limit: 1 sec
Sample Input 1:
2
6
3 1 1 2 2 1
5
5 6 5 11 6
Sample Output 1:
true
false    
Explanation Of Sample Input 1:
For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.

For the second test case, the array can’t be partitioned.
Sample Input 2:
2
9
2 2 1 1 1 1 1 3 3
6
8 7 6 12 4 5
Sample Output 2:
false
true
 *
 */
public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		//int[] arr = {1,2,3,5};
		PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
		System.out.println("PartitionEqualSubsetSum present : " +s.canPartition(arr) );
	}
	
	
	public boolean canPartition(int[] arr) {
		int n = arr.length;
		int sum = Arrays.stream(arr).sum();
		if(sum % 2 != 0)
			return false;//As fraction sum can  not be devide arr ay in two parts.
		
		int target = sum / 2;
		
		PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
		return s.canPartition(arr, n-1, target);
		
	}
	public boolean canPartition(int[] arr, int i, int target) {
		if(target == 0) return true;
		if(i == 0) return arr[0] == target;
		
		boolean notTake = canPartition(arr, i-1, target);
		boolean take = false;
		if(arr[i] <= target) take = canPartition(arr, i - 1, target - arr[i]);
		
		return take || notTake;
	}
}

package dp;

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
public class PartitionEqualSubsetSumDpTabularMostOptimize {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		//int[] arr = {1,2,3,5};
		PartitionEqualSubsetSumDpTabularMostOptimize s = new PartitionEqualSubsetSumDpTabularMostOptimize();
		System.out.println("PartitionEqualSubsetSumDpTabularMostOptimize present : " +s.canPartition(arr) );
	}
	
	
	public boolean canPartition(int[] arr) {
		int n = arr.length;
		int sum = Arrays.stream(arr).sum();
		if(sum % 2 != 0)
			return false;//As fraction sum can  not be devide arr ay in two parts.
		
		int target = sum / 2;
		
		PartitionEqualSubsetSumDpTabularMostOptimize s = new PartitionEqualSubsetSumDpTabularMostOptimize();
		return s.canPartition(arr, target);
		
	}
	public boolean canPartition(int[] arr, int target) {
		int n = arr.length;
		boolean[] prev = new boolean[target+1];
		
		prev[0] =  true;
		if(arr[0] <= target) prev[arr[0]] = true;
		
		for(int ind = 1; ind < n ;ind++) {
			boolean[] curr = new boolean[target+1];
			curr[0] = true;
			for(int tar = 1 ; tar <= target; tar++) {
				boolean notTake = prev[tar];
				boolean take = false;
				if(arr[ind] <= tar) take = prev[tar - arr[ind]];
				curr[tar] = (take || notTake);
			}
			prev = curr;
		}
		return prev[target];
	}
}

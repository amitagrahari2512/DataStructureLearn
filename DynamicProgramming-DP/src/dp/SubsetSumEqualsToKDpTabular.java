package dp;

import java.util.Arrays;

/**
 * 
 * Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1:
2
4 5
4 3 2 1
5 4
2 5 1 6 7
Sample Output 1:
true
false
Explanation For Sample Input 1:
In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
Sample Input 2:
2
4 4
6 1 2 1
5 6
1 7 2 9 10
Sample Output 2:
true
false
Explanation For Sample Input 2:
In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.


Hints:
1. Can you find every possible subset of ‘ARR’ and check if its sum is equal to ‘K’?
2. Can you use dynamic programming and use the previously calculated result to calculate the new result?
3. Try to use a recursive approach followed by memoization by including both index and sum we can form. 
 *
 */
public class SubsetSumEqualsToKDpTabular {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		int target = 4;
		
		
		SubsetSumEqualsToKDpTabular s = new SubsetSumEqualsToKDpTabular();
		System.out.println("SubsetSumEqualsToK present : " +s.subset(arr, n-1, target) );
	}
	
	public boolean subset(int[] arr, int n, int target) {
		boolean[][] dp = new boolean[n][target+1];
		
		for(int i = 0 ; i < n ;i++) {
			dp[i][0] = true;
		}
		
		dp[0][arr[0]] = true;
		
		for(int ind = 1; ind < n ;ind++) {
			for(int tar = 1 ; tar <= target; tar++) {
				boolean notTake = dp[ind-1][tar];
				boolean take = false;
				if(arr[ind] <= tar) take = dp[ind-1][tar - arr[ind]];
				dp[ind][tar] = (take || notTake);
			}
		}
		return dp[n-1][target];
	}

}

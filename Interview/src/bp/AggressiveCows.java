package bp;

import java.util.Arrays;

/*
 You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.


Example 1:
Input Format:
 N = 6, k = 4, arr[] = {0,3,4,7,10,9}
Result:
 3
Explanation:
 The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

Example 2:
Input Format:
 N = 5, k = 2, arr[] = {4,2,1,3,6}
Result:
 5
Explanation:
 The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}. 

Why do we need to sort the stalls?

To arrange the cows in a consecutive manner while ensuring a certain distance between them, the initial step is to sort the stalls based on their positions. In a sorted array, the minimum distance will always be obtained from any two consecutive cows. Arranging the cows in a consecutive manner does not necessarily mean placing them in consecutive stalls.

Assume the given stalls array is: {1,2,8,4,9} and after sorting it will be {1, 2, 4, 8, 9}. The given number of cows is 3.
 */

public class AggressiveCows {
	public static void main(String[] args) {
		int[] stall = {0,3,4,7,10,9};
		int cowsToBePlaced = 4;
		
		int maxDistance = aggresiveCows(stall, stall.length, cowsToBePlaced);
		System.out.println(maxDistance);
	}

	private static int aggresiveCows(int[] stall, int n,  int cows) {
		Arrays.sort(stall);
		int low = 0;
		int high = stall[n -1] - stall[0];
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(canWePlace(stall, mid, cows) == true) {
				low = mid + 1; 
			}
			else
			{
				high = mid - 1;
			}
		}
		
		return high;
	}
	private static boolean canWePlace(int[] stall, int dist, int cows) {
		int last = stall[0];
		int countCow = 1;
		for(int i = 1;i < stall.length ; i++) {
			if(stall[i] - last >= dist) {
				countCow++;
				last = stall[i];
			}
		}
		
		if(countCow >= cows) {
			return true;
		}
		
		return false;
	}
}

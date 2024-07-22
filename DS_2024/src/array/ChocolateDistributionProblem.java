package array;

import java.util.Arrays;

/*
 * 
 * Given an array of N integers where each value represents the number of chocolates in a packet. 
 * Each packet can have a variable number of chocolates. There are m students, 
 * the task is to distribute chocolate packets such that: 

Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and 
the packet with minimum chocolates given to the students is minimum.
 * 
 * Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 
by choosing following M packets :{3, 4, 9, 7, 9}.
 * 
 * 
 * 
 * 
 * Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 
by choosing following M packets :{3, 2, 4}.


 */
public class ChocolateDistributionProblem {
	public static void main(String[] args) {
		int[] arr = {7, 3, 2, 4, 9, 12, 56}; 
		int m = 3;
		System.out.println(findMin(arr, m));
		
		int[] arr1 = {3, 4, 1, 9, 56, 7, 9, 12};
		int m1 = 5;
		System.out.println(findMin(arr1, m1));
		
		int[] arr2 = {7, 3, 2, 4, 9, 12, 56};
		int m2 = 3;
		System.out.println(findMin(arr2, m2));
		
	}

	private static int findMin(int[] arr, int m) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		
		for(int i = 0 ; i < arr.length - m - 1 ; i++) {
			int diff = arr[i + m -1] - arr[i];
			
			if(diff < min) {
				min = diff;
			}
		}
		return min;
	}
}

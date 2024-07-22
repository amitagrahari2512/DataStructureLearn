package array;

import java.util.HashMap;

/*
 * 
 * Given an array of N integers, and an integer K, 
 * find the number of pairs of elements in the array whose sum is equal to K.
 * 
 * 
 * Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6.


Input:
N = 4, K = 2
arr[] = {1, 1, 1, 1}
Output: 6
Explanation: 
Each 1 will produce sum 2 with any 1.
 * 
 */
public class CountPairOfSumInArray {

	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 1};
		System.out.println("Count pair sum : " + countPairSum(arr, arr.length, 6));
		int[] arr1 = {1, 1, 1, 1};
		System.out.println("Count pair sum : " + countPairSum(arr1, arr1.length, 2));
		
	}
	
	public static int countPairSum(int[] arr, int n, int sum) {
		int count = 0 ;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0 ; i < n; i++) {
			if(map.containsKey(sum - arr[i])) {
				count += map.get(sum - arr[i]);
			}
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			else {
				map.put(arr[i], 1);
			}
		}
		return count;
	}

}

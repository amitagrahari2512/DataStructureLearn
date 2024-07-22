package array;

import java.util.HashSet;

/*
 * Given an array arr of size n and an integer x. Find if there's a triplet in the array which sums up to the given integer x.

Examples

Input:n = 6, x = 13, arr[] = [1,4,45,6,10,8]
Output: 1
Explanation: The triplet {1, 4, 8} in the array sums up to 13.
Input: n = 5, x = 10, arr[] = [1,2,4,3,6,7]
Output: 1
Explanation: Triplets {1,3,6} & {1,2,7} in the array sum to 10. 
Input: n = 6, x = 24, arr[] = [40,20,10,3,6,7]
Output: 0
Explanation: There is no triplet with sum 24. 
 * 
 */
public class FindSumWithTriplet {
	public static void main(String[] args) {
		int sum = 13;
		int arr[] = {1,4,45,6,10,8};
		int size = arr.length;
		
		findTripletSum(arr, size, sum);
	}

	private static void findTripletSum(int[] arr, int size, int sum) {
		
		for(int i = 0 ; i < size - 2 ; i++) {
			HashSet<Integer> hs = new HashSet<>();
			
			int currentSum = sum - arr[i];
			
			for(int j = i + 1 ; j < size ; j++) {
				int requiredSum = currentSum - arr[j];
				
				if(hs.contains(requiredSum)) {
					System.out.println("Triplets Are :: " + arr[i] + "," + arr[j] + "," + requiredSum);
					return;
				}
				
				hs.add(arr[j]);
			}
			
		}
		
		System.out.println("No Triplet Found");
		
	}
}

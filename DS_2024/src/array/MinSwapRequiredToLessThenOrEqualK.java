package array;

/**
 * 
 * Minimum swaps required to bring all elements less than or equal to k together
 * 
 * Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
Output: 1
Explanation: 
To bring elements 2, 1, 3 together, swap element ‘5’ with ‘3’ such that final array will be arr[] = {2, 1, 3, 6, 5}

Input:  arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
Output: 2
 *
 */
public class MinSwapRequiredToLessThenOrEqualK {

	public static void main(String[] args) {
		int arr[] = {2, 1, 5, 6, 3};
	    int n = arr.length;
	    int k = 3;
	    System.out.print(minSwap(arr, n, k) + "\n");
	 
	    int arr1[] = {2, 7, 9, 5, 8, 7, 4};
	    n = arr1.length;
	    k = 5;
	    System.out.print(minSwap(arr1, n, k));
	}

	private static int minSwap(int[] arr, int n, int k) {
		int count = 0;
		int bad = 0;
		for(int i = 0 ; i < n ;i++) {
			if(arr[i] <= k)
				count++;
		}
		
		for(int i = 0 ; i < count ;i++) {
			if(arr[i] > k)
				bad++;
		}
		
		int ans = bad;
		
		for(int i = 0, j = count ; j < n ; j++ , i++) {
			
			if(arr[i] > k) 
				bad--;
			
			if(arr[j] > k)
				bad++;
			
			ans = Math.min(ans, bad);
		}
		
		
		
		return ans;
	}

	
}

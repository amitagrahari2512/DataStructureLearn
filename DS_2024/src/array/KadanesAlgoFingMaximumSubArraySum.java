package array;

public class KadanesAlgoFingMaximumSubArraySum {

	public static void main(String[] args) {
		int[] arr = {1,2,3,-2,5};
		System.out.println(maxSubarraySum(arr, arr.length));
		int[] arr1 = {-1,-2,-3,-4};
		System.out.println(maxSubarraySum(arr1, arr1.length));
		int[] arr2 = {-1,-2,-3,-4, 4, 3, 2, 1, -10, 1};
		System.out.println(maxSubarraySum(arr2, arr2.length));
	}
	
	public static long maxSubarraySum(int arr[], int n) {
		
		long max = Long.MIN_VALUE;
		long sum = 0;
		
		for(int i=0 ; i < n ;i++) {
			sum = sum + arr[i];
			if(max < sum ) {
				max = sum;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		
		return max;
	}

}

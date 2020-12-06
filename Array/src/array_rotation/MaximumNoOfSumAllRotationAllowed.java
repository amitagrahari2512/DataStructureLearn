package array_rotation;

public class MaximumNoOfSumAllRotationAllowed {

	public static void main(String[] args) {
		int[] arr = new int[] {
				8, 3, 1, 2
			};
		System.out.println("Sum : " + findSum(arr));
		System.out.println("Sum with Efficient Solution : "+findSumWithEfficientSolution(arr));
	}
	
	private static int findSum (int[] arr) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ;i<n ; i++) {
			int currSum = 0;
			for(int j = i ; j < n ;j++) {
				int index = (i + j) % n;
				currSum += j * arr[index];
			}
			max = Math.max(max, currSum);
		}
		return max;
	}
	
	private static int findSumWithEfficientSolution(int[] arr) {
		int n = arr.length;
		int cum_sum = 0;
		for(int i = 0;i < n; i++) {
			cum_sum += arr[i];
		}
		
		int curr_val = 0;
		for(int i = 0;i < n; i++) {
			curr_val += i * arr[i];
		}
		
		int max = curr_val;
		
		for(int i =1 ;i < n ; i++) {
			
			//next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] * (n-1);
			int next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] * (n-1);
			
			max = Math.max(max, next_val);
		}
		return max;
	}
	
}

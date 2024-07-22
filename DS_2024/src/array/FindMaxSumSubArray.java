package array;

public class FindMaxSumSubArray {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		
		System.out.println("Find Max sum to sub Arr : "+getSubArrayMaxSum(arr));
	}
	
	public static int getSubArrayMaxSum(int[] arr) {
		
		int max_sum = Integer.MIN_VALUE;
		int current_sum = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			current_sum = current_sum + arr[i];
			if(max_sum < current_sum) {
				max_sum = current_sum;
			}
			
			if(current_sum < 0) {
				current_sum = 0;
			}
		}
		return max_sum;
	}
}

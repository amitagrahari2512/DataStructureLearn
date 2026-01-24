package recurssion;

public class MaximumSumOfNonAdjacentElementsRecurssion {

	public static void main(String[] args) {
		int[] arr = {2, 1,4, 9};
		int n = arr.length;
		MaximumSumOfNonAdjacentElementsRecurssion m = new MaximumSumOfNonAdjacentElementsRecurssion();
		System.out.println("Max non adjacent sum : " + m.maxSum(arr, n-1));
	}
	
	public int maxSum(int[] arr, int index) {
		
		if(index == 0) return arr[index];
		if(index < 0) return 0;
		
		int pick = arr[index] + maxSum(arr, index - 2); //Because we can not pick adjacent // Suppose this is even index
		int notPick = 0 + maxSum(arr, index - 1); // Suppose this is odd index
		
		return Math.max(pick, notPick);
	}

}

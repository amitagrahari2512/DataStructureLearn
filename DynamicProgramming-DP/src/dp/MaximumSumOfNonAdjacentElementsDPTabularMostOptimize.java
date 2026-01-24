package dp;

public class MaximumSumOfNonAdjacentElementsDPTabularMostOptimize {

	public static void main(String[] args) {
		int[] arr = {2, 1,4, 9};
		int n = arr.length;
		
		MaximumSumOfNonAdjacentElementsDPTabularMostOptimize m = new MaximumSumOfNonAdjacentElementsDPTabularMostOptimize();
		System.out.println("Max non adjacent sum : " + m.maxSum(arr));
	}
	
	public int maxSum(int[] arr) {
		int n = arr.length;
		
		int prev = arr[0];
		int prev2 = 0;
		
		for(int  i = 1 ;i < n ;i++) {
			int pick = arr[i] ; //Pick = arr[i] + dp[i-2] *** //Because we can not pick adjacent // Suppose this is even index
			if(i > 1) pick += prev2; //*** But as their is a chances i< 1 so we need to add condition, else we get stackoverflow exception
			
			int notPick = 0 + prev; // Suppose this is odd index
			
			int curr = Math.max(pick, notPick);
			prev2 = prev;
			prev = curr;
		}
		
		return prev;
	}

}

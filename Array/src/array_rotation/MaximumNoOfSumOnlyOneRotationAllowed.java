package array_rotation;

public class MaximumNoOfSumOnlyOneRotationAllowed {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 20, 2, 10
			};
		System.out.println("Sum : " + findSum(arr));
	}
	
	private static int findSum (int[] arr) {
		int arrSum = 0;
		int currVal = 0;
		
		for(int i=0 ;i<arr.length; i++) {
			arrSum = arrSum + arr[i];
			currVal = currVal + (i * arr[i]);
		}
		
		int maxSum = currVal;
		
		for(int i = 1 ;i<arr.length ; i++) {
			currVal = currVal + arrSum - arr.length * arr[arr.length - i];
			
			if(currVal > maxSum)
				maxSum = currVal;
		}
		
		return maxSum;
	}
	
}

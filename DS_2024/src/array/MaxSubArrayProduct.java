package array;

public class MaxSubArrayProduct {
	public static void main(String[] args) {
		int[] arr = {6, -3, -10, 0, 2};
		System.out.println(findMaxSubArrayProduct(arr));
	}

	private static long findMaxSubArrayProduct(int[] arr) {
		long result = Long.MIN_VALUE;
		long leftToRightProduct = 1;
		long rightToLeftProduct = 1;
		
		for(int i = 0 ;i < arr.length ; i++) {
			if(leftToRightProduct == 0) leftToRightProduct = 1;
			
			if(rightToLeftProduct == 0) rightToLeftProduct = 1;
			
			leftToRightProduct *= arr[i];
			rightToLeftProduct *= arr[(arr.length - 1) - i];
			
			result = Math.max(Math.max(leftToRightProduct, rightToLeftProduct), result);
			
		}
		
		return result;
		
	}
}

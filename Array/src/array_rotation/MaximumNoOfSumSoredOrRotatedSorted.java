package array_rotation;

public class MaximumNoOfSumSoredOrRotatedSorted {

	public static void main(String[] args) {
		int[] arr = new int[] {
					//2, 3, 4, 1
					8, 3, 1, 2
			};
		int pivot = findPivot(arr);
		System.out.println(pivot);
		System.out.println("Sum : " +maxSum(arr, pivot));
	}
	
	
	private static int findPivot(int[] arr) {
		int n = arr.length;
		for(int i=0 ;i<n ; i++) {
			if(arr[i] > arr[(i + 1) % n]) {
				return i;
			}
		}
		return 0;
	}
	
	private static int maxSum(int[] arr, int pivot) {
		int n = arr.length;
		int sum = 0;
		int diff = n-1-pivot;
		for(int i=0 ;i<n ; i++) {
			sum = sum + ((i + diff) % n) * arr[i];
		}
		return sum;
	}
	
	
}

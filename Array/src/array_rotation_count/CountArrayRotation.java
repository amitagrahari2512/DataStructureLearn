package array_rotation_count;

public class CountArrayRotation {

	public static void main(String[] args) {
		int[] arr = new int[] {
				//2, 3, 4, 1
				8,9, 3, 1, 2
		};
		System.out.println("Rotation Count Via Linear Search : " + countRotationByLinearSearch(arr));
		System.out.println("Rotation Count Via Binary Search : " + countRotationByBinarySearch(arr, 0 , arr.length));
		
	}
	
	private static int countRotationByLinearSearch(int[] arr) {
		int n = arr.length;
		int minVal = arr[0];
		int minIndex = -1;
		
		for (int i = 0; i < arr.length; i++) {
			if(minVal > arr[i]) {
				minVal = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private static int countRotationByBinarySearch(int[] arr, int low, int high) {
		if(low > high)
			return -1;
		
		if(high == low)
			return low;
		
		int mid = (low + high)/2;
		
		if(mid < high && arr[mid + 1] < arr[mid]) 
			return mid + 1;
		
		if(mid > low && arr[mid] < arr[mid - 1])
			return mid;
		
		if(arr[high] > arr[mid])
			return countRotationByBinarySearch(arr, low, mid-1);
		
		return countRotationByBinarySearch(arr, mid+1, high);
	}
}

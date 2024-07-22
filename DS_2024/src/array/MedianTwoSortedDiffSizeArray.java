package array;

//Tutorial 
//https://www.youtube.com/watch?v=F9c7LpRZWVQ

public class MedianTwoSortedDiffSizeArray {

	public static void main(String[] args) {
		int arr1[] = {1, 3, 4, 7, 10, 12};
		int arr2[] = {2, 3, 6, 15};
		System.out.println("Median for medianTwoSortedDiffSizeArray Even Size: " + medianTwoSortedDiffSizeArray(arr1, arr2));
		
		int arr3[] = {2, 4};
		int arr4[] = {1, 3, 4};
		
		System.out.println("Median for medianTwoSortedDiffSizeArray Odd Size: " + medianTwoSortedDiffSizeArray(arr3, arr4));
	}

	private static double medianTwoSortedDiffSizeArray(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		//We want left side array always be a small size
		if(n1 > n2 ) 
			return medianTwoSortedDiffSizeArray(arr2, arr1);
		
		int low = 0;
		int high = n1;
		int left = (n1 + n2 + 1)/2;
		int n = n1 + n2;
		while(low <= high) {
			int mid1 = (low + high) / 2;
			int mid2 = left - mid1;
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			
			if(mid1 < n1) r1 = arr1[mid1];
			if(mid2 < n2) r2 = arr2[mid2];
			if(mid1 - 1 >= 0) l1 = arr1[mid1 -1];
			if(mid2 - 1 >= 0) l1 = arr2[mid2 -1];
			
			if(l1 <= r2 && l2 <= r1) {
				if(n % 2 == 1)
					return Math.max(l1, l2);
				else
					return (Math.max(l1, l2) + Math.min(r1, r2))/2;
			}
			else if(l1 < r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0;
	}

}

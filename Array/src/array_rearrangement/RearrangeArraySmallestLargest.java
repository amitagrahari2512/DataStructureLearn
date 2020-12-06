package array_rearrangement;

import java.util.Arrays;

public class RearrangeArraySmallestLargest {
	public static void main(String[] args) {
		int[]  arr = {
				1, 3, 2, 2, 5	
			};
		
		rearrange(arr);
	}
	
	public static void rearrange(int[]  arr) {
		int n = arr.length;
		int[] tempArr = new int[n];
		int tempIndex = 0 ;
		Arrays.sort(arr);
		
		for (int i = 0, j = n-1; i <= n/2 || j > n/2; i++, j--) {
			if(tempIndex < n) {
				tempArr[tempIndex] = arr[i];
				tempIndex++;
			}
			
			if(tempIndex < n) {
				tempArr[tempIndex] = arr[j];
				tempIndex++;
			}
		}
		
		System.out.println(Arrays.toString(tempArr));
		
	}
}

package array_rearrangement;

import java.util.Arrays;

public class ArrangeEvenPosLessThanOddPos {
	public static void main(String[] args) {
		int arr[] = { 6, 4, 2, 1, 8, 3 }; 
		rearrangeArray(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void rearrangeArray(int[] arr) {
		int n = arr.length;
		int temp = 0;
		
		for (int i = 0; i < n-1; i++) {
			if((i%2 == 0) && (arr[i] > arr[i+1])) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
			
			if((i%2 != 0) && (arr[i] < arr[i+1])) {
				temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
	}
}

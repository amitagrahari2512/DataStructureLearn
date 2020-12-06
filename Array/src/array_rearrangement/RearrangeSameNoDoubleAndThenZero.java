package array_rearrangement;

import java.util.Arrays;

public class RearrangeSameNoDoubleAndThenZero {
	public static void main(String[] args) {
		int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 }; 
		
		doubleNumber(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void rearrangeZerosInEnd(int[] arr) {
		
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] != 0) {
				arr[count] = arr[i];
				count++;
			}
		}
		
		while(count < n) {
			arr[count] = 0;
			count++;
		}
		
	}
	
	private static void doubleNumber(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n-1; i++) {
			if(arr[i] != 0 && (arr[i] == arr[i+1])) {
				arr[i] = 2 * arr[i];
				
				arr[i+1] = 0;
				
				i++;
			}
		}
		
		rearrangeZerosInEnd(arr);
	}
}

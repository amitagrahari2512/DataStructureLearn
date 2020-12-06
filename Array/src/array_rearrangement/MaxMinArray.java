package array_rearrangement;

import java.util.Arrays;

public class MaxMinArray {
	public static void main(String[] args) {
		int[]  arr = {
				1,2,3,4,5,6
			};
			
		rearrangeArrayMaxMin(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void rearrangeArrayMaxMin(int[] arr) {
		int n = arr.length;
		int maxIndex = n-1;
		int minIndex = 0;
		int min = arr[minIndex];
		int max = arr[maxIndex];
		
		for (int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				arr[i] = max;
				max-=1;
			}
			else {
				arr[i] = min;
				min+=1;
			}
		}
	}
} 	

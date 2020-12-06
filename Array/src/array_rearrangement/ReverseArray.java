package array_rearrangement;

import java.util.Arrays;

public class ReverseArray {
	
	public static void main(String[] args) {
		int[] arr = {
				1,2,3,4,5
		};
		
		int[] arr1 = {
				6,7,8,9,10
		};
		reverseArr(arr);
		System.out.println("Reverse array simple : "+Arrays.toString(arr));
		reverseUsingRecurssion(arr1, 0, arr1.length-1);
		System.out.println("Reverse array using recurssion : "+Arrays.toString(arr1));
		
	}

	public static void reverseArr(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		
		if(start>=end)
			return;
		
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void reverseUsingRecurssion(int[] arr, int start, int end) {
			if(start>=end)
			return;
	
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		
			reverseUsingRecurssion(arr, start, end);
	}
}

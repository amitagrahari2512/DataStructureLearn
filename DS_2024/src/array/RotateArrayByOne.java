package array;

import java.util.Arrays;

public class RotateArrayByOne {
	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 2, 3, 6};
		
		System.out.println("Original Array : "+ Arrays.toString(arr));
		System.out.println("Rotate Array : "+ Arrays.toString(rotateArray(arr)));
	}

	private static int[] rotateArray(int[] arr) {
		int lastElement = arr[arr.length - 1];
		for(int i = arr.length - 1 ; i > 0 ; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = lastElement;
		
		return arr;
	}
}

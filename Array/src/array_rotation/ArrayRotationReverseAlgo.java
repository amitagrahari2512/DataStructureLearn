package array_rotation;

import java.util.Arrays;

public class ArrayRotationReverseAlgo {
	public static void main(String[] args) {
		int rotateNo = 5;
		int[] arr = new int[] {
				1,2,3,4,5,6,7,8,9,10,11,12
		};
		reverseRotation(arr, 0, rotateNo-1);
		reverseRotation(arr, rotateNo, arr.length-1);
		reverseRotation(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void reverseRotation(int[] arr, int start, int end) {
		int temp;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	
	}
	
}

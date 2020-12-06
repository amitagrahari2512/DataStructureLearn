package array_rotation;

import java.util.Arrays;

public class ArrayRotationWithTempArray {

	public static void main(String[] args) {
		int rotateNo = 1;
		int[] arr = new int[] {
				1,2,3,4,5,6,7,8,9,10
		};
		
		arrayRotation(arr, rotateNo);
	}
	
	private static void arrayRotation(int[] arr, int rotateNo) {
		int[] tempArr = new int[rotateNo];
		for (int i = 0; i < rotateNo; i++) {
			tempArr[i] = arr[0];
			for(int j = 0 ; j < arr.length-1 ; j++) {
				arr[j] = arr[j+1];
			}
		}
		
		for (int i = arr.length-rotateNo , j = 0; i < arr.length; i++ , j++) {
			arr[i] = tempArr[j];
		}
		System.out.println(Arrays.toString(tempArr));
		System.out.println(Arrays.toString(arr));
	}
	
	
}

package array_rotation;

import java.util.Arrays;

public class ArrayRotationWithTempVar {

	public static void main(String[] args) {
		int rotateNo = 2;
		int[] arr = new int[] {
				1,2,3,4,5,6,7,8,9,10
		};
		
		for (int i = 0; i < rotateNo; i++) {
			arrayRotation(arr);
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	private static void arrayRotation(int[] arr) {
		int temp = arr[0];
		int i = 0;
		for( ; i < arr.length-1; i++)
		{
			arr[i] = arr[i+1];
		}
		arr[i] = temp;
	}
	

}

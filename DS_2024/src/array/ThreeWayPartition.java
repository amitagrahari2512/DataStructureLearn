package array;

import java.util.Arrays;

public class ThreeWayPartition {

	public static void main(String[] args) {
		int arr[] = { 1,  14, 5,  20, 4, 2, 54,
                20, 87, 98, 3,  1, 32 };

		threeWayPartition(arr, 10, 20);
		System.out.println(Arrays.toString(arr));
	}

	private static void threeWayPartition(int[] arr, int lowVal, int highVal) {
		int start = 0;
		int end = arr.length - 1;
		
		
		for(int i = 0 ; i <= end ; ) {
			if(arr[i] < lowVal) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				
				start++;
				i++;
			} else if(arr[i] > highVal) {
				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;
			}
			else {
				i++;
			}
		}
	}

}

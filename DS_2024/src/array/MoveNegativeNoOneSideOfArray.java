package array;

import java.util.Arrays;

public class MoveNegativeNoOneSideOfArray {
	public static void main(String[] args) {
		int[] arr = {1, 2,  -4, -5, 2, -7, 3,
                2, -6, -8, -9, 3, 2,  1};
		
		System.out.println("Without move negative : "  +Arrays.toString(arr));
		System.out.println("After move negative : "  +Arrays.toString(moveNegativeOtherSide(arr)));
	}
	
	public static int[] moveNegativeOtherSide(int[] arr) {
		int low = 0;
		int high = arr.length -1 ;
		
		while(low <= high) {
			if(arr[low] <= 0) {
				low++;
			}
			else {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		return arr;
	}
}

package array;

import java.util.Arrays;

public class ArrayZeroOneTwo {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2 };
		System.out.println("Without Sort Arr : " + Arrays.toString(arr));
		System.out.println("After Sort Arr : " + Arrays.toString(sortArr(arr)));
	}
	
	public static int[] sortArr(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;
		int temp = 0;
		
		while(mid <= high) {
			switch(arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				
				low++;
				mid++;
				
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				
				high--;
				break;
			}
		}
		return arr;
	}

}

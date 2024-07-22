package array;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		//int[] arr = {1, 2, 3};
		//int[] arr = {5, 4, 3 ,2 ,1};
		int[] arr = {4, 1, 5 ,3 ,2};
		arr = nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] nextPermutation(int[] arr) {
		int index1 = Integer.MIN_VALUE;
		int index2 = Integer.MIN_VALUE;
		for(int i =  arr.length-2 ; i >=0 ;i--) {
			if(arr[i] < arr[i+1]) {
				index1 = i;
				break;
			}
		}
		
		if(index1 < 0) {
			Arrays.sort(arr);
		}
		else {
			for (int i = arr.length - 1; i >= 0 ; i--) {
				if (arr[index1] < arr[i]) {
					index2 = i;
					break;
				}
			}
			int temp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = temp;
			
			Arrays.sort(arr, index1+1, arr.length);
		}
		
		return arr;
	}

}

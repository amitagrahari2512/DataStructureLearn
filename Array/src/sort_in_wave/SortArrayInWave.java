package sort_in_wave;

import java.util.Arrays;

public class SortArrayInWave {
	public static void main(String[] args) {
		int[] arr =  {10, 5, 6, 3, 2, 20, 100, 80};
		SortArrayInWave s = new SortArrayInWave();
		arr = s.sortArray(arr);
		System.out.println("Array Sort in wave form "+ Arrays.toString(arr));
	}
	
	public int[] sortArray(int[] arr) {
		int len = arr.length;
		
		for (int i = 0; i < len; i+=2) {
			if(i > 0 && arr[i-1] > arr[i])
				swap(arr, i-1, i);
			
			if(i < len-1 && arr[i] < arr[i+1])
				swap(arr, i, i+1);
		}
		
		return arr;
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

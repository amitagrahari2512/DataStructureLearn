package sortarray012;

import java.util.Arrays;

public class SortArray012 {
	public static void main(String[] args) {
		int arr[] = {0,1,0,2,0,1,2,0};
		int len = arr.length;
		sortArray1(arr, len);
		System.out.println("Sort array : "+ Arrays.toString(arr));
		
		SortArray012 s = new SortArray012();
		int[] a = s.sortArray(arr);
		System.out.println("Sort array 1: "+ Arrays.toString(a));
	}
	
	public static void sortArray1(int[] arr, int len) {
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		
		for (i = 0; i < len; i++) {
			switch(arr[i]) {
				case 0: 
					count0++;
					break;
				case 1: 
					count1++;
					break;
				case 2: 
					count2++;
					break;
			}
		}
		
		i = 0;
		
		while(count0>0) {
			arr[i] = 0;
			i++;
			count0--;
		}
		
		while(count1>0) {
			arr[i] = 1;
			i++;
			count1--;
		}
		
		while(count2>0) {
			arr[i] = 2;
			i++;
			count2--;
		}
	}
	
	int[] sortArray(int[] input){
		int len = input.length;
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		
		for (i = 0; i < len; i++) {
			switch(input[i]) {
				case 0: 
					count0++;
					break;
				case 1: 
					count1++;
					break;
				case 2: 
					count2++;
					break;
			}
		}
		
		i = 0;
		
		while(count0>0) {
			input[i] = 0;
			i++;
			count0--;
		}
		
		while(count1>0) {
			input[i] = 1;
			i++;
			count1--;
		}
		
		while(count2>0) {
			input[i] = 2;
			i++;
			count2--;
		}
		
		return input;
	}

}

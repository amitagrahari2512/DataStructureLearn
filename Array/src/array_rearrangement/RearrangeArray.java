package array_rearrangement;

import java.util.Arrays;

/**
Given an array of n elements. 
Our task is to write a program to rearrange the array such that elements 
at even positions are greater than all elements before it and elements 
at odd positions are less than all elements before it
 */
public class RearrangeArray {
	
	public static void main(String[] args) {
		int[]  arr = {
				1,2,3,4,5,6,7	
			};
			
			rearrangeArray(arr);
			System.out.println(Arrays.toString(arr));
	}
	
	public static void rearrangeArray(int[] arr) {
		
		int n = arr.length;
		int even = n/2;
		int odd = n - even;
		
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
		}
		
		Arrays.sort(temp);
		
		int j = odd - 1;
		
		//fill odd no array position
		for (int i = 0; i < n; i+=2) {
			arr[i] = temp[j];
			j--;
		}
		
		j = odd;
		
		//fill odd no array position
		for (int i = 1; i < n; i+=2) {
			arr[i] = temp[j];
			j++;
		}
		
	}
	
}



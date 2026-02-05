package array;

import java.util.Arrays;

//Array of size n, numbers from 1..n, one missing and one duplicate.
public class FindMissingAndDuplicateNo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,7,9,10};
		findMissingDuplicateViaIndexMaking(arr);
		
	}
	
	public static void findMissingDuplicateViaIndexMaking(int[] arr) {
		int n = arr.length;
		int missing = -1;
		int duplicate = -1;
		for(int i = 0; i < n ;i++) {
			int index = Math.abs(arr[i]) -1 ;
			if(arr[index] < 0) {
				duplicate = Math.abs(arr[i]);
			}
			else {
				arr[index] = -arr[index];
			}
		}
		
		for(int i = 0; i < n ;i++) {
			if(arr[i] > 0) {
				missing = i + 1;
			}
		}
		
		System.out.println("Missing No :" + missing );
		System.out.println("Duplicate No :" + duplicate );
		
	}

}

package array_rearrangement;

import java.util.Arrays;

public class ArrangeAllZeroToEnd {
	
	public static void main(String[] args) {
		int[]  arr = {
				1,0,2,0,3,0,4,0,5,0
			};
		
		arrangeAllZeroToEnd(arr);
		System.out.println(Arrays.toString(arr));
		int[]  arr1 = {
				1,0,2,0,3,0,4,0,5,0
			};
		moveZerosToEnd(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
	public static void arrangeAllZeroToEnd(int[] arr) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		
		while(count < n) {
			arr[count++] = 0;
		}
	}
	
	static void moveZerosToEnd(int arr[]) { 
	      
		int n = arr.length;
	    // Count of non-zero elements 
	    int count = 0; 
	    int temp; 
	  
	    // Traverse the array. If arr[i] is  
	    // non-zero, then swap the element at  
	    // index 'count' with the element at  
	    // index 'i' 
	    for (int i = 0; i < n; i++) { 
		    if ((arr[i] != 0)) { 
		        temp = arr[count]; 
		        arr[count] = arr[i]; 
		        arr[i] = temp; 
		        count = count + 1; 
	    	} 
	    } 
	} 
}

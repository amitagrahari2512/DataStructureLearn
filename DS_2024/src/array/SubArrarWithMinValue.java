package array;

import java.util.Arrays;
import java.util.Collections;

public class SubArrarWithMinValue {

	public static void main(String[] args) {
		int x = 51;
		Integer[] arr = {1, 4, 45, 6, 0, 19};
		System.out.println(smallestSubWithSum(arr, x));
		Integer[] arr1 = {1, 10, 5, 2, 7};
		x = 100;
		System.out.println(smallestSubWithSum(arr1, x));
	}
	
	public static int smallestSubWithSum(Integer[] arr, int x) {
	   int n = arr.length;
       int start = 0 ;
       int end = 0;
       int currentSum = 0;
       int minLen = n + 1;
       
       while(end < n) {
	       while(currentSum <= x && end < n) {
	    	   currentSum += arr[end++];
	       }
	       
	       while(currentSum > x && start < n)  {
	    	   if(end - start < minLen) {
	    		   minLen = end - start;
	    	   }
	    	
	    	   currentSum -= arr[start++];
	       }
       }
       
       return minLen == n + 1 ? 0 : minLen;
    }
	
}

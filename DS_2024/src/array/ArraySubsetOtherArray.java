package array;

import java.util.HashMap;

/*
 * 
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m, where both arrays may contain duplicate elements. The task is to determine whether array a2 is a subset of array a1. It's important to note that both arrays can be sorted or unsorted. Additionally, each occurrence of a duplicate element within an array is considered as a separate element of the set.

Example 1:

Input:
a1[] = {11, 7, 1, 13, 21, 3, 7, 3}
a2[] = {11, 3, 7, 1, 7}
Output:
Yes
Explanation:
a2[] is a subset of a1[]
 */
public class ArraySubsetOtherArray {

	public static void main(String[] args) {
		//long a1[] = {11, 7, 1, 13, 21, 3, 7, 3};
		//long a2[] = {11, 3, 7, 1, 7};
		
		long a1[] = {10, 5, 2, 23, 19};
		long a2[] = {19, 5, 3};

		
		System.out.println(isSubset(a1, a2, a1.length, a2.length));
		
	}
	
	public static String isSubset( long a1[], long a2[], long n, long m) {
        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0 ;i < a1.length; i ++) {
        	if(map.containsKey(a1[i])) {
        		map.put(a1[i], map.get(a1[i]) + 1);
        	}
        	else {
        		map.put(a1[i], 1L);
        	}
        }
        
        for(int i = 0; i <a2.length; i++) {
        	if(map.containsKey(a2[i]) && map.get(a2[i]) > 0) {
        		map.put(a2[i], map.get(a2[i])-1);
        	}
        	else {
        		return "No";
        	}
        }
        return "Yes";
    }

}

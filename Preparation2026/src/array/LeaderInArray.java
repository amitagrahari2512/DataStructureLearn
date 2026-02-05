package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 
 Given an array arr[] of size n, the task is to find all the Leaders in the array. 
 An element is a Leader if it is greater than or equal to all the elements to its right side.
Note: The rightmost element is always a leader.
 */

public class LeaderInArray {

	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		List<Integer> leaders = findLeaders(arr);
		System.out.println("Leaders List  :: " + leaders);
	}

	private static List<Integer> findLeaders(int[] arr) {
		List<Integer> leaders = new ArrayList<>();
		int n = arr.length;
		int maxVal = arr[n-1];
		leaders.add(maxVal);
		for(int i = n - 2; i >=0; i--) {
			if(arr[i] > maxVal) {
				maxVal = arr[i];
				leaders.add(maxVal);
				
			}
		}
		
		Collections.reverse(leaders);
		return leaders;
	}

}

package array_rearrangement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayRearrangementHashSet {
	public static void main(String[] args) {
		int[] arr = {
				-1, -1, 6, 1, 9, 3, 2, -1, 4,-1
		};
		
		fixPositionHashSet(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void fixPositionHashSet(int[] arr) {
		Set<Integer> set = new HashSet<>();	
		
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(set.contains(i)) {
				arr[i] = i;
			}
			else {
				arr[i] = -1;
			}
		}
	}
	
}

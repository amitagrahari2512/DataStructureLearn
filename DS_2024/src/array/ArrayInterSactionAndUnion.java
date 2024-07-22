package array;

import java.util.HashSet;
import java.util.Set;

public class ArrayInterSactionAndUnion {
	public static void main(String[] args) {
		int[] arr1 = {7, 1, 5, 2, 3, 6};
        int[] arr2 = {3, 8, 6, 20, 7};
        
        System.out.println("Union : " + arrUnion(arr1, arr2));
        System.out.println("InterSaction : " + arrInterSaction(arr1, arr2));
	}

	private static Set<Integer> arrUnion(int[] arr1, int[] arr2) {
		HashSet<Integer> union = new HashSet<>();
		for(int i : arr1) {
			union.add(i);
		}
		
		for(int i : arr2) {
			union.add(i);
		}
		
		return union;
		
	}

	private static Set<Integer> arrInterSaction(int[] arr1, int[] arr2) {
		HashSet<Integer> intersaction = new HashSet<>();
		HashSet<Integer> inter = new HashSet<>();
		for(int i : arr1) {
			intersaction.add(i);
		}
		
		for(int i : arr2) {
			boolean b = intersaction.contains(i);
			if(b) {
				inter.add(i);
			}
		}
		
		return inter;
	}
}

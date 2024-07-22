package array;

import java.util.Arrays;
import java.util.List;

public class FindDuplicateInArray {
	 public static int findDuplicate(List<Integer> arr) {
	        int i = 0;
	        while (true) {
	            // Traverse arr[ele] and mark the respective visited indices as negative
	            // If you find an element as marked negative, return the index
	            i = Math.abs(arr.get(i));
	            if (arr.get(i) < 0) {
	                return i;
	            }
	            arr.set(i, -1 * arr.get(i)); // Otherwise, keep on traversing until you find one
	        }
	    }

	    public static void main(String[] args) {
	        List<Integer> arr = Arrays.asList(2, 1, 3, 3);
	        System.out.println(findDuplicate(arr));
	    }
}

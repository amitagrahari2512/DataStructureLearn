package array;

import java.util.ArrayList;
import java.util.List;


//Find Duplicates in array as in range
public class FindDuplicatesInArray {
	
	    public static List<Integer> findDuplicates(int[] arr) {
	    	List<Integer> list = new ArrayList<>();
	    	for(int i = 0 ; i < arr.length ; i++) {
	    		int idx = Math.abs(arr[i]) - 1;
	    		
	    		if(arr[idx] < 0) {
	    			list.add(Math.abs(arr[i]));
	    		}
	    		else {
	    			arr[idx] = -arr[idx];
	    		}
	    	}
	        return list;
	    }

	    public static void main(String[] args) {
	        
	        int[] arr = {3, 4, 5, 5, 1};
	        List<Integer> res = findDuplicates(arr);
	        System.out.println(res);
	    }

}

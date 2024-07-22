package array;

import java.util.HashSet;

public class SumOfSubArrayZero {

	public static void main(String[] args) {
		int[] arr = {1, 4, -2, -2, 5, -4, 3};
		System.out.println(sumSubArrayZero(arr));
	}
	
	public static boolean sumSubArrayZero(int[] arr) {
		int sum = 0;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i =0 ;i < arr.length ;i ++) {
			
			sum = sum + arr[i];
			
			if(arr[i] == 0 || sum == 0 || hs.contains(sum))
				return true;
			
			hs.add(sum);
		}
		return false;
	}

}

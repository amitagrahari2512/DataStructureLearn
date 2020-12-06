package array_rearrangement;

import java.util.Arrays;

public class RearrangeArrayGivenEvenPositionGreaterThanOdd {
	public static void main(String[] args) {
		int[]  arr = {
				1, 3, 2, 2, 5	
			};
			
		rearrangeArrayGivenEvenPositionGreaterThanOdd(arr);
	}
	
	public static void rearrangeArrayGivenEvenPositionGreaterThanOdd(int[] arr) {
		int n = arr.length;
		int p = 0;
		int q = n-1;
		int[] ans = new int[n];
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			if( (i + 1) % 2 == 0) {
				ans[i] = arr[q--];
			}
			else {
				ans[i] = arr[p++];
			}
		}
		
		System.out.println(Arrays.toString(ans));
	}
}

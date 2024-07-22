package array;

import java.util.Arrays;

public class MinHeightsOfArray {

	public static void main(String[] args) {
		int[] arr = { 7, 4, 8, 8, 8, 9 };
        int k = 6;
        int ans = getMinDiff(arr, arr.length, k);
        System.out.println(ans);

	}

	private static int getMinDiff(int[] arr, int length, int k) {
		
		Arrays.sort(arr);
		
		int min = arr[0];
		int max = arr[length-1];
		
		int ans = max - min;
		
		for(int i = 1 ; i < length ; i++) {
			if(arr[length-1] - k < 0)
				continue;
			
			// Minimum element when we add k to whole array
			min = Math.min(arr[0] + k, arr[i] - k);
			
			
			// Maximum element when we subtract k from whole array
			max = Math.max(arr[i-1] + k, arr[length-1] - k);
			
			ans = Math.min(ans, max - min );
		}
		
		
		return ans;
	}

}

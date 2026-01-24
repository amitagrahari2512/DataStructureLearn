package array;

import java.util.Arrays;

public class PutZeroInTheEnd {

	public static void main(String[] args) {
		int[] arr = {1,0,1,0,1,0};
		int start = 0;
		int end = arr.length-1;
		while(start < end) {
			if(arr[start] == 0) {
				if(arr[end] == 0) {
					end--;
					continue;
				}
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				end--;
			}
			start++;
		}
		System.out.println(Arrays.toString(arr));
	}

}

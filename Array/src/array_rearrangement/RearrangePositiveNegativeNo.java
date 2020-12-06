package array_rearrangement;

import java.util.Arrays;

public class RearrangePositiveNegativeNo {

	public static void main(String[] args) {
		int[]  arr = {
				-1, 2, -3, 4, 5, 6, -7, -8, -9
			};
			
			rearrangePositiveNegativeNo(arr);
			System.out.println(Arrays.toString(arr));
	}
	
	public static void rearrangePositiveNegativeNo(int[] arr) {
		int n = arr.length;
		int j = -1;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				j++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int neg = 0;
		int pos = j + 1;
		
		while(pos < n && neg < pos && arr[neg] < 0) {
			temp = arr[neg];
			arr[neg] = arr[pos];
			arr[pos] = temp;
			pos++;
			neg+=2;
		}
	}
}

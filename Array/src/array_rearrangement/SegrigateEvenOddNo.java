package array_rearrangement;

import java.util.Arrays;

public class SegrigateEvenOddNo {
	public static void main(String[] args) {
		int[] arr = {
				1, 3, 2, 4, 7, 6, 9, 10
		}; 
		
		evenOddNo(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void evenOddNo(int[] arr) {
		int n = arr.length;
		int i =-1;
		int j = 0;
		int temp = 0;
		while(j != n) {
			if((arr[j] & 1) == 0) {
				i++;
				
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				
			}
			j++;
		}
	}
}

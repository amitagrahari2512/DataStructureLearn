package array_rearrangement;

import java.util.Arrays;

public class ArrangePositiveAtEvenAndNegativeOddPosition {
	public static void main(String[] args) {
		int arr[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
		rearrange(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void rearrange(int[] arr) {
		int n = arr.length;
		
		int positive = 0;
		int negative = 1;
		int temp = 0;
		
		while (true) {
			while(positive < n && arr[positive] >= 0) {
				positive+=2;
			}
			
			while(negative < n && arr[negative] <= 0) {
				negative+=2;
			}
			
			if(positive < n && negative < n) {
				temp = arr[positive];
				arr[positive] = arr[negative];
				arr[negative] = temp;
			}
			else {
				break;
			}
		}
	}
}

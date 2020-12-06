package array_rearrangement;

import java.util.Arrays;

public class ArrayRearrangement {

	public static void main(String[] args) {
		int[] arr = {
				-1, -1, 6, 1, 9, 3, 2, -1, 4,-1
		};
		fitPosition(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void fitPosition(int[] arr) {
		for(int i=0 ;i <arr.length ; i++) {
			
			if(arr[i] != -1 && arr[i] != i) {
				int x = arr[i];
				
				while (arr[x] != -1 && arr[x] != x) {
					int y = arr[x];
					
					arr[x] = x;
					
					x = y;
				}
				
				arr[x] = x;
				
				if(arr[i] != i) {
					arr[i] = -1;
				}
			}
		}
	}

}

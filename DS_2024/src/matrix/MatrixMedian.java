package matrix;

import java.util.Arrays;

public class MatrixMedian {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		System.out.println(median(arr, arr.length, arr[0].length));
		
		int[][] arr1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
		};
		
		System.out.println(median(arr1, arr1.length, arr1[0].length));
		
		
	}
	
	 private static double median(int matrix[][], int R, int C) {
		 int[] arr = new int[R*C];
		 int x = 0;
		 for(int i = 0 ;i<R ;i++) {
			 for(int j = 0 ; j < C ; j++) {
				 arr[x] = matrix[i][j];
				 x++;
			 }
		 }
		 
		 Arrays.sort(arr);
		 
		 if(arr.length % 2 == 0) {
			 return (arr[(arr.length / 2) -1] + arr[(arr.length / 2)] )/2.0;
		 }
		 else {
			 return arr[(arr.length / 2)];
		 }
		 
	 }

}

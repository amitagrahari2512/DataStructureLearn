package matrix;

import java.util.Arrays;

public class MatrixPrintAsPerSort {

	public static void main(String[] args) {
		int[][] arr = {
				{10,20,30,40},
				{15,25,35,45},
				{27,29,37,48},
				{32, 33, 39,50}
		};
		
		System.out.println(Arrays.deepToString(sortedMatrix(arr.length, arr)));
	}
	
	public static int[][] sortedMatrix(int N, int Mat[][]) {
		int C= Mat[0].length;
		int[] arr = new int[N*C];
		 int x = 0;
		 for(int i = 0 ;i<N ;i++) {
			 for(int j = 0 ; j < C ; j++) {
				 arr[x] = Mat[i][j];
				 x++;
			 }
		 }
		 
		 Arrays.sort(arr);
		 x = 0;
		 for(int i = 0 ;i<N ;i++) {
			 for(int j = 0 ; j < C ; j++) {
				 Mat[i][j] = arr[x];
				 x++;
			 }
		 }
		 
		 return Mat;
	}

}

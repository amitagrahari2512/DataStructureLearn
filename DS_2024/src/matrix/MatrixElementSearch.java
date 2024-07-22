package matrix;

import java.util.Arrays;

public class MatrixElementSearch {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		int searchElement = 16;
		System.out.println(Arrays.deepToString(arr));
		System.out.println("Search Element : " + searchElement + " :present in array : "+ matrixElementSearch(arr, searchElement));
		
		int[][] arr1 = {
				{1,3,5,7},
				{10,11,16,20},
				{23,30,34,60}
		};
		
		
		searchElement = 17;
		System.out.println(Arrays.deepToString(arr1));
		System.out.println("Search Element : " + searchElement + " :present in array : "+ matrixElementSearch(arr1, searchElement));
		
	}

	private static boolean matrixElementSearch(int[][] arr, int searchElement) {
		
		int size = arr.length - 1;
		int arrSize = arr[0].length - 1;
		int searchArrayIndex = -1;
		
		for(int i=0 ;i <=size; i++) {
			if(arr[i][arrSize] >= searchElement) {
				searchArrayIndex = i;
				break; 
			}
		}
		
		if(searchArrayIndex != -1) {
			int[] searchArr = arr[searchArrayIndex];
			
			int low = 0;
			int high = searchArr.length - 1;
			
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if(searchArr[mid] > searchElement) {
					high = mid -1; 
				}
				else {
					low = mid + 1;
				}
				if(searchArr[mid] == searchElement)
					return true;
			}
			
		}
		
		return false;
		
	}

}

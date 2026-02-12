package array_2d;

import java.util.Arrays;

/*
 * Given a 2D array matrix where each row is sorted in ascending order from left to right 
 * and each column is sorted in ascending order from top to bottom, 
 * write an efficient algorithm to search for a specific integer target in the matrix.
 * 
 *  [ 
 *  [ 1,  4,  7, 11, 15], 
 *  [ 2,  5,  8, 12, 19], 
 *  [ 3,  6,  9, 16, 22], 
 *  [10, 13, 14, 17, 24], 
 *  [18, 21, 23, 26, 30] 
 *  ],
 * 
 * 
 * Reference Video : https://www.youtube.com/watch?v=9ZbB397jU4k&t=104s
 */
public class SearchNoInRowSoredAndColumnSortedIncreasingOrder {
	public static void main(String[] args) {
		int[][] arr = {
				 { 1,  4,  7, 11, 15}, 
				 { 2,  5,  8, 12, 19}, 
				 { 3,  6,  9, 16, 22}, 
				 {10, 13, 14, 17, 24}, 
				 {18, 21, 23, 26, 30} 
		};
		
		int target = 17;
		
		System.out.println("searchByBinaryTree - Find Target on Index : " + Arrays.toString(searchByBinaryTree(arr,target)));
		
		System.out.println("searhElementByOptimizeWay - Find Target on Index : " + Arrays.toString(searhElementByOptimizeWay(arr,target)));
	}
	
	//Time Complexity (n = row, m = col) ==  ( n * log m)
	public static int[] searchByBinaryTree(int[][] arr, int target) {
		int row = arr.length;
		
		for(int i=0; i < row ;i++) {
			int index = binarySearch(arr[i], target);
			if( index > -1) {
				return new int[] {i, index};
			}
		}
		return new int[] {-1,-1};
	}
	
	private static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == target)
				return mid;
			
			if(arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	//Time Complexity (n = row, m = col) ==  ( n + m)
	public static int[] searhElementByOptimizeWay(int[][] arr, int target) {
		int n = arr.length;
		int m = arr[0].length;
		
		int row = 0;
		int col = m - 1;
		while(row < n && col >=0 ) {
			if(arr[row][col] == target)
				return new int[] {row, col};
			
			if(arr[row][col] < target) {
				row++;
			}
			else {
				col--;
			}
		}
		return new int[] {-1, -1};
	}
}

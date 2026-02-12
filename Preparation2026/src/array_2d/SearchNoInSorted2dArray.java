package array_2d;


/*
 * Search No in sorted 2D array
 * 
 */
public class SearchNoInSorted2dArray {
	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		
		System.out.println(binarySearch(arr, 11));
	}
	
	public static boolean binarySearch(int[][] arr, int target) {
		int n = arr.length;
		int m = arr[0].length;
		
		int low = 0;
		int high = (n*m)-1;
		
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			//When we divide by column we get row index.
			int row = mid/m;
			//When we do modulo by column we get column index.
			int col = mid%m;
			
			if(arr[row][col] == target)
				return true;
			
			if(arr[row][col] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}
}

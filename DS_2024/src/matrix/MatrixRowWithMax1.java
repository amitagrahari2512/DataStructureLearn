package matrix;

//Given a binary 2D array, where each row is sorted. Find the row with the maximum number of 1s. 

public class MatrixRowWithMax1 {
	public static void main(String[] args) {
		int[][] arr = {
				{0,1,1,1},
				{0,0,1,1},
				{1,1,1,1},
				{0,0,0,0}
		};
		
		System.out.println(matrixRowWithMax1(arr));
		
	}

	private static int matrixRowWithMax1(int[][] arr) {
		int rowStartIndex = 0;
		int row = arr.length;
		int column = arr[0].length - 1;
		int maxRow = -1;
		
		while(rowStartIndex < row && column >= 0) {
			if(arr[rowStartIndex][column] == 0) {
				rowStartIndex++;
			}
			else {
				maxRow = rowStartIndex;
				column--;
			}
		}
		
		return maxRow;
	}
	
	
	
}

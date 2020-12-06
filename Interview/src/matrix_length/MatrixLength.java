package matrix_length;

public class MatrixLength {
	public static void main(String[] args) {
		
		int[][] arr = {
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},   
				{1, 1, 1, 0, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1}
			};
		int result = findMaxLength(arr);
		System.out.println(result);
	}
	
	public static int findMaxLength(int[][] arr) {
		// count = 2
		// indexMax = 2
		// i = 2
		// j = indeMax = 2
		int count = 0;
		int indexMax = 0;
		for(int i=0 ;i < arr.length ; i++) {
			int colLength = arr[i].length;
			for (int j = indexMax ;j < colLength ; j++) {
				if(arr[i][j] == 1) {
					count++;
				}
				else {
					indexMax = j;
					break;
				}
			}
			if(count == colLength) {
				return count;
			}
		}
		return count;
	}
}

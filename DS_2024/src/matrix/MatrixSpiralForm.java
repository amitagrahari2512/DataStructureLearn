package matrix;

public class MatrixSpiralForm {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		matrixSpiralForm(arr);
	}

	private static void matrixSpiralForm(int[][] arr) {
		int top = 0;
		int bottom = arr.length - 1;
		int left = 0;
		int right = arr[0].length - 1;
		
		while(top <= right && left <= right) {
			//print left to right
			for(int i = left ; i <= right ; i++) {
				System.out.println(arr[top][i]);
			}
			top++;
			
			//top to bottom
			for(int i = top ; i <= bottom ; i++) {
				System.out.println(arr[i][right]);
			}
			right--;
			
			//print right to left
			if(top <= bottom) {
				for(int i = right ; i >=left ; i--) {
					System.out.println(arr[bottom][i]);
				}
				bottom--;
			}
			
			
			//print bottom to top
			if(left <= right) {
				for(int i = bottom ; i >=top ; i--) {
					System.out.println(arr[i][left]);
				}
				left++;
			}
		}
		
	}

}

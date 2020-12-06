package array_rotation;

public class MultipleLeftArrayRotation {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 3, 5, 7, 9
		};
		
		int n = arr.length;
		
		int[] temp = new int[2*n];
		preProcess(arr, n, temp);
		
		int rotation = 2;
		leftRotation(arr, temp, n, rotation);
		
		rotation = 3;
		leftRotation(arr, temp, n, rotation);
		
		rotation = 4;
		leftRotation(arr, temp, n, rotation);
		
		rotation = 8;
		leftRotation(arr, temp, n, rotation);
	}
	
	static void preProcess(int[] arr , int n , int[] temp) {
		for (int i = 0; i < n; i++) {
			temp[i] = temp[i + n] = arr[i];
		}
	}
	
	static void leftRotation(int[] arr, int[] temp, int n, int rotation) {
		int k = rotation %  n;
		int rotateEnd = k + n;
		for (int i = k; i < rotateEnd; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
}

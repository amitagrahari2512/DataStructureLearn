package array_rotation;

public class MultipleLeftArrayRotationWithoutExtraSpace {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 3, 5, 7, 9
		};
		
		int n = arr.length;
		
		int rotation = 2;
		leftRotation(arr,  n, rotation);
		
		rotation = 3;
		leftRotation(arr,  n, rotation);
		
		rotation = 4;
		leftRotation(arr,  n, rotation);
		
		rotation = 8;
		leftRotation(arr,  n, rotation);
	}
	
	static void leftRotation(int[] arr, int n, int rotation) {
		for (int i = rotation; i < rotation + n; i++) {
			System.out.print(arr[i % n] + " ");
		}
		System.out.println();
	}

}

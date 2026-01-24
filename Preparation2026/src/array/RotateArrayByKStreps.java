package array;

import java.util.Arrays;

//input =  {1,2,3,4,5,6,7}
//output = {5,6,7,1,2,3,4}
public class RotateArrayByKStreps {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k = 3;
		int n = arr.length;
		
		
		//If rotate = k is greater than array size
		k = k%n;
		
		
		//Reverse first right side of array
		for(int i = n - k , j = n - 1 ; i < j; i++ , j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
 		}
		
		
		//Reverse  left side of array
		for (int i = 0, j = n - k - 1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		for(int i = 0 , j = n - 1; i < j ; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

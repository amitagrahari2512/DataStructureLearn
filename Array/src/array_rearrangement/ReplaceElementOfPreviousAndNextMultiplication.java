package array_rearrangement;

import java.util.Arrays;

//replace-every-array-element-by-multiplication-of-previous-and-next
public class ReplaceElementOfPreviousAndNextMultiplication {
	public static void main(String[] args) {
		int[] arr = {
			2, 3, 4, 5, 6	
		};
		replaceElement(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void replaceElement(int[] arr) {
		int n = arr.length;
		
		int prev = arr[0];
		arr[0] = arr[0] * arr[1];
		
		for (int i = 1; i < n-1; i++) {
			int curr = arr[i];
			arr[i] = prev * arr[i+1];
			prev = curr;
		}
		
		arr[n-1] = prev * arr[n-1];
	}
}

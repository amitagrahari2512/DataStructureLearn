package delete_array_smaller_value;

import java.util.Stack;

//Delete array elements which are smaller than next or become smaller
public class DeleteStackSmallerValue {
	public static void main(String[] args) {
		int n = 5, k = 2; 
        int arr[] = {20, 10, 25, 30, 40}; 
        deleteElements(arr, n, k);
	}
	
	public static void deleteElements(int[] arr, int n, int k) {
		int count = 0;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			while(!stack.isEmpty() && stack.peek() < arr[i] && count < k) {
				stack.pop();
				count++;
			}
			
			stack.push(arr[i]);
		}
		
		System.out.println(stack);
	}
}
 
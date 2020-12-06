package deleted_mid;

import java.util.Stack;

public class DeletedMid {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println(stack);
		deleteMid(stack, stack.size(), 0);
		System.out.println("After Deleting Data");
		System.out.println(stack);
	}
	
	public static void deleteMid(Stack<Integer> stack, int n, int curr) {
		if(stack.isEmpty() || curr == n) {
			return;
		}
		
		int x = stack.pop();
		
		deleteMid(stack, n, curr + 1);
		
		if(curr != n/2) {
			stack.push(x);
		}
		
	}
}

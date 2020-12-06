package reverse_stack;

import java.util.Stack;

public class ReverseStack {
	
	static Stack<Integer> stack = new Stack<>();
	
	static void reverse() {
		if(!stack.isEmpty()) {
			int data = stack.peek();
			stack.pop();
			reverse();
			
			insertInBottom(data);
		}
	}
	
	static void insertInBottom(int data) {
		if(stack.isEmpty()) {
			stack.push(data);
		}
		else {
			int dataRemove = stack.peek();
			stack.pop();
			insertInBottom(data);
			
			stack.push(dataRemove);
		}
	}
	
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("Stack");
		System.out.println(stack);
		reverse();
		
		System.out.println("After Reverse Stack");
		System.out.println(stack);
		
	}
	
	
}

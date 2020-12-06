package sort_stack;

import java.util.Stack;

public class SortStackViaRecurssion {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(30); 
		stack.push(-5); 
		stack.push(18); 
		stack.push(14); 
		stack.push(-3); 
  
        System.out.println( 
            "Stack elements before sorting: "); 
        System.out.println(stack);
  
        sortStack(stack); 
  
        System.out.println( 
            " \n\nStack elements after sorting:"); 
        System.out.println(stack);
	}
	
	static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int data = stack.pop();
			
			sortStack(stack);
			
			sortedInsert(stack, data);
		}
	}
	
	static void sortedInsert(Stack<Integer> stack, int data) {
		if(stack.isEmpty() || data > stack.peek() ) {
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		sortedInsert(stack, data);
		
		stack.push(temp);
	}
}

package sort_stack;

import java.util.Stack;

public class SortStackViaTempStack {
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
  
        Stack<Integer> sortStack = sortStack(stack); 
  
        System.out.println( 
            " \n\nStack elements after sorting:"); 
        System.out.println(sortStack);
	}
	
	static Stack<Integer> sortStack(Stack<Integer> inputStack) {
		Stack<Integer> tempStack = new Stack<>();
		
		while(!inputStack.isEmpty()) {
			int tmp = inputStack.pop();
			while(!tempStack.isEmpty() && tempStack.peek() > tmp) {
				inputStack.push(tempStack.pop());
			}
			
			tempStack.push(tmp);
		}
		
		return tempStack;
	}
}

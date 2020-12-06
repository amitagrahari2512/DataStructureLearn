package stack_via_queue1;

import java.util.LinkedList;
import java.util.Queue;

//Method 1 (By making push operation costly)
public class StackViaQueue1 {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("current size: " + stack.size()); 
        System.out.println("TOP :" + stack.top()); 
        System.out.println("POP : "+ stack.pop()); 
        
        System.out.println("TOP :" + stack.top()); 
        System.out.println("POP : "+ stack.pop()); 
        
        System.out.println("TOP :" + stack.top()); 
        System.out.println("POP : "+ stack.pop()); 
        
  
        System.out.println("current size: " + stack.size()); 
	}

}

class Stack {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	int currentSize;
	
	Stack() {
		currentSize = 0;
	}
	
	public void push(int x) {
		currentSize++;
		
		q2.add(x);
		
		while(!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
		}
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	public Integer pop() {
		if(!q1.isEmpty()) {
			currentSize--;
			return q1.remove();
		}
		return -1;	
	}
	
	public Integer top() {
		if(!q1.isEmpty()) {
			return q1.peek();
		}
		return -1;
	}
	
	public Integer size() {
		return currentSize;
	}
 }


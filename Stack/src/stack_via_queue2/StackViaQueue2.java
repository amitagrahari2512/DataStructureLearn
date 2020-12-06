package stack_via_queue2;

import java.util.LinkedList;
import java.util.Queue;

//Method 2 (By making pop operation costly)
public class StackViaQueue2 {

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
		q1.add(x);
	}
	
	public Integer pop() {
		
		if(q1.isEmpty())
			return -1;
		
		while(q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}
		
		currentSize--;
		int popVal = q1.peek();
		q1.remove();
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
		
		return popVal;
	}
	
	public Integer top() {
		if(q1.isEmpty())
			return -1;
		
		while(q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}
		
		int topVal = q1.peek();
		q1.remove();
		q2.add(topVal);
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
		
		return topVal;
	}
	
	public Integer size() {
		return currentSize;
	}
 }


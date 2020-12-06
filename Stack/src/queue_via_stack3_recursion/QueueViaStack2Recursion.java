package queue_via_stack3_recursion;

import java.util.Stack;

//Method 2 (By making deQueue operation costly)
public class QueueViaStack2Recursion {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
	}
}

class Queue {
	Stack<Integer> stack1 = new Stack<>();
	
	void enQueue(int x) {
		push(stack1, x);
	}
	
	void push(Stack<Integer> ref, int x) {
		ref.push(x);
	}
	
	int deQueue() {
		System.out.println(stack1);
		int x, res;
		if(stack1.isEmpty()) {
			System.out.println("Stack underflow");
			System.exit(0);
		}
		else if(stack1.size() == 1) {
			return pop(stack1);
		}
		else 
		{
			x = pop(stack1);
			
			res = deQueue();
			
			push(stack1, x);
			
			return res;
		}
		return 0;
	}
	
	int pop(Stack<Integer> ref) {
		if(ref.isEmpty()) {
			System.out.println("Stack underflow");
			System.exit(0);
		}
		
		return ref.pop();
	}
}


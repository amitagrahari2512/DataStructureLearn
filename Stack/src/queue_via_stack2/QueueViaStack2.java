package queue_via_stack2;

import java.util.Stack;

//Method 2 (By making deQueue operation costly)
public class QueueViaStack2 {
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
	Stack<Integer> stack2 = new Stack<>();
	
	void enQueue(int x) {
		push(stack1, x);
	}
	
	void push(Stack<Integer> ref, int x) {
		ref.push(x);
	}
	
	int deQueue() {
		
		if(stack1.isEmpty() && stack2.isEmpty()) {
			System.out.println("Stack underflow");
			System.exit(0);
		}
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				push(stack2, stack1.pop());
			}
		}
		return pop(stack2);
	}
	
	int pop(Stack<Integer> ref) {
		if(ref.isEmpty()) {
			System.out.println("Stack underflow");
			System.exit(0);
		}
		
		return ref.pop();
	}
}


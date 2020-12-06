package queue_via_stack1;

import java.util.Stack;

//Method 1 (By making enQueue operation costly)
public class QueueViaStack1 {
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
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		stack1.push(x);
		
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	int deQueue() {
		if(stack1.isEmpty()) {
			System.out.println("Stack is empty");
			System.exit(0);
		}
		int data = stack1.pop();
		return data;
	}
}

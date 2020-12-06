package stack_min2;

import java.util.Stack;

public class StackMin2 {
	public static void main(String[] args) {
		SpecialStack special = new SpecialStack();
		special.push(3);
		special.push(10);
		special.push(2);
		special.push(1);
		
		System.out.println(special.findMin());
		
		special.pop();
		System.out.println(special.findMin());
		
		special.pop();
		System.out.println(special.findMin());
	}
}

class SpecialStack extends Stack<Integer> {
	public Stack<Integer> minStack = new Stack<>();
	
	public void push(int x) {
		if(minStack.isEmpty()) {
			super.push(x);
			minStack.push(x);
		}
		else {
			super.push(x);
			int y = minStack.pop();
			minStack.push(y);
			
			if(x <= y) {
				minStack.push(x);
			}
		}
		
	}
	
	public Integer pop() {
		int x = super.pop();
		int y = minStack.pop();
		
		if(y != x)
		{
			minStack.push(y);
		}
		return x;
	}
	
	public Integer findMin() {
		int x = minStack.pop();
		minStack.push(x);
		return x;
	}
}

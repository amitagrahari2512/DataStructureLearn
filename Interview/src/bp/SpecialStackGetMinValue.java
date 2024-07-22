package bp;

import java.util.Stack;

public class SpecialStackGetMinValue {

	Stack<Integer> s;
	Integer minElement;
	
	SpecialStackGetMinValue() {
		s = new Stack<>();
	}
	
	public void push(Integer x) {
			if(s.isEmpty()) {
				s.push(x);
				minElement = x;
				System.out.println("Number Inserted: " + x);
	            return;
			}
			if(x < minElement) {
				s.push(2 * x - minElement);
				minElement = x;
			}
			else {
				s.push(x);
			}
			
	}
	
	public void pop() {
		
		if(s.isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		
		int x;
		if(!s.isEmpty()) {
			x = s.pop();
			
			 System.out.print("Top Most Element Removed: ");
			
			if(x < minElement) {
				System.out.println(minElement);
				minElement =  2 * minElement - x;
			}
			else {
				System.out.println(x);
			}
		}
		
	}
	
	public void peek() {
		
		if(s.isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		
		int x;
		if(!s.isEmpty()) {
			x = s.peek();
			
			 System.out.print("Top Most Element: ");
			
			if(x < minElement) {
				System.out.println(minElement);
			}
			else {
				System.out.println(x);
			}
		}
	}
	
	public void getMin() {
		if(s.isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		
		System.out.println("Minimum Element in the "
                + " stack is: " + minElement);
		
		
	}
	
	
	public static void main(String[] args) {
		SpecialStackGetMinValue s = new SpecialStackGetMinValue();
		s.push(3);
        s.push(5);
        s.getMin();
        s.push(2);
        s.push(1);
        s.getMin();
        s.pop();
        s.getMin();
        s.pop();
        s.peek();
	}

}

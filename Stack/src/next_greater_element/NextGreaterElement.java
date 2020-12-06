package next_greater_element;

import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		int[] arr = new int[] {4, 5, 2, 25};
		findNextGreaterElement(arr);
	}
	
	public static void findNextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			int next = arr[i];
			
			if(!stack.isEmpty()) {
				int element = stack.pop();
				
				while(element < next) {
					System.out.println(element + " - "+ next);
					if(stack.isEmpty()) {
						break;
					}
					element = stack.pop();
				}
				
				if(element > next) {
					stack.push(element);
				}
			}
			
			stack.push(next);
		}
		
		while(!stack.isEmpty()) {
			int element = stack.pop();
			int next = -1;
			System.out.println(element + " - "+ next);
		}
	}
}

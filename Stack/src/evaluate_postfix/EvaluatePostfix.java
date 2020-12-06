package evaluate_postfix;

import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {
		String postfix = "231*+9-";
		int result = evaluatePostfix(postfix);
		System.out.println("Postfix result : "+ result);
	}
	
	public static int evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			if(Character.isDigit(c)) {
				stack.push(c - '0');
			}
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();
				
				switch (c) {
					case '+':
						stack.push(val2+val1);
						break;
					case '-':
						stack.push(val2-val1);
						break;
					case '*':
						stack.push(val2*val1);
						break;
					case '/':
						stack.push(val2/val1);
						break;
					
				}
			}
		}
		return stack.pop();
	}

}

package prefix_to_infix;

import java.util.Stack;

/**
 * 
 * Algorithms

	1-Read the Prefix expression in reverse order (from right to left)
	2-If the symbol is an operand, then push it onto the Stack
	3-If the symbol is an operator, then pop two operands from the Stack
	4-Create a string by concatenating the two operands and the operator between them.
	5-string = (operand1 + operator + operand2)
	6-And push the resultant string back to Stack
	7-Repeat the above steps until end of Prefix expression.
 *
 */

public class PrefixToInfix {
	public static void main(String[] args) {
		String prefix = "*-A/BC-/AKL";
		String infix = prefixToInfix(prefix);
		System.out.println("Prefix : " + prefix);
		System.out.println("Infix  :" + infix);
	}
	
	public static boolean isOperator(char c) {
		switch(c) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				return true;
		}
		return false;
	}
	
	public static String prefixToInfix(String prefix) {
		Stack<String> stack = new Stack<>();
		for(int i = prefix.length() -1 ; i>=0 ; i--) {
			char ch = prefix.charAt(i);
			if(isOperator(ch)) {
				if(!stack.isEmpty() && stack.size() >= 2) {
					String op1 = stack.pop();
					String op2 = stack.pop();
					String str = "(" + op1 + ch + op2 + ")";
					stack.push(str);
				}
				else {
					return "Invalid";
				}
			}
			else {
				stack.push(ch + "");
			}
		}
		return stack.peek();
	}
}

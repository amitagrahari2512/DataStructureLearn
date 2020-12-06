package postfix_to_prefix;

import java.util.Stack;

/**
 * 
 * Algorithms

	1-Read the Postfix expression from left to right
	2-If the symbol is an operand, then push it onto the Stack
	3-If the symbol is an operator, then pop two operands from the Stack
	4-Create a string by concatenating the two operands and the operator before them.
	5-string = operator + operand2 + operand1
	6-And push the resultant string back to Stack
	7-Repeat the above steps until end of Prefix expression.
 *
 */

public class PostfixToPrefix {
	public static void main(String[] args) {
		String postfix = "ABC/-AK/L-*";
		String prefix = postfixToPrefix(postfix);
		System.out.println("Postfix  : " + postfix);
		System.out.println("Prefix   : " + prefix);
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
	
	public static String postfixToPrefix(String postfix) {
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i<postfix.length() ; i++) {
			char ch = postfix.charAt(i);
			if(isOperator(ch)) {
				if(!stack.isEmpty() && stack.size() >= 2) {
					String op1 = stack.pop();
					String op2 = stack.pop();
					String str = ch + op2 + op1 ;
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

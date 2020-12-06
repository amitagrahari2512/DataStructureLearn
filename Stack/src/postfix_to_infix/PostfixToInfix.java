package postfix_to_infix;

import java.util.Stack;

/**
 * 
 * Algorithm
	1.While there are input symbol left
	…1.1 Read the next symbol from the input.
	2.If the symbol is an operand
	…2.1 Push it onto the stack.
	3.Otherwise,
	…3.1 the symbol is an operator.
	…3.2 Pop the top 2 values from the stack.
	…3.3 Put the operator, with the values as arguments and form a string.
	…3.4 Push the resulted string back to stack.
	4.If there is only one value in the stack
	…4.1 That value in the stack is the desired infix string.
 *
 */

public class PostfixToInfix {
	public static void main(String[] args) {
		String postfix = "ABC/-AK/L-*";
		String infix = postfixToInfix(postfix);
		System.out.println("Postfix : " + postfix);
		System.out.println("Infix   :" + infix);
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
	
	public static String postfixToInfix(String postfix) {
		Stack<String> stack = new Stack<>();
		for(int i = 0 ; i<postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if(isOperator(ch)) {
				if(!stack.isEmpty() && stack.size() >= 2) {
					String op1 = stack.pop();
					String op2 = stack.pop();
					String str = "(" + op2 + ch + op1 + ")";
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

package balanced_paranthesis;

import java.util.Stack;

public class BalancedParanthesis {
	public static void main(String[] args) {
		String exp = "[{()}]";
		boolean isBalanced = checkBalancedParenthesis(exp);
		if(isBalanced) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not - Balanced");
		}
	}
	
	public static boolean checkBalancedParenthesis(String exp) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
				continue;
			}
			
			if (stack.isEmpty())
				return false;

			char pop = stack.pop(); 

			switch (ch) {
				case ')' :
					
	                if (pop == '{' || pop == '[') 
	                    return false; 
	                break; 
	  
	            case '}': 
	                if (pop == '(' || pop == '[') 
	                    return false; 
	                break; 
	  
	            case ']': 
	                if (pop == '(' || pop == '{') 
	                    return false; 
	                break; 
	            } 
		}
		return stack.isEmpty();
	}
}

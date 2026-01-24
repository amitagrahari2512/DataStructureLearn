package leetcode;

import java.util.Stack;

public class BasicCalculator {
	
	public static void main(String[] args) {
		System.out.println(BasicCalculator.calculate("2147483647"));
	}
	
	public static int calculate(String s) {
	       
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int number = 0;
        int ans = 0;

        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = c - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    number = number * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                ans= ans + (sign * number);
                number = 0;
                sign = 1;
            }
            else if(c == '+') {
                sign = 1;
            }
            else if(c == '-') {
                sign = -1;
            }
            else if(c == '(') {
                stack.push(ans);
                stack.push(sign);
                sign = 1;
                ans = 0;
            }
            else if(c == ')') {
                int prevSign = stack.pop();
                int prevAns = stack.pop();
                ans = prevAns + (prevSign * ans);
            }
        }
        return ans;
    }
}


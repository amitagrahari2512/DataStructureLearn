package stock_span_problem;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
	public static void main(String[] args) {
		int [] stock = new int[] { 10, 4, 5, 90, 120, 80 };
		int[] span = new int[stock.length];
		findStockSpan(stock, span);
		System.out.println(Arrays.toString(span));
	}
	
	public static void findStockSpan(int[] stock, int[] span) {
		Stack<Integer> stack = new Stack<>(); 
		span[0] = 1;
		stack.add(0);
		
		for (int i = 1; i < stock.length; i++) {
			while(!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
				stack.pop();
			}
			
			span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
			
			stack.push(i);
		}
	}
}

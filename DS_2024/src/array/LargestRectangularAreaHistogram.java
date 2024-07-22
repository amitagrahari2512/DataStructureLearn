package array;

import java.util.Stack;

//Largest Rectangular Area in a Histogram 

//Find the largest rectangular area possible in a given histogram where the 
//largest rectangle can be made of a number of contiguous bars whose heights are given in an array. 
//For simplicity, assume that all bars have the same width and the width is 1 unit. 
public class LargestRectangularAreaHistogram {

	public static void main(String[] args) {
		int[] arr = {6, 2, 5, 4, 5, 1, 6};
		System.out.println("Largest rectangular Area is : " + largerstRectangularArea(arr));
	}

	private static int largerstRectangularArea(int[] his) {
		int n = his.length;
		int max = Integer.MIN_VALUE;
		int area_with_top;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i < n) {
			if(stack.isEmpty() || his[stack.peek()] <= his[i]) {
				stack.push(i++);
			}
			else {
				int top = stack.peek();
				stack.pop();
				area_with_top = his[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if(max < area_with_top)
					max = area_with_top;
			}
		}
		
		//If rest elements in stack
		while(stack.isEmpty() == false) {
				int top = stack.peek();
				stack.pop();
				area_with_top = his[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if(max < area_with_top)
					max = area_with_top;
		}
		return max;
	}

}

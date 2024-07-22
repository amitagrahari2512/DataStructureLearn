package matrix;

import java.util.Iterator;
import java.util.Stack;

public class MatrixLargestSizeRectangle {

	public static void main(String[] args) {
		int[][] arr = {
				{0,1,1,0},
				{1,1,1,1},
				{1,1,1,1},
				{1,1,0,0}
		};
		
		System.out.println("Max rectangle Area : " + maxRectangle(arr));
		
	}
	
	private static int maxRectangle(int[][] arr) {
		int r = arr.length;
		int c = arr[0].length;
		int maxRec = histogram(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j] == 1) {
					arr[i][j] += arr[i-1][j];
				}
			}
			
			maxRec = Math.max(maxRec, histogram(arr[i]));
		}
		
		return maxRec;
	}
	
	private static int histogram(int[] his) {
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

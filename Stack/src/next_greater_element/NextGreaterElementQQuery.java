package next_greater_element;

import java.util.Stack;

public class NextGreaterElementQQuery {

	public static void main(String[] args) {
		int arr[] = {3, 4, 2, 7, 5, 8, 10, 6}; 
	   int query[] = {3, 6, 1}; 
	   int ans[] = query(arr); 
	   
	   for (int i = 0; i < query.length; i++) {
		   System.out.print(ans[query[i]] + " ");
	   }
	}
	
	public static int[] query(int arr[]) {
		int ans[] = new int[arr.length];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		int j = 0;
		
		for (int i = 1; i < arr.length; i++) {
			
			int next = arr[i];
			if(!stack.isEmpty()) {
				int element = stack.pop();
				
				while(next > element) {
					ans[j] = next;
					j++;
					if(stack.isEmpty())
						break;
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
			ans[j] = -1;
			j++;
		}
		
		return ans;
	}

}

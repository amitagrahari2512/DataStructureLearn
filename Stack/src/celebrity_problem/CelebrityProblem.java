package celebrity_problem;

import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {
		int[][] noCelibrity = new int[][] {
			{0,0,1,0},
			{0,0,1,0},
			{1,0,0,0},
			{0,0,1,0}
		};
		
		int[][] celibrity = new int[][] {
			{0,0,1,0},
			{0,0,1,0},
			{0,0,0,0},
			{0,0,1,0}
		};
		
		checkCelebrity(noCelibrity);
		checkCelebrity(celibrity);
	}
	
	public static void checkCelebrity(int[][] cell) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<cell.length ;i++) {
			stack.push(i);
		}
		
		while(stack.size() > 1) {
			int i = stack.pop();
			int j = stack.pop();
			
			if(cell[i][j] == 1) {
				//if i knows j, then i is not celebrity but j have chances to be celebrity
				stack.push(j);
			}
			else {
				//if i don't know j, means j is not celebrity, but might be i is a celebrity
				stack.push(i);
			}
		}
		
		//Last element have potential to be a celebrity 
		int pot = stack.pop();
		
		for(int i=0; i<cell.length; i++) {
			if(i != pot) {
				if(cell[i][pot] == 0 || cell[pot][i] == 1) {
					System.out.println("None Celebrity");
					return;
				}
			}
		}
		
		System.out.println("Celebrity Id is : " + pot);
	}

}

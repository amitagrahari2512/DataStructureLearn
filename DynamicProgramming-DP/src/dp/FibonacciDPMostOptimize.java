package dp;

import java.util.Arrays;

//This is more optimize solution
public class FibonacciDPMostOptimize {

	public static void main(String[] args) {
		int n = 7;
		FibonacciDPMostOptimize f = new FibonacciDPMostOptimize();
		f.fibonacci(n);
		
	}
	
	public void fibonacci(int n) {
		int prev2 = 0;
		int prev = 1;
		
		for(int i = 2 ; i <= n ;i++) {
			int curr = prev + prev2;
			prev2 = prev;
			prev = curr;
		}
		
		System.out.println("fibonacci series for : " + n + " is : " + prev);
	}	
}

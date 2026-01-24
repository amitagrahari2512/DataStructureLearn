package dp;

import java.util.Arrays;

//This is using Recurssion one concept
public class FibonacciDP {

	public static void main(String[] args) {
		int n = 7;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		FibonacciDP f = new FibonacciDP();
		System.out.println("fibonacci series for : " + n + " is : " + f.fibonacci(n, dp));
	}
	
	public int fibonacci(int n, int[] dp) {
		if(n <= 1) {
			return n;
		}
		
		if(dp[n] != -1) return dp[n];
		
		return dp[n] = fibonacci(n -1, dp) + fibonacci(n - 2, dp);
	}	
}

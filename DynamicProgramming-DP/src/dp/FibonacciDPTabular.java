package dp;

import java.util.Arrays;

//This is using Tabular one concept
public class FibonacciDPTabular {

	public static void main(String[] args) {
		int n = 7;
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		FibonacciDPTabular f = new FibonacciDPTabular();
		f.fibonacci(n, dp);
		
	}
	
	public void fibonacci(int n, int[] dp) {
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2 ; i <= n ;i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println("fibonacci series for : " + n + " is : " + dp[n]);
	}	
}

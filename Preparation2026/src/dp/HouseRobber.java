package dp;

import java.util.Arrays;

/**
 * 
 * House Robber - You cannot rob two adjacent houses.
 *
 */
public class HouseRobber {
	public static void main(String[] args) {
		int[] house = {1,2,3,1};
		int n = house.length;
		System.out.println("House Rob through Recurssion : " + houseRobRecursion(house, n - 1));
		
		System.out.println("*********************************");
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println("House Rob Top To Bottom Approach : " + houseRobTopToBottomApproach(house, dp, n - 1));
		
		
		System.out.println("*********************************");
		System.out.println("House Rob Bottom Up Approach : " + houseRobBottomUpApproach(house, n - 1));
		
		System.out.println("*********************************");
		System.out.println("House Rob Space Optimize Approach : " + houseRobSpaceOptimizedApproach(house));
		
	}
	
	public static int houseRobRecursion(int[] house, int n) {
		if(n == 0) return house[n];
		if(n < 0) return 0;
		int pick = house[n] + houseRobRecursion(house, n-2);
		int notPick = 0 + houseRobRecursion(house, n-1);
		
		return Math.max(pick,  notPick);
		
	}
	
		public static int houseRobTopToBottomApproach(int[] house, int[] dp,  int n) {
			if(n == 0) return house[n];
			if(n < 0) return 0;
			if(dp[n] != -1) return dp[n];
			int pick = house[n] + houseRobTopToBottomApproach(house, dp, n-2);
			int notPick = 0 + houseRobTopToBottomApproach(house, dp, n-1);
			
			return dp[n] = Math.max(pick, notPick);
		}
		
		public static int houseRobBottomUpApproach(int[] house, int n) {
			int[] dp = new int[n + 1];
			dp[0] = house[0];
			
			for(int i = 1 ; i <= n ;i++) {
				int pick = house[i];
				if(i > 1) pick += dp[i-2];
				int notPick = 0 + dp[i-1];
				
				dp[i] = Math.max(pick, notPick);
			}
			
			return dp[n-1];
			
		}
		
		public static int houseRobSpaceOptimizedApproach(int[] house) {
			int n = house.length;
			int prev = house[0];
			int prev2 = 0;
			for(int i = 1 ;i < n ;i++) {
				int pick = house[i];
				if(i > 1) pick +=prev2;
				int notPick = 0 + prev;
				int curr = Math.max(pick, notPick);
				prev2 = prev;
				prev = curr;
			}
			return prev;
		}
	
}

package leetcode;

import java.util.Arrays;

public class Candy {
	public static void main(String[] args) {
		//int[] ratings = {1,0,2};
		//int[] ratings = {1,2,2};
		int[] ratings = {1,3,2,2,1};
		System.out.println(getCandies(ratings));
	}
	
	public static int getCandies(int[] ratings) {
		int[] candies = new int[ratings.length];
		int n = ratings.length;
		Arrays.fill(candies, 1);
		
		for(int i = 1 ; i <= n-1 ; i++) {
			if(ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1] + 1;
			}
			
		}
		
		for(int i = n-1 ; i >=1 ; i--) {
			if(ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]) {
					candies[i-1] = candies[i] + 1;
			}
		}
		
		System.out.println(Arrays.toString(candies));
		int sum = Arrays.stream(candies).sum();
		
		return sum;
	}
}

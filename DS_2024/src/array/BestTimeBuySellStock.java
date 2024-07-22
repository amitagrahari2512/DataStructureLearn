package array;

/*
 * Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 */
public class BestTimeBuySellStock {

	public static void main(String[] args) {
		int[] priceArr = {7,1,5,3,6,4};
		//int[] priceArr = {7,6,4,3,1};
		System.out.println(" maxProfit : "+ maxProfit(priceArr));
		
	}
	
	public static int  maxProfit(int[] arr) {
		int maxProfit = 0;
		int buy = Integer.MAX_VALUE;
		int sell = Integer.MIN_VALUE;
		
		for(int i = 1 ; i < arr.length ; i++) {
			if(buy > arr[i-1]) {
				buy = arr[i-1];
			}
			sell = arr[i];
			int profit = sell - buy;
			
			if(profit > maxProfit) {
				maxProfit = profit;
			}
		}
		return maxProfit;
	}
	
}

package array;

/******************************************************************************

Find Maximum Profit:
You are given a list of integers representing stock prices on consecutive days. 
Your task is to implement a method `maxProfit()` to find the maximum profit that can be achieved by buying and 
selling stocks on these days. However, you are allowed to make at most one transaction 
(i.e., buy one and sell one share of the stock), and you cannot sell a stock before you buy one.

For example, given the list `[7, 1, 5, 3, 6, 4]`, the maximum profit that can be achieved is `5`, 
by buying on day 2 (price = 1) and selling on day 5 (price = 6).

Your implementation should have a time complexity of O(n), where n is the number of elements in the input list.

Be prepared to explain your approach and the time complexity of your solution during the interview. 

*******************************************************************************/


public class MaxProfitInOneBuyAndSell {
	public static void main(String[] args) {
	    int[] stockPrices = new int[]{7, 1, 5, 3, 6, 4};
	    //Expected answer is : 5
	    
	    int maxProfit = getMaxProfit(stockPrices);
		System.out.println("Max profit is : "+maxProfit);
	}
	
	static int getMaxProfit(int[] stockPrices){
	    if(stockPrices.length == 0)
	    	return 0;
	    
	    int minPrice = Integer.MAX_VALUE;
	    int maxProfit = 0;
	    
	    for(int price : stockPrices) {
	    	if(price < minPrice) {
		    	minPrice = price;
		    }
	    	
	    	int profit = price - minPrice;
	    	
	    	if(profit > maxProfit) {
	    		maxProfit = profit;
	    	}
	    }
	    return maxProfit;
	    
	}
}

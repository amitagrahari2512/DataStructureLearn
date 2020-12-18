package stock_maximize_profit;

/*
 * URL : https://www.youtube.com/watch?v=JaosdXkUWTs
 * 
 	Input:   price[] = {10, 22, 5, 75, 65, 80}
 	k = 2
	Output:  87
	Trader earns 87 as sum of 12 and 75
	Buy at price 10, sell at 22, buy at 5 and sell at 80
 */
public class StockMaximizeProfitInKtime {
	public static void main(String[] args) {
		int price[] = {10, 22, 5, 75, 65, 80};
		int k = 2;
		System.out.println(getMaxProfit(price, k));
	}
	
	public static int getMaxProfit(int[] price, int sellTime) {
		int count = 0;
		Profit[] profitArr = new Profit[sellTime];
		int n = price.length;
		int i = 0;
		int maxProfit = 0;
		while (i < n-1) {
			
			//find local minima
			while( (i < n-1) && (price[i+1] <= price[i])) {
				i++;
			}
			
			if(i == n-1)
			{
				System.out.println("No Possibility to find max benifit");
				return maxProfit;
			}
			
			Profit profit = new Profit();
			profit.buy = price[i];
			
			//Increase i so we can Check next element for local maxima.
			i++;
			
			//Find local maxima
			while ((i < n) && (price[i] >= price[i-1]))
			{
				i++;
			}
			
			profit.sell = price[i-1];	
			
			profitArr[count] =  profit;
			
			//Increment Sell Count
			count++;
			
			if(count == sellTime)
				break;
		}
		
		
		for(int k = 0 ; k < count ; k++) {
			maxProfit = maxProfit + (profitArr[k].sell - profitArr[k].buy);
		}
		
		return maxProfit;
	}
}

class Profit {
	int sell;
	int buy;
}

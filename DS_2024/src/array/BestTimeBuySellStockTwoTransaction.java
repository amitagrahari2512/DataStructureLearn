package array;

import java.util.Arrays;

public class BestTimeBuySellStockTwoTransaction {
	public static void main(String[] args) {
		int[] arr = {10, 22, 5, 75, 65, 80};
		int maxProfit = findMaxProfit(arr, arr.length);
		System.out.println("Max Profit : " + maxProfit);
	}

	private static int findMaxProfit(int[] arr, int length) {
		int[] profitArr = new int[length];
		
		//First Try to find second transaction from right Side
		int max_price = arr[length-1];
		for(int i = length-2 ; i>=0 ; i--) {
			if(arr[i] > max_price  ) {
				max_price = arr[i];
			}
			profitArr[i] = Math.max(profitArr[i+1] , max_price - arr[i]);
		}
		
		
		System.out.println("Second Transaction : " + Arrays.toString(profitArr));
		 
		//Second Try to find first transaction from left side
		int min_price = arr[0];
		for (int i = 1; i < length; i++) {
			if (arr[i] < min_price  ) {
				min_price = arr[i];
			}
			profitArr[i] = Math.max(profitArr[i - 1], profitArr[i] + (arr[i] - min_price));
		}
		
		System.out.println("First Transaction : " + Arrays.toString(profitArr));
		
		return profitArr[length-1];
	}
}

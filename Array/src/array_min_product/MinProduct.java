package array_min_product;

import java.util.PriorityQueue;

public class MinProduct {
	public static void main(String[] args) {
		int[] arr = {
				198, 76, 544, 123, 154, 675
		};
		int n = arr.length;
		int k = 2;
		int product = findProduct(arr, n, k);
		System.out.println(product);
	}
	
	private static int findProduct (int[] arr, int n, int k) {
		int count = 0;
		int product = 1;
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			que.add(arr[i]);
		}
		
		while (!que.isEmpty() && count < k) {
			product =  product * que.element();
			que.remove();
			count++;
		}
		return product;
	}
}

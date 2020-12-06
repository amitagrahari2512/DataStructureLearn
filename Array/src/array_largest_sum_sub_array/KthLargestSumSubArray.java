package array_largest_sum_sub_array;

import java.util.PriorityQueue;

public class KthLargestSumSubArray {
	public static void main(String[] args) {
		int[] arr = {
				10, -10, 20, -40
		};
		
		int n = arr.length;
		int k = 6;
		
		int sum = largestSum(arr, n, k);
		System.out.println("Larget Sum : "+sum);
	}
	
	private static int largestSum(int[] arr, int n, int k) {
		
		int[] sum = new int[n+1];
		sum[0] = 0;
		sum[1] = arr[0];
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for(int i = 2 ;i <=n ; i++) {
			sum[i] = sum[i-1] + arr[i-1];
		}
		
		for (int i = 1; i <=n; i++) {
			int x = 0;
			for (int j = i; j <=n; j++) {
				x = sum[j] - sum[i-1];
				
			
				if(que.size() < k) {
					que.add(x);
				}
				else {
					if(que.peek() < x) {
						que.poll();
						que.add(x);
					}
				}
			}
		}
		return que.poll();
	}
}

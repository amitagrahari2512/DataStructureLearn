package array_running_median;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
	public static void main(String[] args) {
		int[] arr = {
				5, 15, 10, 20, 3
		};
		findMedian(arr);
	}
	
	private static void findMedian(int[] arr) {
		PriorityQueue<Integer> smallest = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> greatest = new PriorityQueue<>();
		
		int n = arr.length;
		
		double med = arr[0];
		
		smallest.add(arr[0]);
		System.out.println(med);
			
		// reading elements of stream one by one  
        /* At any time we try to make heaps balanced and  
            their sizes differ by at-most 1. If heaps are  
            balanced,then we declare median as average of  
            min_heap_right.top() and max_heap_left.top()  
            If heaps are unbalanced,then median is defined  
            as the top element of heap of larger size */
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			
			// case1(left side heap has more elements) 
			if(smallest.size() > greatest.size()) {
				if(x < med) {
					greatest.add(smallest.remove());
					smallest.add(x);
				}
				else {
					greatest.add(x);
				}
				med = (double) (smallest.peek() + greatest.peek())/2;
			}
			// case2(both heaps are balanced)  
			else if(smallest.size() == greatest.size()) {
				if(x < med) {
					smallest.add(x);
					med = (double) smallest.peek();
				}
				else {
					greatest.add(x);
					med = (double) greatest.peek();
				}
			}
			// case3(right side heap has more elements) 
			else {
				if(x > med) {
					smallest.add(greatest.remove());
					greatest.add(x);
				}
				else {
					smallest.add(x);
				}
				med = (double) (smallest.peek() + greatest.peek())/2;
			}
			
			System.out.println(med);
			
		}
	}
	
	
	
}

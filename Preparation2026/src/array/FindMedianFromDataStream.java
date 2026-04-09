package array;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	
	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		for(int i = 1 ; i <= 10 ; i++) {
			m.addNum(i);
			System.out.println("median : " + m.findMedian());
		}
		
	} 
}

class MedianFinder {
	
	PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> large = new PriorityQueue<>();
	boolean even = true;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even) {
        	large.offer(num);
        	small.offer(large.poll());
        }
        else {
        	small.offer(num);
        	large.offer(small.poll());
        }
        
        //System.out.println("small : " + small);
		//System.out.println("large: " + large);
		
        even = !even;
    }
    
    public double findMedian() {
    	if(even) {
    		return (small.peek() + large.peek()) / 2.0;
    	}
    	else {
    		return small.peek();
    	}
    }
}

package median_concept;

public class MedianOfTwoSortedArray {
	
	public double findMedianOfTwoSortedArray(int[] input1, int[] input2) {
		if(input1.length > input2.length) {
			return findMedianOfTwoSortedArray(input2, input1);
		}
		
		int x = input1.length;
		int y = input2.length;
		
		int low = 0;
		int high = x;
		
		while(low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1) /2 - partitionX;
			
			int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : input1[partitionX-1];
			int minRightX = partitionX == x ? Integer.MAX_VALUE : input1[partitionX];
			
			int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : input2[partitionY-1];
			int minRightY = partitionY == y ? Integer.MAX_VALUE : input2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x+y)%2 == 0) {
					return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
				}
				else {
					return (double) (Math.max(maxLeftX, maxLeftY));
				}
			}
			else if(maxLeftX > minRightY) {
				high = partitionX - 1;
			}
			else {
				low = partitionX + 1;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) {
		int[] input1 = {1, 3, 5, 9, 15};
		int[] input2 = {2, 6, 7, 10, 11, 14};
		
		MedianOfTwoSortedArray median = new MedianOfTwoSortedArray();
		double medianVal = median.findMedianOfTwoSortedArray(input1, input2);
		System.out.println("Median is : " + medianVal);
		
		int[] input3 = {23, 26, 31, 35};
		int[] input4 = {3, 5, 7, 9, 11, 16};
		
		medianVal = median.findMedianOfTwoSortedArray(input3, input4);
		System.out.println("Median is : " + medianVal);
		
	}
}

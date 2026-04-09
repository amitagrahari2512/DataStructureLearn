package array;

public class FindMedianTwoSortedArray {

	public static void main(String[] args) {
		int[] a1 = {1, 3, 5, 7, 8 , 9, 10};
		int[] a2 = {2, 4, 6};
		
		double median = findMedian(a1, a2);
		System.out.println(median);
		
		int[] p1 = {1, 3};
		int[] p2 = {2, 4, 6};
		
		median = findMedian(p1, p2);
		System.out.println(median);
	}

	private static double findMedian(int[] a1, int[] a2) {
		int n1 = a1.length;
		int n2 = a2.length;
		int n = n1 + n2;
		int i = 0;
		int j = 0;
		int count = 0;
		int index2 = n/2;
		int index1 = index2 - 1;
		int index2Element = -1;
		int index1Element = -1;
		
		while(i < n1 && j < n2) {
			if(a1[i] < a2[j]) {
				if(count == index2) index2Element = a1[i];
				if(count == index1) index1Element = a1[i];
				count++;
				i++;
			}
			else {
				if(count == index2) index2Element = a2[j];
				if(count == index1) index1Element = a2[j];
				count++;
				j++;
			}
		}
		
		while(i < n1) {
			if(count == index2) index2Element = a1[i];
			if(count == index1) index1Element = a1[i];
			count++;
			i++;
		}
		
		while(j < n2) {
			if(count == index2) index2Element = a2[j];
			if(count == index1) index1Element = a2[j];
			count++;
			j++;
		}
		
		if(n%2 == 1) 
			return (double)index2Element;
		else {
			return (double)(index2Element + index1Element) / 2;
		}
		
		
	}

}

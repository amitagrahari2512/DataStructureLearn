package second_largest;

public class SecondLargestNo {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		System.out.println("Second Largest : " + secondLargest(a));
	}
	
	public static int secondLargest(int[] a) {
		int n = a.length;
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for(int i = 0 ;i < n; i++) {
			if(a[i] > largest) {
				secondLargest = largest;
				largest = a[i];
			}
			else if(a[i] < largest && a[i] > secondLargest){
				secondLargest = a[i];
			}
		}
		
		return secondLargest;
	}

}

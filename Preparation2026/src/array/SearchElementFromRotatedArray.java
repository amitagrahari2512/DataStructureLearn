package array;

public class SearchElementFromRotatedArray {
	public static void main(String[] args) {
		int[] arr = {7,6,5,1,2,3,4,5};
		int key = 3;
		System.out.println("Index of  no  is : " + searchNo(arr , key));
		
	}
	
	public static int searchNo(int[] arr, int key) {
		int l = 0;
		int h = arr.length - 1;
		
		while(l <= h) {
			int mid = l + (h - l) / 2;
			
			if(arr[mid] == key)
				return mid;
			
			if(arr[mid] >= arr[l]) { //left Sorted
				if(key >= arr[l] && key < arr[mid] ) {
					h = mid - 1;
				}
				else {
					l = mid + 1;
				}
			}
			else { //Right Sorted
				if(key > arr[mid] && key <= arr[h]) {
					l = mid + 1;
				}
				else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}
}

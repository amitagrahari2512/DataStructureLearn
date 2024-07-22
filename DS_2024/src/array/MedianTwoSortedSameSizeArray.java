package array;

public class MedianTwoSortedSameSizeArray {

	public static void main(String[] args) {
		int arr1[] = {1, 12, 15, 26, 38};
		int arr2[] = {2, 13, 17, 30, 45};
		System.out.println("Median for medianTwoSortedSameSizeArray : " + medianTwoSortedSameSizeArray(arr1, arr2));
	}

	private static int medianTwoSortedSameSizeArray(int[] arr1, int[] arr2) {
		int m1 = -1; // for this this is left side one
		int m2 = -1; // For us this is right side one
		
		int i = 0;
		int j = 0;
		int n = arr1.length;
		
		//we need to find n and n+1 values
		for(int count = 0 ; count <= n; count++) {
			if(i == n) {
				m1 = m2;
				m2 = arr2[0];
				break;
			}
			else if(j == n) {
				m1 = m2;
				m2 = arr1[0];
				break;
			}
			
			if(arr1[i] <= arr2[j]) 
			{
				m1 = m2;
				m2 = arr1[i];
				i++;
			}
			else {
				m1 = m2;
				m2 = arr2[j];
				j++;
			}
		}
		return (m1 + m2)/2;
	}

}

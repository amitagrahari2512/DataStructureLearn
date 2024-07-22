package array;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		
		int[] arr1 = {5, 6, 9, 12};
		int[] arr2 = {1, 2, 10, 14, 16};
		System.out.println("Merge Array : " + Arrays.toString(mergeArray(arr1, arr2)));
	}
	
	
	public static int[] mergeArray(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int[] mergeArr = new int[n1 + n2];
		
		int arr1Index = 0;
		int arr2Index = 0;
		int mergeIndex = 0;
		
		while(arr1Index != n1  && arr2Index != n2 ) {
			if(arr1[arr1Index] < arr2[arr2Index]) {
				mergeArr[mergeIndex]  = arr1[arr1Index];
				mergeIndex++;
				arr1Index++;
			}
			else {
				mergeArr[mergeIndex]  = arr2[arr2Index];
				mergeIndex++;
				arr2Index++;
			}
		}
		
		if(arr1Index != n1) {
			for(int i = arr1Index ; i < n1 ; i++) {
				mergeArr[mergeIndex]  = arr1[i];
				mergeIndex++;
			}
		}
		
		if(arr2Index != n2) {
			for(int i = arr2Index ; i < n2 ; i++) {
				mergeArr[mergeIndex]  = arr2[i];
				mergeIndex++;
			}
		}
		
		return mergeArr;
		
	}

}

package array;

import java.util.Arrays;

public class FindLongestConsecutiveSubSequenceArray {

	public static void main(String[] args) {
		//int[] arr = {2,6,1,9,4,5,3};
		//int[] arr = {1,9,3,10,4,20,2};
		//int[] arr = {0, 1, 1, 1, 1, 1, 2};
		int[] arr = {34, 2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6};
		
		System.out.println(findLongestConseqSubseq(arr, arr.length));
		
	}
	
	public static int findLongestConseqSubseq(int arr[], int N)
	{
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int max = 1;
		int count = 1;
		
		for(int i = 1 ;i < N ; i++) {
			if(arr[i] == arr[i - 1] + 1 || arr[i] == arr[i-1]) {
				if(arr[i] == arr[i - 1] + 1) {
					count++;
				}
				if(i == N-1) {
					if(max < count) {
						max = count;
					}
				}
			}
			else {
				if(max < count) {
					max = count;
				}
					count = 1;
				
			}
		}
		return max;
	}

}

package array_rearrangement;

import java.util.Arrays;

public class RecordArrayAccordingToIndex {
	public static void main(String[] args) {
		int[] valueArr = {12, 13, 14, 15, 16};
		int[] indexArr = {1, 3, 2, 0, 4 };
		rearrangeArray(valueArr, indexArr);
		rearrangeArrayWithoutExtraArray(valueArr, indexArr);
	}
	
	public static void rearrangeArray(int[] valueArr, int[] indexArr) {
		int n = valueArr.length;
		int[] tempArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			tempArr[indexArr[i]] = valueArr[i];
		}
		
		System.out.println(Arrays.toString(tempArr));
	}
	
	public static void rearrangeArrayWithoutExtraArray(int[] valueArr, int[] indexArr) {
		int n = valueArr.length;
		for (int i = 0; i < n; i++) {
			if(indexArr[i] != i) {
				int indexTarget = indexArr[i];
				int valueTarget = valueArr[indexArr[i]];
				
				indexArr[indexArr[i]] =  indexArr[i];
				valueArr[indexArr[i]] = valueArr[i];
				
				indexArr[i] = indexTarget;
				valueArr[i] = valueTarget;
			}
		}
		System.out.println(Arrays.toString(valueArr));
	}
}

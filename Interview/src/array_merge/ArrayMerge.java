package array_merge;

import java.util.Arrays;

public class ArrayMerge {
	public static void main(String[] args) {
		int a[] = {1, 2, 4, 5, 7, 9};
		int b[] = {2, 4,8, 10, 11};
		int[] merge = mergeArray1(a,b);
		
		System.out.println(Arrays.toString(merge));
	}
	
	public static int[] mergeArray(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		int[] merge = new int[aLen + bLen];
		int maxLength = 0;
		if(aLen > bLen) {
			maxLength = aLen;
		}
		else {
			maxLength = bLen;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		for(int iter =0; iter< maxLength; iter++) {
			int aData = a[i];
			int bData = b[j];
			if(aLen-1 >= iter && bLen-1 >= iter) {
				if(aData == bData) {
					merge[k++] = aData;
					merge[k++] = bData;
					i++;
					j++;
				}
				else if(aData > bData) {
					merge[k++] = bData;
					j++;
				}
				else if(aData < bData) {
					merge[k++] = aData;
					i++;
				}
			}
			else {
				int arrEntend= 0;
				int arrExtendLen = 0;
				if(aLen-1 > iter) {
					arrEntend = i;
					arrExtendLen = aLen;
					for(int x = arrEntend ; x < arrExtendLen; x++) {
						merge[k++] = a[x];
					}
				}
				else if(bLen > iter){
					arrEntend = j;
					arrExtendLen = bLen;
					for(int x = arrEntend ; x < arrExtendLen; x++) {
						merge[k++] = b[x];
					}
				}
				
			}
		}
		
		return merge;
		
	}
	
	public static int[] mergeArray1(int[] a, int[] b) {
		int aLen = a.length;
		int bLen = b.length;
		int[] merge = new int[aLen + bLen];
		
		int i = 0;
		int j = 0;
		int k = 0;
		while(true) {
			if(i > aLen-1 && j <= bLen-1) {
				for(int p = j ; p < bLen ; p++) {
					merge[k++] = b[p]; 
				}
				break;
			}
			
			if(i <= aLen-1 && j > bLen-1) {
				for(int p = i ; p < aLen ; p++) {
					merge[k++] = a[p]; 
				}
				break;
			}
			
			int aData = a[i];
			int bData = b[j];
				if(aData == bData) {
					merge[k++] = aData;
					merge[k++] = bData;
					i++;
					j++;
				}
				else if(aData > bData) {
					merge[k++] = bData;
					j++;
				}
				else if(aData < bData) {
					merge[k++] = aData;
					i++;
				}
		}
		return merge;
	}
}

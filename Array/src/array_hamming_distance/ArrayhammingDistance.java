package array_hamming_distance;

public class ArrayhammingDistance {
	public static void main(String[] args) {
		int[] arr = new int[] {
				2, 4, 6, 8
		};
		
		int n = arr.length;
		int[] dArr = new int[2 *n ];
		
		for(int i= 0 ;i <n ; i++) {
			dArr[i] = dArr[i+n] = arr[i];
		}
		System.out.print(findHammimgDistance(arr, dArr, n));
	}
	
	private static int findHammimgDistance(int[] arr, int[] dArr, int n) {
		
		int maxHam = 0;
		
		for (int i = 0; i < n; i++) {
			int currHam = 0;
			for (int j = i, k =0 ; j < (i + n); j++, k++) {
				if(dArr[j] != arr[k]) {
					currHam++;
				}
			}
			
			if(currHam == n)
				return n;
			
			maxHam = Math.max(currHam, maxHam);
		}
		
		return maxHam;
	}
}

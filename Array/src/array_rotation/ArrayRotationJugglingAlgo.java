package array_rotation;

import java.util.Arrays;

public class ArrayRotationJugglingAlgo {
	public static void main(String[] args) {
		int rotateNo = 5;
		int[] arr = new int[] {
				1,2,3,4,5,6,7,8,9,10,11,12
		};
		arrayRotation(arr, rotateNo, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void arrayRotation(int arr[], int d, int n) 
    { 
        /* To handle if d >= n */
        d = d % n; 
        int i, j, k, temp; 
        int g_c_d = GCD.gcd(d, n); 
        for (i = 0; i < g_c_d; i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
    } 
}

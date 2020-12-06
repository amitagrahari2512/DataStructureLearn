package spike;

public class Spike {
	public static void main(String[] args) {
		int [] A = {2, 3, 3, 2, 2, 2, 1};
		System.out.println(spike(A));
	}
	
	public static int spike(int[] A) {
		int len = A.length;
        int count = 0;
		
		/*
		 * for (int i = 0; i < len; i++) { if(i > 0 && A[i-1] < A[i]) { count++; }
		 * 
		 * if(i < len-1 && A[i] > A[i+1]) { count++; } }
		 */
        for (int i = 0; i < len-1; i++) {
			if(A[i] < A[i+1]) {
				count = count + 2;
			}	
		}
		return count;
	}
}

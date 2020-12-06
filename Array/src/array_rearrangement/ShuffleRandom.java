package array_rearrangement;

import java.util.Arrays;
import java.util.Random;

public class ShuffleRandom {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
		shuffleRandom(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shuffleRandom(int[] arr) { 
		int n = arr.length;
		int temp = 0;
		
		for (int i = n-1; i > 0; i--) {
			Random rand = new Random();
			
			int j = rand.nextInt(i+1);
			
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			
		}
	}

}

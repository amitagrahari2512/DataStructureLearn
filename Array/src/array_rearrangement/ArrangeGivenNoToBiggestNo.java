package array_rearrangement;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeGivenNoToBiggestNo {
	public static void main(String[] args) {
		String[] arr = {
				"54", "546", "548","60"
		};
		
		arrangeBiggestNo(arr);
	}

	private static void arrangeBiggestNo(String[] arr) {
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {
				String xy = x + y;
				
				String yx = y + x;
				return xy.compareTo(yx) > 0 ? -1 : 1;
			}
		});
		
		String big = "";
		for(String a : arr) {
			big = big + a;
		}
		
		System.out.println(big);
	}
}

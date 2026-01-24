package stream.collectors;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] rarr = IntStream.range(0, arr.length)
				.map(i -> arr[arr.length - i - 1])
				.toArray();
		System.out.println(Arrays.toString(rarr));
	}

}

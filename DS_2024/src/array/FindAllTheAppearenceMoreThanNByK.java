package array;

import java.util.HashMap;
import java.util.Map;

public class FindAllTheAppearenceMoreThanNByK {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
		findAppearance(arr, arr.length/k);
		
		
		System.out.println("*************");
		int[] arr1 = {9, 8, 7, 9, 2, 9, 7};
		k = 3;
		findAppearance(arr1, arr1.length/k);
		
		
	}

	private static void findAppearance(int[] arr, int a) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(!map.containsKey(arr[i])) {
				map.putIfAbsent(arr[i], 1);
			}
			else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > a) {
				System.out.println(entry.getKey());
			}
		}
		
	}
}

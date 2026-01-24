package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumberInRange {
	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};
		missingNumber(arr);
		missingNumberViaIndex(arr);
	}
	
	
	public static void missingNumber(int[] arr) {
		arr = Arrays.stream(arr).distinct().sorted().toArray();
		int initial = 1;
		for(int i = 0 ; i < arr.length ;)
		{
			if(arr[i] == initial) {
				initial++;
				i++;
			}
			else {
				System.out.println("Miss No : " + initial);
				initial++;
			}
		}
	}
	
	public static void missingNumberViaIndex(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < arr.length ; i++)
		{
			int idx = Math.abs(arr[i]) - 1;
			
			if(arr[idx] > 0)
				arr[idx] =  -arr[idx];
				
		}
		
		for(int i = 0 ; i < arr.length - 1 ; i++ )
		{
			if(arr[i] > 0)
				list.add(i+1);
				
		}
		System.out.println("Missing No : "  + list);
		
	}
}

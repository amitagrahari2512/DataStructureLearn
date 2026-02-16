package dp;

import java.util.ArrayList;
import java.util.List;

//We have array with +ve and -ve value, We need to find subArray with target match
public class FindSubArrayWithTargetMatch {
	public static void main(String[] args) {
		int[] arr = {2, 1, 1, -4, 3, -5, -2, 2, 2};
		int target = 4;
		
		List<List<Integer>> result = new ArrayList<>();
		
		subArrayTarget(arr, target, 0, 0, new ArrayList<>(),result);
		
		System.out.println(result);
	}
	
	public static void subArrayTarget(int[] arr , int target, int index, int currentSum, List<Integer> current, List<List<Integer>> result) {
		if(index == arr.length) {
			if(currentSum == target) {
				result.add(new ArrayList<>(current));
			}
			return;
		}
		
		current.add(arr[index]);
		subArrayTarget(arr, target, index + 1, currentSum + arr[index], current, result);
		current.remove(current.size()-1);
		subArrayTarget(arr, target, index + 1, currentSum, current, result);
		
	}
}

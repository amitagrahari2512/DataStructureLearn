package strings;

import java.util.ArrayList;
import java.util.List;

/*
 Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

public class SubSequence {
	public static void main(String[] args) {
		int[] num = {1,2,3};
		System.out.println(subSequenceUsingPowerSet(num));
		System.out.println(subSequenceUsingRecursion(num));
	}
	
	//Time - Complexity 2^n * n
	public static List<List<Integer>> subSequenceUsingPowerSet(int[] num) {
		int n = num.length;
		int combination = (int)Math.pow(2, n);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0 ; i< combination; i++) {
			List<Integer> list = new ArrayList<>();
			for(int j = 0 ; j < n; j++) {
				int leftShift = 1<<j;
				if((i & leftShift) != 0) {
					list.add(num[j]);
				}
			}
			result.add(list);
		}
		return result;
	}
	
	//Time - Complexity 2^n * n
	public static List<List<Integer>> subSequenceUsingRecursion(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		createSubset(num, 0, result, subset);
		return result;
	}
	
	private static void createSubset(int[] num, int index, List<List<Integer>> result, List<Integer> subset) {
		if(index == num.length)
		{
			result.add(new ArrayList<>(subset));
			return;
		}
		
		subset.add(num[index]);
		createSubset(num, index+1, result, subset);//pick
		subset.remove(subset.size() - 1);
		createSubset(num, index+1, result, subset);//Not - pick
	}
}

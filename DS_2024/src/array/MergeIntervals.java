package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
 */
public class MergeIntervals {
	
	static class Pair {
		int start;
		int end;
	}

	public static void main(String[] args) {
		//int[][] interval = {{1,3},{2,6},{8,10},{15,18}};
		//int[][] interval = {{1,4},{4,5}};
		//int[][] interval = {{1,4},{0,4}};
		int[][] interval = {{1,4},{2,3}};
		//int[][] interval = {{1,4},{0,2},{3,5}};
		
		List<Pair> listPair = convertToPair(interval);
		Collections.sort(listPair, (p1, p2)->{
				return p1.start - p2.start;
		});
		listPair.forEach(a -> System.out.println(a.start + " : " + a.end));
		List<Pair> listPairInterval = findInterval(listPair);
		listPairInterval.forEach(a -> System.out.println(a.start + " : " + a.end));
		int[][] result = new int[listPairInterval.size()][2];
		for(int i = 0 ; i < listPairInterval.size(); i++) {
			result[i][0] = listPairInterval.get(i).start;
			result[i][1] = listPairInterval.get(i).end;
		}
		
		System.out.println(Arrays.deepToString(result));
		
	}
	
	public static List<Pair> convertToPair(int[][] interval) {
		List<Pair> pairList = new ArrayList<>();
		for(int i = 0 ;i < interval.length ; i++) {
			Pair pair = new Pair();
			int[] intervalPair = interval[i];
			pair.start = intervalPair[0];
			pair.end = intervalPair[1];
			
			pairList.add(pair);
		}
		return pairList;
	}
	
	public static List<Pair> findInterval(List<Pair> listPair) {
		System.out.println("Size; " + listPair.size());
		/*
		for(int i = 1 ;i < listPair.size() ; ) {
			if(listPair.get(i).start <= listPair.get(i-1).end && listPair.get(i).end <= listPair.get(i-1).end) {
				listPair.remove(i);
				i++;
			} else if(listPair.get(i).start <= listPair.get(i-1).end ) {
				listPair.get(i-1).end = listPair.get(i).end;
				listPair.remove(i);
			}
		}
		*/
		
		for(int i = 1 ;i < listPair.size() ; i++) {
			if(listPair.get(i-1).start <= listPair.get(i).start && listPair.get(i-1).end >= listPair.get(i).start) {
				listPair.get(i).start = listPair.get(i-1).start;
				if(listPair.get(i-1).end >= listPair.get(i).end) {
					listPair.get(i).end = listPair.get(i-1).end;
				}
				listPair.remove(i-1);
				i--;
			} 
		}
		return listPair;
	}

}

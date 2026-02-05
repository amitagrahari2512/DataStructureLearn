package array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Merge Overlapping Intervals
public class MergeIntervals {

	public static void main(String[] args) {
		int[] arrive = {900, 940, 950, 1100, 1500, 1800};
		int[] depart = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println(mergeIntervals(arrive, depart));
		
		int[] arrive1 = {900, 1235, 1100};
		int[] depart1 = {1000, 1240, 1200};
		
		System.out.println(mergeIntervals(arrive1, depart1));
		
		int[] arrive2 = {1000, 935, 1100};
		int[] depart2 = {1200, 1240, 1130};
		
		System.out.println(mergeIntervals(arrive2, depart2));
		
	}
	
	public static List<Merge> mergeIntervals(int[] arrive, int[] depart) {
		int n = arrive.length;
		
		List<Merge> list = IntStream.range(0, arrive.length).mapToObj((i) -> new MergeIntervals.Merge(arrive[i], depart[i])).sorted((a,b) -> a.arrive - b.arrive).collect(Collectors.toList());
		
		for(int i = 1 ;i < list.size() ;i++ ) {
			if(list.get(i-1).arrive <= list.get(i).arrive && list.get(i-1).depart >= list.get(i).arrive) {
				list.get(i).arrive = list.get(i-1).arrive;
				if(list.get(i-1).depart >= list.get(i).depart) {
					list.get(i).depart = list.get(i-1).depart;
				}
				list.remove(i-1);
				i--;
			}
		}
		return list;
	}
	
	static class Merge {
		int arrive,depart;
		public Merge(int arrive, int depart) {
			this.arrive = arrive;
			this.depart = depart;
		}
		
		@Override
		public String toString() {
			return arrive + "::"+ depart;
		}
	}
}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertIntervals {
	
	public static void main(String[] args) {
		//int[][] intervals = {{1,3},{6,9}};
		//int[] newInterval = {2,5};
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		
		System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
		
		
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> list = new ArrayList<>();
        Pair insertPair = new Pair();
        insertPair.start = newInterval[0];
        insertPair.end = newInterval[1];

        for(int i = 0 ; i < intervals.length; i++) {
            Pair pair = new Pair();
            pair.start = intervals[i][0];
            pair.end = intervals[i][1];
            list.add(pair);
        }

        Collections.sort(list, (p1, p2) -> {
            return p1.start - p2.start;
        });

        int index = -1;
        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).start <= insertPair.start && list.get(i).end >= insertPair.start) {
                list.get(i).end = insertPair.end;
                index = i;
                break;
            }
        }
        

        if(index != -1) {
            for(int i = index + 1 ; i < list.size() ; i++) {
                if(list.get(i -1).start <= list.get(i).start && list.get(i-1).end >= list.get(i).start) {
                	if(!(list.get(i-1).end >= list.get(i).end)) {
                		list.get(i-1).end = list.get(i).end;
                	}
                    list.remove(i);
                    i--;
                }
            }
        }

        int[][] result = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++) {
            result[i][0] = list.get(i).start;
            result[i][1] = list.get(i).end;
        }

        return result;

    }

    static class Pair {
        int start;
        int end;
        
        public String toString() {
        	return "[" + start + "," + end + "]";
        }
    }

}

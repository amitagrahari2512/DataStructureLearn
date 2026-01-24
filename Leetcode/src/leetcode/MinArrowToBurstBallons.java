package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinArrowToBurstBallons {
	
	public static void main(String[] args) {
		int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
		System.out.println(findMinArrowShots(points));
	}
	
	public static int findMinArrowShots(int[][] points) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0 ; i < points.length; i++) {
            Pair pair = new Pair();
            pair.start = points[i][0];
            pair.end = points[i][1];
            list.add(pair);
        }

        if(list.size() == 0)
            return 0;

        if(list.size() == 1)
            return 1;


        Collections.sort(list, (p1,p2) -> {
            return p1.end - p2.end;
        });
        
        System.out.println(list);

        int end = list.get(0).end;
        int result = 1;
        for(int i = 1 ; i < list.size(); i++) {
            if(list.get(i).start < end && list.get(i).start > 0) {
                continue;
            }
            if(list.get(i).start > end) {
                result++;
                end = list.get(i).end;
            }
        }

        return result;

    }

    static class Pair{
        int start;
        int end;
        public String toString() {
        	return "[" + start + "," + end + "]";
        }
    }
}

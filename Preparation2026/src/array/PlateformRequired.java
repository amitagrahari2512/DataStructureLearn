package array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * 
 *Given arrival arr[] and departure dep[] times of trains on the same day, 
 *find the minimum number of platforms needed so that no train waits. 
 *A platform cannot serve two trains at the same time; 
 *if a train arrives before another departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) , 
where the first two characters represent hour (between 00 to 23 ) 
and the last two characters represent minutes (this will be <= 59 and >= 0). 
Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).
 */
public class PlateformRequired {

	public static void main(String[] args) {
		int[] arrive = {900, 940, 950, 1100, 1500, 1800};
		int[] depart = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println("Min Plateform : " + minPlateform(arrive, depart));
		
		int[] arrive1 = {900, 1235, 1100};
		int[] depart1 = {1000, 1240, 1200};
		
		System.out.println("Min Plateform : " + minPlateform(arrive1, depart1));
		
		int[] arrive2 = {1000, 935, 1100};
		int[] depart2 = {1200, 1240, 1130};
		
		System.out.println("Min Plateform : " + minPlateform(arrive2, depart2));
		
		
	}
	
	public static int minPlateform(int[] arrive, int[] depart) {
		Arrays.sort(arrive);
		Arrays.sort(depart);
		
		int n = arrive.length;
		
		int plateformNeeded = 0;
		int maxPlateform = 0;
		
		int i = 0;
		int j = 0;
		
		while( i < n && j < n) {
			if(arrive[i] <= depart[j]) {
				plateformNeeded++;
				maxPlateform = Math.max(maxPlateform, plateformNeeded);
				i++;
			}
			else {
				plateformNeeded--;
				j++;
			}
		}
		
		return maxPlateform;
		
	}

}


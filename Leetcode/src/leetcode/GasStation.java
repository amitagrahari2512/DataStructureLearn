package leetcode;

public class GasStation {
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5}; 
		int[] cost = {3,4,5,1,2};
		//int[] gas = {3,3,4}; 
		//int[] cost = {3,4,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int start = 0;
        int rest = 0;
        int initialStart = 0;
        int negativeCount = 0;
        int positiveCount = 0;
        while(initialStart < n) {
            rest = rest + gas[start];
            if(rest >= cost[start]) {
            	System.out.print(rest + ": ");
                rest = rest - cost[start];
                System.out.println(rest);
                start = (start == n -1) ? 0 : start + 1;
                positiveCount++;
            }
            else {
               start = (start == n -1) ? 0 : start + 1;
               initialStart = start;
               rest = 0;
               positiveCount = 0;
               negativeCount++;
               System.out.println("initialStart reset");
            }

            if(positiveCount == n) {
            	if(rest >= 0)
            		return initialStart;
            }

            if(negativeCount == n) {
                return -1;
            }
        }
        return -1;
    }
}

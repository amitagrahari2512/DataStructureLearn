package recurssion;


/*
 * Given an integer array height[] where height[i] represents the height of the i-th stair, 
 * a frog starts from the first stair and wants to reach the top. From any stair i, the frog has two options: 
 * it can either jump to the (i+1)-th stair or the (i+2)-th stair. T
 * he cost of a jump is the absolute difference in height between the two stairs. 
 * The task is to find the minimum total cost required for the frog to reach the top.
 */
public class FrogJumpRecurssion {

	public static void main(String[] args) {
		int[] arr = {20, 30, 40, 20};
		
		//int[] arr = {30, 20, 50, 10, 40}; 
		int n = arr.length;
		FrogJumpRecurssion r = new FrogJumpRecurssion();
		int jump = r.frogJump(arr , n - 1);
		System.out.println("Jump required : " + jump);
	}

	public int frogJump(int[] arr , int index) {
		if(index == 0) return 0;
		
		int left = frogJump(arr, index - 1) + Math.abs(arr[index] - arr[index-1]);
		
		int right = Integer.MAX_VALUE;
		if(index > 1) {
			 right = frogJump(arr, index - 2) + Math.abs(arr[index] - arr[index-2]);
		}
		
		return Math.min(left, right);
 	}
}

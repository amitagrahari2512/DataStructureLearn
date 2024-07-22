package array;


/*
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.



Input: height = [4,2,0,3,2,5]
Output: 9

 */
public class TrappingRainWater {

	public static void main(String[] args) {
		//int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] input = {4,2,0,3,2,5};
		System.out.println(water(input));
	}

	private static int water(int[] input) {
		int left = 0;
		int right = input.length - 1;
		int maxLeft = 0;
		int maxRight = 0;
		int water = 0;
		
		while(left <= right) {
			if(input[left] < input[right]) {
				if(input[left] >= maxLeft) {
					maxLeft = input[left];
				}
				else {
					water += maxLeft - input[left];
				}
				left++;
			}
			else {
				if(input[right] >= maxRight) {
					maxRight = input[right];
				}
				else {
					water += maxRight - input[right];
				}
				right--;
			}
		}
		
		
		
		return water;
	}

}

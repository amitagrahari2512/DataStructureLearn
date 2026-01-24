package leetcode;

import java.util.Arrays;

public class LongestSubstring {

	public static void main(String[] args) {
		String n = "pwwkew";
		System.out.println(longestSubstring(n));
	}
	
	public static int longestSubstring(String s) {
		int max = 0;
		int n = s.length();
		boolean[] visit = new boolean[256];
		int left = 0;
		int right = 0;
		while(right < n) {
			while(visit[s.charAt(right)]) {
				visit[s.charAt(left)] = false;
				left++;
			}
			visit[s.charAt(right)] = true;
			
			max = Math.max(max, (right - left + 1));
			right++;
		}
		return max;
	}

}

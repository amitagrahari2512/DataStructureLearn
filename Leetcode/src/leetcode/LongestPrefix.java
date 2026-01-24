package leetcode;

import java.util.Arrays;

public class LongestPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		//String[] strs = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(strs));
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		int n = strs.length;
		int minIndex = 0;
		for(int i = 0 ; i < n ; i++) {
			if(strs[i].length() < strs[minIndex].length()) {
				minIndex = i;
			}
		}
		
		String minVal = strs[minIndex];
		
		for(int i = 0 ; i < n ; i++) {
				while(strs[i].length() > 0) {
					if(!strs[i].startsWith(minVal)) {
						minVal = minVal.substring(0, minVal.length()-1);
					}
					else {
						break;
					}
			}
		}
		return minVal;
	}

}

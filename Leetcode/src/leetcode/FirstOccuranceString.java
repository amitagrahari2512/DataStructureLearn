package leetcode;

import java.util.Arrays;

public class FirstOccuranceString {

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(strStr(haystack,needle));
	}
	
	public static int strStr(String haystack, String needle) {
		
        int k;
        String w;
        if(needle.length() == 1) {
        	for(int i = 0 ; i < needle.length(); i++) {
        		char c = needle.charAt(0);
        		if(haystack.charAt(i) == c) {
        			return i;
        		}
        	}
        }
        else {
        	for(int i = 0 ; i < haystack.length() - needle.length(); i++) {
        		k = i + needle.length();
        		w = haystack.substring(i, k);
        		if(w.equals(needle)) {
        			return i;
        		}
        	}
        }
        return -1;
		
		
    }

}

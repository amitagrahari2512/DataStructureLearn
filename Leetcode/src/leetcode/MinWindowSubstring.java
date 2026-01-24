package leetcode;

import java.util.Arrays;

public class MinWindowSubstring {
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
	
	public static String minWindow(String s, String t) {
        int strLen = s.length();
        int testLen = t.length();
        if(strLen < testLen)
            return "";
        if(strLen == 1 && testLen == 1 && s.equals(t))
            return s;
        
        if(strLen == 1 && testLen == 1 && !s.equals(t))
        	return "";
        
        int[] cntArr = new int[256];
        for(char tA : t.toCharArray()) {
        	cntArr[tA]++;
        }
        
        System.out.println(Arrays.toString(cntArr));
        
        char[] ch = s.toCharArray();
        
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int index = 0;
        int count = t.length();
        
        while(end < ch.length) {
        	System.out.println("while : " + ch[end] + ": " + cntArr[ch[end]]);
        	if(cntArr[ch[end++]]-- > 0) {
        		count--;
        	}
        	
        	while(count == 0) {
        		if(end - start < min) {
        			min = end - start;
        			index = start;
        		}
        		System.out.println("inside while : " + ch[start]  + ": " + cntArr[ch[start]]);
        		if(cntArr[ch[start++]]++ == 0)  {
        			count++;
        		}
        		
        	}
        }
        
        return min == Integer.MAX_VALUE ? new String() : new String(ch, index, min);
    }
}

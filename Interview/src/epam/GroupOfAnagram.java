package epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupOfAnagram {
	
	 public static List<List<String>> groupAnagrams(String[] strs) {
	        HashMap<String, List<String>> map = new HashMap<>();

	        for(String str : strs) {
	            char[] chArr = str.toCharArray();
	            Arrays.sort(chArr);
	            String val = String.valueOf(chArr);
	            map.putIfAbsent(val, new ArrayList<>());
	            map.get(val).add(str);
	        }

	        return new ArrayList<>(map.values());
	    }
	 
	 
	 public static void main(String[] args) {
		String[] n = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(n));
	}
}

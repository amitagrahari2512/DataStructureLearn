package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DuplicateCharInString {

	public static void main(String[] args) {
		String s = "geekforgeeks";
		duplicateChar(s);
	}

	private static void duplicateChar(String s) {
		List<Character> list = new ArrayList<>();
		char[] ch = s.toCharArray();
		HashMap<Character, Integer> map = new LinkedHashMap<>();
		for(int i = 0 ; i < ch.length ; i++) {
			if(map.containsKey(ch[i])) {
				map.put(ch[i], map.get(ch[i]) + 1);
			}
			else {
				map.put(ch[i], 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				list.add(entry.getKey());
			}
		}
		
		System.out.println("Duplicate Elements are : " + list);
	}

}

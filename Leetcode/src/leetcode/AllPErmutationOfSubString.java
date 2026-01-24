package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllPErmutationOfSubString {
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		System.out.println(findSubstring(s, words));
	}
	
	 public static List<Integer> findSubstring(String s, String[] words) {
	        int n = s.length();
	        int word_count = words.length;
	        int size_of_one_word = words[0].length();
	        int totalLenList = word_count * size_of_one_word;
	        ArrayList<Integer> res = new ArrayList<>();

	        if(n < totalLenList)
	        {
	            return res;
	        }

	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        for(String val : words) {
	            map.put(val , map.getOrDefault(val , 0) + 1);
	        }

	        //for(int i = 0 ; i < n - totalLenList ; i++) {
	        for(int i = 0 ; i < n - totalLenList + 1 ; i++) {
	            int j = i;
	            int count = word_count;
	            HashMap<String, Integer> tempMap = (HashMap<String, Integer>)map.clone();

	            while(j < i + totalLenList) {
	                String word = s.substring(j, j + size_of_one_word);

	                if(!tempMap.containsKey(word) || tempMap.get(word) == 0) {
	                    break;
	                }
	                else {
	                    tempMap.put(word, tempMap.get(word) - 1);
	                    count--;
	                }

	                j = j + size_of_one_word;
	            }

	            if(count == 0) {
	                res.add(i);
	            }
	        }

	        return res;
	    }
}

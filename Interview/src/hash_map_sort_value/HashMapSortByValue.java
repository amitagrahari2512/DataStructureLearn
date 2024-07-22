package hash_map_sort_value;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// Sort HashMap by value and if two values same sort by keys
public class HashMapSortByValue {
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		map.put(7, 1);
		
		System.out.println("Old Way ::: " + sortByValueOld(map));
		System.out.println("Lambda Way ::: " + sortByValueNew(map));
		
	}
	
	
	private static Map sortByValueNew(HashMap<Integer, Integer> map) {
		Map<Integer, Integer> sortMap = map.entrySet().stream()
		.sorted((a,b) -> 
		a.getValue().compareTo(b.getValue()) == 0 ? 
				a.getKey().compareTo(b.getKey()) : 
					a.getValue().compareTo(b.getValue()))
					.collect(Collectors.toMap(
							Map.Entry :: getKey, 
							Map.Entry :: getValue,
							(e1, e2) -> e1 , LinkedHashMap::new));
		return sortMap;
	}


	public static Map sortByValueOld(HashMap<Integer, Integer> map) {
		HashMap<Integer, Integer> sortMap = new LinkedHashMap<>();
		LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue().compareTo(o2.getValue()) == 0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Map.Entry<Integer, Integer> entry : list) {
			sortMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortMap;
	}
}

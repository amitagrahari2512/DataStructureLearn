package doubly_linked_list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUImplementationViaInBuiltDoublyLinkedList {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
	}
}

class LRUCache {
	int capacity;
	Map<Integer, Integer> cacheMap;
	LinkedList<Integer> lruList;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<>();
		lruList = new LinkedList();
	}
	
	public void put(int key, int value) {
		if(cacheMap.containsKey(key)) {
			cacheMap.put(key, value);
			lruList.remove(Integer.valueOf(key));
		}
		else {
			if(cacheMap.size() >= capacity) {
				int removeLast = lruList.removeLast();
				cacheMap.remove(removeLast);
			}
			cacheMap.put(key, value);
		}
		lruList.addFirst(key);
	}
	
	public int get(int key) {
		if(!cacheMap.containsKey(key)) {
			return -1;
		}
		
		lruList.remove(Integer.valueOf(key));
		lruList.addFirst(key);
		
		return cacheMap.get(key);
	}
}
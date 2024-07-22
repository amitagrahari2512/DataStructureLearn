package lru;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



/**
 * 
 * 
 * 
 * Screening - Implement an LRU evicted cache with priorities and time. 
 * Expired cache entries should be evicted first. 
 * Then we should evice based on priority where an entry is chosen based on LRU policy Trapping of 
 * rain water leetcode medium problem and as an improvement I was asked to do the same in 2-d array 
 * One leetcode medium problem where it was required to sort the array and then perform some operation on it.
 *  Two rounds of system design.

 *
 */
public class LRUTest {
	
	Deque<CacheItem> listCache = new LinkedList<>();
	Map<String, CacheItem> cacheMap = new HashMap<>();
	//Map<String, List<CacheItem>> cacheMap = new HashMap<>();
	Map<Integer, HashSet<String>> expriryMap = new HashMap<>();
	Map<Integer, HashSet<String>> priorityMap = new HashMap<>();
	int capacity;
	
	public LRUTest(int capacity) {
		this.capacity = capacity;
	}

	public static void main(String[] args) {
		LRUTest t = new LRUTest(5);
		t.setCache("A", 5, 1, 1000);
		t.setCache("B", 15, 5, 500);
		t.setCache("C", 0, 5, 2000);
		t.setCache("D", 1, 5, 2000);
		t.setCache("E", 10, 5, 3000);
		
		t.getCache("C");
		
		t.setCache("F", 15, 5, 1000);
		
		t.setCache("G", 0, 5, 2000);
		
		t.setCache("H", 1, 5, 2000);
		
		System.out.println(t.listCache);
		
		t.getCache("D");
		t.setCache("I", 10, 2, 2000);
		//t.setCache("E", 10, 2, 2000);
		//t.setCache("M", 10, 1, 3000);
		
		
		
		
	}
	
	public void getCache(String key) {
		CacheItem c = cacheMap.get(key);
		System.out.println(listCache);
		listCache.remove(c);
		listCache.push(c);
		System.out.println(listCache);
	}
	
	public void setCache(String key, int value, int priority, int time) {
		CacheItem c = new CacheItem(key, value, priority, time);
		
		if(this.capacity == listCache.size()) {
			TreeSet<Integer> s = new TreeSet(this.expriryMap.keySet());
			Integer setTime = s.pollFirst();
			HashSet<String> setTimeValues = this.expriryMap.get(setTime);
			if(setTimeValues.size() > 1) {
				//check for priority
				TreeSet<Integer> sp= new TreeSet(this.priorityMap.keySet());
				Integer setPriority = sp.pollFirst();
				HashSet<String> setPriorityValues = this.priorityMap.get(setPriority); 
				if(setPriorityValues.size() > 1) {
					System.out.println(listCache);
					CacheItem lastItem = listCache.removeLast();
					String k = lastItem.key;
					int p = lastItem.priority;
					int t = lastItem.time;
					System.out.println("priorityMap : " + priorityMap);
					System.out.println("expriryMap : " + expriryMap);
					HashSet<String> prioritySet = priorityMap.get(p);
					prioritySet.remove(k);
					priorityMap.put(p, prioritySet);
					HashSet<String> timeSet = expriryMap.get(t);
					timeSet.remove(k);
					expriryMap.put(t, timeSet);
					
					
					System.out.println("priorityMap : " + priorityMap);
					System.out.println("expriryMap : " + expriryMap);
					System.out.println(listCache);
					
				}
				else {
					//Delete from all System
					String saveKey = null;
					Set<String> prioritySet = priorityMap.get(setPriority);
					Iterator i = prioritySet.iterator();
					if(i.hasNext()) {
						saveKey = (String)i.next();
					}
					priorityMap.remove(setPriority);
					CacheItem ci = cacheMap.get(saveKey);
					
					Set<String> timeSet = expriryMap.get(ci.time);
					timeSet.remove(ci.key);
					
					listCache.remove(ci);
				}
			}
			else {
				//Delete from all System
				String saveKey = null;
				Set<String> timeSet = expriryMap.get(setTime);
				Iterator i = timeSet.iterator();
				if(i.hasNext()) {
					saveKey = (String)i.next();
				}
				expriryMap.remove(setTime);
				CacheItem ci = cacheMap.get(saveKey);
				
				Set<String> prioritySet = priorityMap.get(ci.priority);
				prioritySet.remove(ci.key);
				
				listCache.remove(ci);
			}
			
		}
		//else {
			listCache.push(c);
			
			cacheMap.put(key, c);
			
			/*
			if(cacheMap.containsKey(key)) {
				List<CacheItem> l = cacheMap.get(key);
				l.add(c);
				cacheMap.put(key, l);
			}
			else {
				List<CacheItem> l = new ArrayList<>();
				l.add(c);
				cacheMap.put(key, l);
			}
			*/
			
			if(expriryMap.containsKey(time)) {
				HashSet<String> h = expriryMap.get(time);
				h.add(key);
				expriryMap.put(time, h);
			}
			else {
				HashSet<String> h = new HashSet<>();
				h.add(key);
				expriryMap.put(time, h);
			}
			
			if(priorityMap.containsKey(priority)) {
				HashSet<String> h = priorityMap.get(priority);
				h.add(key);
				priorityMap.put(priority, h);
			}
			else {
				HashSet<String> h = new HashSet<>();
				h.add(key);
				priorityMap.put(priority, h);
			}
		//}
	}

}

class CacheItem {
	String key;
	int value;
	int priority;
	int time;
	
	public CacheItem(String key, int value, int priority, int time) {
		this.key = key;
		this.value = value;
		this.priority = priority;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return key + ">>" + "value" + ">>" + priority + ">>" + time;
	}
}

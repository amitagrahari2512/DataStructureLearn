package lru;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class LruWithExpirationTimePriority implements Runnable{

	int capacity = 5;
	PriorityQueue<LRU> lru = new PriorityQueue<>(new LRUComparatorByEvictTime());
	HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		LruWithExpirationTimePriority l = new LruWithExpirationTimePriority();
		l.addCache(1, 10, 10);
		l.addCache(2, 20, 20);
		l.addCache(3, 30, 30);
		l.addCache(4, 40, 40);
		l.addCache(5, 50, 50);
		l.addCache(6, 25, 30);
		System.out.println(l.lru);
	}
	
	public void addCache(int item, int priority, int time) {
		LRU lruObj = new LRU(item, priority, time);
		lru.add(lruObj);
	}

	@Override
	public void run() {
		//lru.
	}

}

class LRUComparatorByEvictTime implements Comparator<LRU>{

	@Override
	public int compare(LRU o1, LRU o2) {
		//System.out.println("o1.evictTime : " + o1.evictTime + " : o2.evictTime" + o2.evictTime);
		if(o1.evictTime.compareTo(o2.evictTime) == 0) {
			System.out.println("Priority Wise Check");
			return o1.priority - (o2.priority);
		}
		return o1.evictTime.compareTo(o2.evictTime);
		//return o2.evictTime.compareTo(o1.evictTime);
	}
	
}

class LRU implements Comparable<LRU>{
	int item;
	int evictTimeMin;
	int priority;
	Date evictTime;
	
	public LRU(int item, int priority, int evictTimeMin) {
		this.item = item;
		this.evictTimeMin = evictTimeMin;
		this.priority = priority;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		//c.add(Calendar.HOUR_OF_DAY, evictTimeMin); 
		c.add(Calendar.SECOND, evictTimeMin);
		evictTime = c.getTime();
	}

	@Override
	public int compareTo(LRU o) {
		return o.priority - this.priority;
	}

	@Override
	public String toString() {
		return item + " : " + priority + " : " + evictTime;
	}
	
	
}

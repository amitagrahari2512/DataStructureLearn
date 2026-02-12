package doubly_linked_list;

import java.util.HashMap;
import java.util.Map;

public class LFUImplementation {
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(2);
	    cache.put(1, 1); 
	    cache.put(2, 2);
	    System.out.print(cache.get(1) + " ");
	    cache.put(3, 3);
	    System.out.print(cache.get(2) + " ");
	    cache.put(4, 4);
	    System.out.print(cache.get(3) + " ");
	  	System.out.print(cache.get(4) + " ");
	    cache.put(5, 5);
	    System.out.print(cache.get(5) + " ");
	    System.out.print(cache.get(1) + " ");
	}
}

class LFUCache {
	int capacity;
	int minFreq;
	Map<Integer, NNode> keyNodeMap; //Key, KeyNode
	Map<Integer, DoublyLinkedList> freqMap; //Freq, DoublyLinkedList
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minFreq = 0;
		keyNodeMap = new HashMap<>();
		freqMap = new HashMap<>();
	}
	
	public void put(int key, int value) {
		if(capacity == 0) return;
		
		if(keyNodeMap.containsKey(key)) {
			NNode node = keyNodeMap.get(key);
			node.value = value;
			updateFrequency(node);
			return;
		}
		
		if(keyNodeMap.size() == capacity) {
			DoublyLinkedList minList = freqMap.get(minFreq);
			NNode toRemove = minList.removeLast();
			keyNodeMap.remove(toRemove.key);
		}
		
		NNode newNode = new NNode(key, value);
		keyNodeMap.put(key, newNode);
		freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);
		minFreq = 1;
		
	}
	
	public int get(int key) {
		if(!keyNodeMap.containsKey(key)) {
			return -1;
		}
		
		NNode node = keyNodeMap.get(key);
		updateFrequency(node);
		
		return node.value;
	}
	
	public void updateFrequency(NNode node) {
		int freq = node.freq;
		DoublyLinkedList oldList = freqMap.get(freq);
		oldList.remove(node);
		
		if(freq == minFreq && oldList.size == 0) {
			minFreq++;
		}
		
		node.freq++;
		
		freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
	}	
}

class DoublyLinkedList {
	NNode head, tail;
	int size;
	
	public DoublyLinkedList() {
		head = new NNode(0,0);
		tail = new NNode(0,0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void addFirst(NNode node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
		size++;
	}
	
	public void remove(NNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
	}
	
	public NNode removeLast() {
		if(size == 0) return null;
		NNode last = tail.prev;
		remove(last);
		return last;
	}
	
}

class NNode {
	int key, value, freq;
	NNode prev, next;

	public NNode(int key, int value) {
		super();
		this.key = key;
		this.value = value;
		this.freq = 1;
	}
}

package doubly_linked_list;

import java.util.HashMap;
import java.util.Map;

public class LRUImplementationTTL {
	
	public static void main(String[] args) throws InterruptedException {
		LRU cache = new LRU(2);
        cache.put(1, 1, 100);
        cache.put(2, 2, 2000);
        
        Thread.sleep(2000);
        
        System.out.println(cache.get(1));
        cache.put(3,3, 3000);
        System.out.println(cache.get(2));
        cache.put(4, 4, 4000);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
	}
	
	static class LRU{
		
		Map<Integer, Node> cacheMap;
		Node head;
		Node tail;
		
		public LRU(int capacity) {
			cacheMap = new HashMap<>();
			head = new Node(-1, -1, Long.MAX_VALUE);
			tail = new Node(-1, -1, Long.MAX_VALUE);
			this.head.next = tail;
			this.tail.prev = head;
		}
		
		public void put(int key, int value, long ttl) {
			if(cacheMap.containsKey(key)) {
				Node oldNode = cacheMap.get(key);
				remove(oldNode);
			}
			
			Node node = new Node(key, value, ttl);
			cacheMap.put(key, node);
			add(node);
		}
		
		public int get(int key) {
			if(!cacheMap.containsKey(key)) {
				return -1;
			}
			
			Node node = cacheMap.get(key);
			
			if(System.currentTimeMillis() > node.ttl) {
				remove(node);
				cacheMap.remove(node);
				return -1;
			}
			
			add(node);
			return node.value;
		}
		
		public void add(Node node) {
			Node nextNode = head.next;
			head.next = node;
			node.next = nextNode;
			node.prev = head;
			nextNode.prev = node;
		}
		
		public void remove(Node node) {
			Node prevNode = node.prev;
			Node nextNode = node.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}
	}

	static class Node {
		int key;
		int value;
		Node next;
		Node prev;
		long ttl;
		
		public Node(int key, int value, long ttl) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
			this.ttl = System.currentTimeMillis() + ttl;;
		}
		
	}
}

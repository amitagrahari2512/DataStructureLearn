package doubly_linked_list;

import java.util.HashMap;
import java.util.Map;

public class LRUImplementation {
	public static void main(String[] args) {
		LRU cache = new LRU(2);
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

class LRU{
	
	int capacity;
	Map<Integer, Node> cacheMap;
	Node head;
	Node tail;
	
	public LRU(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		this.head.next = tail;
		this.tail.prev = head;
	}
	
	public void put(int key, int value) {
		if(cacheMap.containsKey(key)) {
			Node oldNode = cacheMap.get(key);
			remove(oldNode);
		}
		
		Node node = new Node(key, value);
		cacheMap.put(key, node);
		add(node);
		
		if(cacheMap.size() > capacity) {
			Node nodeToDelete = tail.prev;
			remove(nodeToDelete);
			cacheMap.remove(nodeToDelete.key);
		}
	}
	
	public int get(int key) {
		if(!cacheMap.containsKey(key)) {
			return -1;
		}
		
		Node node = cacheMap.get(key);
		remove(node);
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

class Node {
	int key;
	int value;
	Node next;
	Node prev;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
}

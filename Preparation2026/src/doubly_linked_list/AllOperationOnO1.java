package doubly_linked_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 
 * We can add key and we can delete key as well, 
 * We want to get maxKey and minKey, 
 * But we want to do all operation in O(1) only. 
 * void addKey(String key); 
 * void decrementKey(String key); 
 * String minKey(); 
 * String maxKey();
 * 
 */

public class AllOperationOnO1 {
	public static void main(String[] args) {
		AllOperation all = new AllOperation();
		all.addKey("A");
		all.addKey("B");
		all.addKey("A");
		all.addKey("A");
		all.decrementKey("A");
		all.addKey("C");
		
		System.out.println("Get Max Key : " + all.getMaxKey());
		System.out.println("Get Min Key : " + all.getMinKey());
		
		all.decrementKey("B");
		
		System.out.println("Get Max Key : " + all.getMaxKey());
		System.out.println("Get Min Key : " + all.getMinKey());
	}
	
}

class AllOperation {
	private Map<String, Node> map;
	private Node head, tail;
	
	public AllOperation() {
		map = new HashMap<>();
		head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;
	}	
	public void addKey(String key) {
		if(!map.containsKey(key)) {
			if(head.next.count != 1) {
				inserAfter(head, new Node(1));
			}
			head.next.keys.add(key);
			map.put(key, head.next);
		}
		else {
			Node curr = map.get(key);
			Node next = curr.next;
			
			if(next == tail || next.count != curr.count + 1) {
				next = new Node(curr.count + 1);
				inserAfter(curr, next);
			}
			
			next.keys.add(key);
			map.put(key, next);
			
			curr.keys.remove(key);
			if(curr.keys.isEmpty()) { 
				remove(curr);
			}
		}
	}

	public void decrementKey(String key) {
		if(!map.containsKey(key)) return;
		
		Node curr = map.get(key);
		if(curr.count == 1) {
			map.remove(key);
		}
		else {
			Node prev = curr.prev;
			if(prev == head || prev.count != curr.count - 1) {
				prev = new Node(curr.count - 1);
				inserAfter(curr.prev, prev);
			}
			
			prev.keys.add(key);
			map.put(key, prev);
		}
		
		curr.keys.remove(key);
		if(curr.keys.isEmpty()) { 
			remove(curr);
		}
	}
	
	public String getMaxKey() {
		if(tail.prev == head) return "";
		return tail.prev.keys.iterator().next();
	}

	public String getMinKey() {
		if(head.next == tail) return "";
		return head.next.keys.iterator().next();
	}
	

	private void inserAfter(Node prev, Node node) {
		node.next = prev.next;
		node.prev = prev;
		prev.next.prev = node; 
		prev.next = node;
	}
	
	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	
	class Node {
		int count;
		Set<String> keys;
		Node prev;
		Node next;
		
		Node(int count) {
			this.count = count;
			this.keys = new HashSet<>();
		}
	}

}



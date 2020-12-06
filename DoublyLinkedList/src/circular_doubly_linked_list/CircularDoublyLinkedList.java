package circular_doubly_linked_list;


public class CircularDoublyLinkedList {
	Node start;
	
	static class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public void insertBegin(int data) {
		
		Node last = start.prev;
		
		Node newNode = new Node(data);
		
		newNode.next = start;
		newNode.prev = last;
		
		last.next = start.prev = newNode;
		
		start = newNode;
		
	}
	
	public void insertAfter(int data, int afterData) {
		Node newNode = new Node(data);
		Node temp = start;
		while(temp.data != afterData) {
			temp = temp.next;
		}
		
		Node next = temp.next;
		
		temp.next = newNode;
		newNode.next = next;
		newNode.prev = temp;
		next.prev = newNode;
		
	}
	
	public void insertEnd(int data) {
		Node newNode = new Node(data);
		if(start == null) {
			newNode.next = newNode.prev = newNode;
			start = newNode;
			return;
		}
		
		Node last = start.prev;
		
		last.next = newNode;
		newNode.prev = last;
		newNode.next = start;
		start.prev = newNode;
	}
	
	public void delete(int key) {
		if(start == null)
			return;
		
		Node prev = null;
		Node curr = start;
		
		while(curr.data != key) {
			if(curr.next == start) {
				System.out.println("Does not have that node");
				return;
			}
			prev = curr;
			curr = curr.next;
		}
		
		//Only node in list
		if(curr.next == start && prev == null) {
			start = null;
		}
		
		//If list ahve more than one node
		
		//check if it is first node
		if(curr == start) {
			prev = start.prev;
			start = start.next;
			prev.next = start;
			start.prev = prev;
			
		}
		//Check if it is the last node
		else if(curr.next == start) {
			prev.next = start;
			start.prev = prev;
		}
		else {
			Node temp = curr.next;
			prev.next = temp;
			temp.prev = prev;
		}
	}
	
	public void printList() {
		Node temp = start;
		while(temp.next != start) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}
	
	public void printCircularLinkedList() {
		Node temp = start;
		System.out.println("Traversal in forward Direction");
		while(temp.next != start) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print(temp.data + " ");
		
		System.out.println();
		System.out.println("Traversal in backword Direction");
		Node last = start.prev;
		temp = last;
		while(temp.prev != last) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.print(temp.data + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularDoublyLinkedList c = new CircularDoublyLinkedList();
		c.insertEnd(50);
		c.insertBegin(10);
		c.insertBegin(5);
		c.insertBegin(3);
		c.insertBegin(1);
		c.insertAfter(20, 10);
		c.printCircularLinkedList();
		
		//Delete Start Node
		c.delete(1);
		c.printList();
		
		//Delete End Node
		c.delete(50);
		c.printList();
		
		//Delete Middle Node
		c.delete(10);
		c.printList();
	}
}

package doubly_linked_list;

public class DoublyLinkedList {
	
	Node head;
	
	static class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		
		if(head != null)
			head.prev = newNode;
		
		head = newNode;
	}
	
	public void insertAfterNode(Node prevNode, int data) {
		if(prevNode==null)
			System.out.println("Previous Node can not be null");
		
		Node newNode = new Node(data);
		
		newNode.next = prevNode.next;
		
		prevNode.next = newNode;
		
		newNode.prev = prevNode;
		
		if(newNode.next != null)
			newNode.next.prev = newNode;
	}
	
	//Insert Node End
	public void append(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		
		Node last = head;
		if(head ==  null) {
			newNode.prev = null;
			head = newNode;
			return;
		}
		
		while(last.next != null)
			last = last.next;
		
		last.next = newNode;
		newNode.prev = last;
	}
	
	public void insertNodeBefore(Node nextNode,int data) {
		
		if(nextNode == null) {
			System.out.println("Next node can not be null");
		}
		
		Node newNode = new Node(data);
		newNode.next = nextNode;
		newNode.prev = nextNode.prev;
		nextNode.prev = newNode;
		
		if(newNode.prev != null)
			newNode.prev.next = newNode;
		
	}
	
	public void printDoublyList() {
		
		if(head == null)
			return;
		
		Node last = null;
		Node node = head;
		System.out.println("Traverse in Forward direction");
		while(node != null) {
			System.out.print(node.data+" ");
			last = node;
			node = node.next;
		}
		
		System.out.println();
		System.out.println("Traverse in Backword direction");
		
		while(last != null) {
			System.out.print(last.data+" ");
			last = last.prev;
		}
	}
	
	public void deleteNode(Node del) {
		if(head == del)
		{
			head =del.next;
		}
		
		if(del.next!=null)
		{
			del.next.prev = del.prev;
		}
		
		if(del.prev!=null)
		{
			del.prev.next = del.next;
		}
	}
	
	public void reverseDoublyLinkedList() {
		Node temp = null;
		Node current = head;
		while(current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		if(temp != null)
			head = temp.prev;
		
	}
	
	public static void main(String[] args) {
		DoublyLinkedList d = new DoublyLinkedList();
		
		d.push(20);
		d.push(10);
		d.append(80);
		d.insertAfterNode(d.head.next, 30);
		d.insertNodeBefore(d.head.next, 12);
		d.printDoublyList();
		d.deleteNode(d.head.next.next);
		System.out.println();
		d.printDoublyList();
		
		d.reverseDoublyLinkedList();
		System.out.println("Reverse a doubly Linked List");
		d.printDoublyList();
	}
}

package circular_linked_list;

public class CircularLinkedList {
	Node head = null;
	static class Node {
		int data;
		Node next;
	}
	
	public void push(int data) {
		Node node  = new Node();
		node.data = data;
		node.next = head;
		
		Node temp = head;
		
		if(head != null) {
			while(temp.next != head) {
				 	temp = temp.next;
			}
			temp.next = node;
		}
		else {
			node.next = node;
		}
		head = node;
	}
	
	public void printList() {
		
		Node temp = head;
		if(head != null) {
			do {
				System.out.print(temp.data+" ");
				temp = temp.next;
			} while(temp != head);
		}
	}
	
	public static void main(String[] args) {
		CircularLinkedList c = new CircularLinkedList();
		c.push(1);
		c.push(2);
		c.push(3);
		c.push(4);
		c.printList();
	}
}

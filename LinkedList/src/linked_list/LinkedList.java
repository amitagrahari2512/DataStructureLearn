package linked_list;

public class LinkedList {

	Node head;
	
	public static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void printLinkedList() {
		Node n = head;
		while (n!=null) {
			System.out.print(n.data+ " ");
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		
		lList.head = n1;
		n1.next = n2;
		n2.next = n3;
		
		lList.printLinkedList();
	}
}

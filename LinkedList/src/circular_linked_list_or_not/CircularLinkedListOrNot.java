package circular_linked_list_or_not;

public class CircularLinkedListOrNot {

	Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public boolean isCircularLinkedlistOrNot() {
		if(head == null)
			return true;
		
		Node node = head.next;
		
		while(node != null  && node != head) {
			node = node.next;
		}
		
		return (node == head);
	}
	
	public static void main(String[] args) {
		CircularLinkedListOrNot ci = new CircularLinkedListOrNot();
		Node node = new Node(10);
		ci.head = node;
		Node node1 = new Node(20);
		node.next = node1;
		Node node2 = new Node(30);
		node1.next = node2;
		
		System.out.println("isCircular Linked List : " + ci.isCircularLinkedlistOrNot());
		
		node2.next = ci.head;
		System.out.println("isCircular Linked List : " + ci.isCircularLinkedlistOrNot());
		
		
	}
}

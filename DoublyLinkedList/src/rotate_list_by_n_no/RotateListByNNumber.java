package rotate_list_by_n_no;

public class RotateListByNNumber {

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
	
	public void rotateDoublyListByNNo(int n) {
		
		if(n == 0)
			return;
		
		if(head == null)
			return;
		
		Node current = head;
		int count = 1;
		while(count < n && current != null) {
			current = current.next;
			count++;
		}
		
		Node NthNode = current;
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = head;
		
		head.prev = current;
		
		head = NthNode.next;
		
		head.prev = null;
		
		NthNode.next = null;
		
	}
	
	public void printDoublyList() {
			
			if(head == null)
				return;
			
			Node last = null;
			Node node = head;
			while(node != null) {
				System.out.print(node.data+" ");
				last = node;
				node = node.next;
			}
	}
	
	public static void main(String[] args) {
		RotateListByNNumber r = new RotateListByNNumber();
		r.push(5);
		r.push(4);
		r.push(3);
		r.push(2);
		r.push(1);
		r.rotateDoublyListByNNo(2);
		r.printDoublyList();
	}
}

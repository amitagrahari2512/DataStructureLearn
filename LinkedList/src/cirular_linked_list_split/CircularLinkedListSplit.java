package cirular_linked_list_split;


public class CircularLinkedListSplit {
	Node head = null;
	Node head1, head2;
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
	
	public void splitCircularList() {
		Node slowPtr = head;
		Node fastPtr = head;
		
		if(head == null)
			return;
		

        /* If there are odd nodes in the circular list then 
         fast_ptr->next becomes head and for even nodes  
         fast_ptr->next->next becomes head */
		while(fastPtr.next != head && fastPtr.next.next != head) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		/* If there are even elements in list then move fast_ptr */
		if(fastPtr.next.next == head) {
			fastPtr = fastPtr.next;
		}
		
		 /* Set the head pointer of first half */
		head1 = head;
		
		/* Set the head pointer of second half */
		if(head.next != head) {
			head2 = slowPtr.next;
		}
		
		/* Make second half circular */
		fastPtr.next = slowPtr.next;
		
		/* Make first half circular */
		slowPtr.next = head;
		
	}
	
	public void printSplitList() {
			
			Node temp = head1;
			if(head1 != null) {
				System.out.println("Circular linked List part1 : ");
				do {
					System.out.print(temp.data+" ");
					temp = temp.next;
				} while(temp != head1);
			}
			System.out.println();
			temp = head2;
			if(head2 != null) {
				System.out.println("Circular linked List part2 : ");
				do {
					System.out.print(temp.data+" ");
					temp = temp.next;
				} while(temp != head2);
			}
		}
	
	public static void main(String[] args) {
		CircularLinkedListSplit c = new CircularLinkedListSplit();
		c.push(1);
		c.push(2);
		c.push(3);
		c.push(4);
		c.push(5);
		c.splitCircularList();
		c.printSplitList();
	}
}

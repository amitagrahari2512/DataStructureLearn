package circular_linked_list;

public class InsertInSortedCircularLinkedList {
	
	Node head;
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	void insertInList(Node newNode) {
		Node current = head;
		
		if(current == null) {
			newNode.next = newNode;
			head = newNode;
		}
		else if(current.data >= newNode.data) {
			while(current.next != head) {
				current = current.next;
			}
			
			current.next = newNode;
			newNode.next = head;
			head = newNode;
		}
		else {
			while(current.next != head && current.next.data < newNode.data) {
				current = current.next;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
	void printList() {
		if (head != null) 
        { 
            Node temp = head; 
            do
            { 
                System.out.print(temp.data + " "); 
                temp = temp.next; 
            }  while (temp != head); 
        } 
	}
	
	public static void main(String[] args) {
		InsertInSortedCircularLinkedList in = new InsertInSortedCircularLinkedList();
		int[] inArr = new int[] {
			10,8,12,15,11	
		};
		for (int i = 0; i < inArr.length; i++) {
			Node newNode = new Node(inArr[i]);
			in.insertInList(newNode);
		}
		in.printList();
		
		
	}
}

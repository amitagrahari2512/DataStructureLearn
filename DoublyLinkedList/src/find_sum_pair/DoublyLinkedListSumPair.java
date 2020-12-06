package find_sum_pair;


public class DoublyLinkedListSumPair {
	
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
	
	public void findPairSum(int sum) {
		Node first = head;
		Node last = head;
		boolean found = false;
		
		while(last.next!=null) {
			last = last.next;
		}
		
		while(first != null && last != null 
				&& first != last && last.next != first) {
			
			if((first.data + last.data) == sum) {
				found = true;
				System.out.println("("+first.data+ " , "+ last.data+")");
				first = first.next;
				last = last.prev;
			}
			else {
				if((first.data + last.data) < sum) {
					first = first.next;
				}
				else {
					last =last.prev;
				}
			}
		}
		
		if(!found) {
			System.out.println("No Pair found");
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedListSumPair d = new DoublyLinkedListSumPair();
		d.push(9);
		d.push(8);
		d.push(6);
		d.push(5);
		d.push(4);
		d.push(2);
		d.push(1);
		int sum = 7;
		
		d.findPairSum(sum);
	}
}

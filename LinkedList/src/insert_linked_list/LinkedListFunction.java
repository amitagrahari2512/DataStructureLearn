package insert_linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListFunction {
	
	Node head;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next= head;
		
		head = newNode;
	}
	
	public void insertAfter(Node preNode, int data) {
		if(preNode == null) 
		{
			System.out.println("Previous Node can not be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = preNode.next;
		
		preNode.next = newNode;
		
	}
	
	public void append(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		 
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = newNode;
	}
	
	public void delete(int key) {
		Node temp = head;
		Node previous = null;
		
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}
		
		if(temp == null)
			return;
		
		previous.next = temp.next;
	}
	
	public void deleteAtGivenposition(int position) {
		Node temp = head;
		if(head == null) {
			return;
		}
		
		if(position == 0) {
			head = null;
		}
		
		for (int i = 0; i < position-1 && temp != null; i++) {
			temp = temp.next;
		}
		
		if(temp == null || temp.next == null)
		{
			System.out.println("Position " + position+" is greater than element in Linked List");
			return;
		}
		
		Node next = temp.next.next;
		temp.next = next;
		
	}
	
	public void deleteList() {
		head = null;
	}
	
	public void iterateList() {
		Node iterate = head;
		if(iterate == null) {
			System.out.println("No data in List ");
			return;
		}
		System.out.println("Data In linked list:");
		while(iterate != null) {
			System.out.print(iterate.data + " ");
			iterate = iterate.next; 
		}
		System.out.println("");
	}
	
	public int getCount() {
		int count = 0;
		Node temp = head;
		if(temp == null) {
			return 0;
		}
		
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int getCountRecursively() {
		return returnCountRecursively(head);
	}
	
	public int returnCountRecursively(Node node) {
		if(node == null)
			return 0;
		
		return 1 + returnCountRecursively(node.next);
	}
	
	public boolean searchItem(int key) {
		
		Node temp = head;
		while(temp != null) {
			if(temp.data == key) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public boolean searchItemRecursively(int key) {
		return returnItemRecursively(head, key);
	}
	
	public boolean returnItemRecursively(Node head, int key) {
		if(head == null)
			return false;
		
		Node temp = head;
		if(temp.data == key)
			return true;
		
		return returnItemRecursively(temp.next, key);
	}
	
	public int getNthNode(int n) {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			if(count == n-1) {
				return temp.data;
			}
			count++;
			temp = temp.next;
		}
		
		return -1;
	}
	
	public int getNthNodeRecursively(int n) {
		return returnNthNodeRecursively(head, n);
	}
	
	public int returnNthNodeRecursively(Node head,int n) {
		int count = 1;
		if(head == null) {
			return -1;
		}
		
		if(count == n) {
			return head.data;
		}
		
		return returnNthNodeRecursively(head.next, n-1);
	}
	
	public void getNthNodeFromEnd(int n) {
		int len = 0;		
		Node temp = head;
		
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		
		if(len < n) {
			System.out.println("List size is less than provided Node need to fetch");
		}
		
		temp = head;
		
		for (int i = 1; i < len - n + 1; i++) {
			temp = temp.next;
		}
		
		System.out.println("Node no. " + n + " from last is " + temp.data); 
	}
	
	public void getNthNodeFromEndTwoPointer(int n) {
		if(head == null)
			return;
		int count = 0;
		
		Node mainPtr = head;
		Node refPtr = head;
		
		if(head != null ) {
			while(count < n) {
				if(refPtr == null) {
					System.out.println(n + " is greater than the no "
                            + " of nodes in the list");
				}
				refPtr = refPtr.next;
				count++;
			}
			
			while(refPtr != null) {
				mainPtr = mainPtr.next;
				refPtr = refPtr.next;
			}
			
			System.out.println("Two Pointer use : Node no. " + n + " from last is " + mainPtr.data); 
		}
		
	}
	
	public int findMiddleElementFromTwoPointer() {
		Node slowPtr = head;
		Node fastPtr = head;
		if(head != null) {
			while(fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			}
			return slowPtr.data;
		}
		return -1;
	}
	
	public void detectLoopViaSet() {
		Set<Node> set = new HashSet<>();
		boolean isLoop = false;
		Node temp = head;
		while(temp != null) {
			if(set.contains(temp)) {
				isLoop = true;
				break;
			}
			set.add(temp);
			temp =temp.next;
		}
		
		if(isLoop) {
			System.out.println("Loop Found in node via set : "+temp.data);
		}
		else {
			System.out.println("loop Not Found");
		}
	}
	
	public void detectLoop() {
		Node slowPtr = head;
		Node fastPtr = head;
		int flag = 0;
		
		while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr) {
				flag = 1;
				break;
			}
		}
		
		if(flag == 1) {
			System.out.println("Loop Found in node: "+slowPtr.data);
		}
		else {
			System.out.println("loop Not Found");
		}
	}
	
	public int countLoopLength(Node n) {
		int count = 1;
		Node temp = n;
		while( temp.next != n) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int detectLoopLength() {
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(fastPtr == slowPtr) {
				return countLoopLength(slowPtr);
			}
		}
		return 0;
	}
	
	public void removeLoop(Node slow) {
		Node ptr1 = head;
		Node ptr2 = slow;
		while (1 == 1) {
			while(ptr2.next != slow && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}
			
			if(ptr2.next == ptr1) {
				break;
			}
			
			ptr1 = ptr1.next;
		}
		
		ptr2.next = null;
	}
	
	public int detectAndRemoveLoop() {
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			removeLoop(slow);
			return 1;
		}
		return 0;
	}
	
	
	public void removeLoopWithCounting(Node slow) {
		Node ptr1 = slow;
		Node ptr2 = slow;
		
		// Count the number of nodes in loop 
		int k = 1;
		while(ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}
		
		// Fix one pointer to head 
		ptr1 = head;
		
		// And the other pointer to k nodes after head 
		ptr2 = head;
		
		for(int i =0 ;i < k ;i++) {
			ptr2 = ptr2.next;
		}
		
		/*  Move both pointers at the same pace, 
        they will meet at loop starting node */
		while (ptr2 != ptr1) {
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		
		while(ptr2.next != ptr1) {
			ptr2 = ptr2.next;
		}
		
		 /* Set the next node of the loop ending node 
        to fix the loop */
       ptr2.next = null; 
		
	}
	
	public int detectAndRemoveLoopWithCounting() {
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			removeLoopWithCounting(slow);
			return 1;
		}
		return 0;
	}
	
	
	public void detectAndRemoveLoopWithOutCounting() {

		Node slow = head;
		Node fast = head;

		// Move slow and fast 1 and 2 steps 
		// ahead respectively. 
		slow = slow.next;
		fast = fast.next.next;

		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast)
				break;

			fast = fast.next.next;
			slow = slow.next;

		}

		if (slow == fast) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			fast.next = null;
		}

	}
	
	public boolean removeLoopWithHashing() 
    { 
		Node h = head;
        HashSet<Node> s = new HashSet<Node>(); 
        Node prev = null; 
        while (h != null) { 
            // If we have already has this node 
            // in hashmap it means their is a cycle and we 
            // need to remove this cycle so set the next of 
            // the previous pointer with null. 
  
            if (s.contains(h)) { 
                prev.next = null; 
                return true; 
            } 
  
            // If we are seeing the node for 
            // the first time, insert it in hash 
            else { 
                s.add(h); 
                prev = h; 
                h = h.next; 
            } 
        } 
  
        return false; 
    } 
	
	
	public void removeDuplicateFromSortedList() {
		Node curr = head;
		
		while(curr != null) {
			Node temp = curr;
			
			while(temp !=null  && temp.data == curr.data) {
				temp = temp.next;
			}
			
			curr.next = temp;
			curr = curr.next;
		}
	}
	
	public void removeDuplicateFromUnSortedList() {
		Node ptr1 = null; 
		Node ptr2 = null;
		Node dup = null;
		ptr1 = head;
		
		while(ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;
			
			while(ptr2.next !=null) {
				if(ptr1.data == ptr2.next.data)
				{
					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
				}
				else {
					ptr2 = ptr2.next;
				}
			}
			
			ptr1=ptr1.next;
		}
	}
	
	public void removeDuplicateFromHashing() {
		Node current = head;
		Node prev = null;
		Set<Integer> set = new HashSet<>();
		
		while(current != null) {
			Integer val = current.data;
			if(set.contains(val)) {
				prev.next = current.next;
			}
			else {
				set.add(val);
				prev = current;
			}
			current = current.next;
		}
	}
	
	public void swapNodes(int x, int y) {
		if(x == y)
			return;
		
		Node prevX = null;
		Node currX = head;
		
		while(currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}
		
		Node prevY = null;
		Node currY = head;
		
		while(currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}
		
		if(currX == null || currY == null)
			return;
		
		if(prevX != null) {
			prevX.next = currY;
		}
		else {
			head = currY;
		}
		
		if(prevY != null) {
			prevY.next = currX;
		}
		else {
			head = currX;
		}
		
		Node temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
		
	}
	
	public void swapPairWiseElement() {
		Node temp = head;
		
		while(temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}
	
	public void moveLastElementToFront() {
		
		Node secLast = null;
		Node last = head;
		
		while(last != null && last.next != null) {
			secLast = last;
			last = last.next;
		}
		
		secLast.next = null;
		
		last.next = head;
		
		head = last;
	}
	
	public void sortedIntersect(Node head1, Node head2) {
		Node tail = null;
		Node localHead = null;
		
		while(head1 != null && head2 != null) {
			if(head1.data == head2.data)
			{
				Node node = new Node(head1.data);
				if(tail == null) {
					tail = node;
					localHead = tail;
				}
				else {
					tail.next = node;
					tail = tail.next;
				}
				head1 = head1.next;
				head2 = head2.next;
			}
			else if(head1.data < head2.data){
				head1 = head1.next;
			}
			else {
				head2 = head2.next;
			}
		}
		
		while (localHead != null) {
			System.out.print(localHead.data + " ");
			localHead = localHead.next;
		}
	}
	
	public void oddEvenSegregate() {
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node curr = head;
		
		while (curr != null) {
			if(curr.data % 2 == 0) {
				if(evenStart == null) {
					evenStart = curr;
					evenEnd = evenStart;
				}
				else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			}
			else {
				if(oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				}
				else {
					oddEnd.next = curr;
					oddEnd = evenEnd.next;
				}
			}
			curr = curr.next;
		}
		
		if(evenEnd != null && oddEnd != null) {
			evenEnd.next = oddStart;
			oddEnd.next = null;
			head = evenStart;
		}
	}
	
	
	public void reverseLinkedList() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	public static void setForAllFunction() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.push(10);
		lList.push(20);
		lList.append(30);
		lList.append(40);
		lList.insertAfter(lList.head.next, 60);
		lList.append(5);
		
		lList.iterateList();
		
		lList.delete(30);
		System.out.println("List After deletion:");
		lList.iterateList();
		
		lList.deleteAtGivenposition(3);
		System.out.println("List After deletion at position:");
		lList.iterateList();
		
		//lList.deleteList();
		lList.iterateList();
		
		System.out.println("Simple count : " + lList.getCount());
		System.out.println("Recursively Count : " + lList.getCountRecursively());
		
		System.out.println("Search simple : "+lList.searchItem(20));
		System.out.println("Search simple : "+lList.searchItem(80));
		
		System.out.println("Search Recursively : "+lList.searchItemRecursively(20));
		System.out.println("Search Recursively : "+lList.searchItemRecursively(80));
		
		System.out.println("Get Nth Node Simple : "+lList.getNthNode(3));
		System.out.println("Get Nth Node Recursively : "+lList.getNthNodeRecursively(3));
		
		lList.getNthNodeFromEnd(2);
		lList.getNthNodeFromEndTwoPointer(2);
		
		System.out.println("Middle Pointer : " + lList.findMiddleElementFromTwoPointer());
	}
	
	public static void setForDetectLoop() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.push(10);
		lList.push(20);
		lList.append(30);
		lList.append(40);
		lList.insertAfter(lList.head.next, 60);
		lList.append(5);
		
		lList.iterateList();
		
		//Create loop for testing.
		lList.head.next.next.next.next.next.next = lList.head.next;
		
		lList.detectLoopViaSet();
		lList.detectLoop();
		System.out.println("Count Loop Length : "+lList.detectLoopLength());
		
		//lList.detectAndRemoveLoop();
		//lList.detectAndRemoveLoopWithCounting();
		//lList.detectAndRemoveLoopWithOutCounting();
		lList.removeLoopWithHashing();
		lList.iterateList();
		
	}
	
	public void swapKthNode(int k) {
		int n = getCount();
		
		if(n<k)
			return;
		
		if(2*k+1 == n)
			return;
		
		Node x = head;
		Node xPrev = null;
		for(int i=1; i<k ; i++) {
			xPrev = x;
			x = x.next;
		}
		
		Node y = head;
		Node yPrev = null;
		for(int i=1; i<n-k+1 ; i++) {
			yPrev = y;
			y = y.next;
		}
		
		if(xPrev != null)
			xPrev.next = y;
		
		if(yPrev != null)
			yPrev.next = x;
		
		Node temp = x.next;
		x.next = y.next;
		y.next = temp;
		
		//Change head pointers when k it 1 or n
		
		if(k==1)
			head = y;
		
		if(k==n)
			head = x;
	}
	
	public static void setForRemoveElementFromSortedList() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(20);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(60);
		lList.append(60);
		lList.append(60);
		lList.iterateList();
		lList.removeDuplicateFromSortedList();
		lList.iterateList();
	}
	
	public static void setForRemoveElementFromUnSortedList() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(60);
		lList.append(20);
		lList.append(60);
		lList.append(20);
		lList.append(60);
		lList.iterateList();
		lList.removeDuplicateFromUnSortedList();
		lList.iterateList();
	}
	
	public static void setForRemoveElementFromHashing() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(60);
		lList.append(20);
		lList.append(60);
		lList.append(20);
		lList.append(60);
		lList.iterateList();
		lList.removeDuplicateFromHashing();
		lList.iterateList();
	}
	
	public static void setSwapNodes() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(50);
		lList.append(60);
		lList.iterateList();
		lList.swapNodes(10, 50);
		lList.iterateList();
	}
	
	public static void setSwapPairwiseElement() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(50);
		//lList.append(60);
		lList.iterateList();
		lList.swapPairWiseElement();
		lList.iterateList();
	}
	
	public static void setMoveLastElementToFront() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(50);
		lList.append(60);
		lList.iterateList();
		lList.moveLastElementToFront();
		lList.iterateList();
	}
	
	public static void setSortedIntersect() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(50);
		lList.append(70);
		lList.append(80);
		lList.append(90);
		lList.append(100);
		lList.iterateList();
		
		LinkedListFunction lList1 = new LinkedListFunction();
		lList1.append(30);
		lList1.append(50);
		lList1.append(60);
		lList1.append(70);
		lList1.append(100);
		lList1.append(160);
		lList1.iterateList();
		
		lList.sortedIntersect(lList.head, lList1.head);
	}
	
	public static void setOddEvenSegregate() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(1);
		lList.append(2);
		lList.append(3);
		lList.append(4);
		lList.append(5);
		lList.append(6);
		lList.iterateList();
		lList.oddEvenSegregate();
		lList.iterateList();
	}
	
	public static void setReverseLinkedList() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(1);
		lList.append(2);
		lList.append(3);
		lList.append(4);
		lList.append(5);
		lList.append(6);
		lList.iterateList();
		lList.reverseLinkedList();
		lList.iterateList();
	}
	
	public static void setSwapKthNode() {
		LinkedListFunction lList = new LinkedListFunction();
		lList.append(10);
		lList.append(20);
		lList.append(30);
		lList.append(40);
		lList.append(50);
		lList.append(60);
		lList.append(70);
		lList.iterateList();
		
		System.out.println("Swap k = 1");
		lList.swapKthNode(1);
		lList.iterateList();
		
		System.out.println("Swap k = 7");
		lList.swapKthNode(7);
		lList.iterateList();
		
		System.out.println("Swap k = 2");
		lList.swapKthNode(2);
		lList.iterateList();
		
	}
	
	public static void main(String[] args) {
		//setForAllFunction();
		//setForDetectLoop();
		//setForRemoveElementFromSortedList();
		//setForRemoveElementFromUnSortedList();
		//setForRemoveElementFromHashing();
		//setSwapNodes();
		//setSwapPairwiseElement();
		//setMoveLastElementToFront();
		//setSortedIntersect();
		//setOddEvenSegregate();
		//setReverseLinkedList();
		setSwapKthNode();
	}
	
}

package leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class AddTwoNumberLinkedList {
	
	public static void main(String[] args) {
		//[2,4,9]
		//[5,6,4,9]
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(9);
		
		AddTwoNumberLinkedList a = new AddTwoNumberLinkedList();
		ListNode l = a.addTwoNumbers(l1, l2);
		
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
		
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    	 int len1 = countNode(l1);
         int len2 = countNode(l2);
         
        if(len1 < len2) {
            return addTwoNumbers(l2, l1);
       }
        

        int carry = 0;
        ListNode res = l1;

        while(l2 != null || carry != 0) {
            l1.val += carry;

            if(l2 != null) {
                l1.val += l2.val;
                l2 = l2.next;
            }

            carry = l1.val / 10;
            l1.val = l1.val  % 10;

            if(l1.next == null && carry != 0) {
                l1.next = new ListNode(0);
            }

            l1 = l1.next;
        } 

        return res;

    }

    public int countNode(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}

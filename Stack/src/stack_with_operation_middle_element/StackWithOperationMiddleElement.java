package stack_with_operation_middle_element;

public class StackWithOperationMiddleElement {
	
	class DLLNode {
		DLLNode prev;
		int data;
		DLLNode next;
		public DLLNode(int data) {
			this.data = data;
		}
	}
	
	class MyStack {
		DLLNode head;
		DLLNode mid;
		int count;
	}
	
	MyStack createMyStack() {
		MyStack myStack = new MyStack();
		myStack.count = 0;
		return myStack;
	}
	
	void push(MyStack ms, int data) {
		DLLNode newNode = new DLLNode(data);
		
		/* Since we are adding at the beginning, 
        prev is always NULL */
		newNode.prev = null;
		
		/* link the old list off the new DLLNode */
        newNode.next = ms.head; 
        
        ms.count +=1;
        
        if(ms.count == 1) {
        	ms.mid = newNode;
        }
        else {
        	ms.head.prev = newNode;
        			
        	if((ms.count % 2) != 0) { // Update mid if ms->count is odd 
        		ms.mid = ms.mid.prev;
        	}
        }
        
        /* move head to point to the new DLLNode */
        ms.head = newNode;
	}
	
	int pop(MyStack ms) {
		if(ms.count == 0)
		{
			System.out.println("Stack is empty");
			return 0;
		}
		DLLNode head = ms.head;
		int item = head.data;
		ms.head = head.next;
		
		// If linked list doesn't become empty, update prev 
        // of new head as NULL 
        if(ms.head != null) 
            ms.head.prev = null; 
		
		ms.count -= 1;
		
		// update the mid pointer when we have even number of 
        // elements in the stack, i,e move down the mid pointer. 
        if(ms.count % 2 == 0) 
            ms.mid=ms.mid.next; 
          
        return item; 
	}
	
	// Function for finding middle of the stack 
    int findMiddle(MyStack ms) 
    { 
        if(ms.count == 0) 
        { 
            System.out.println("Stack is empty now"); 
            return -1; 
        } 
        return ms.mid.data; 
    } 
	
	public static void main(String[] args) {
		StackWithOperationMiddleElement main = new StackWithOperationMiddleElement();
		MyStack stack = main.createMyStack();
		main.push(stack, 11);
		main.push(stack, 22);
		main.push(stack, 33);
		main.push(stack, 44);
		main.push(stack, 55);
		main.push(stack, 66);
		main.push(stack, 77);
		main.push(stack, 88);
		main.push(stack, 99);
		
		System.out.println("Middle Element is " + main.findMiddle(stack)); 
		System.out.println("Item popped is " + main.pop(stack)); 
		System.out.println("Middle Element is " + main.findMiddle(stack)); 
        System.out.println("Item popped is " + main.pop(stack)); 
        System.out.println("Middle Element is " + main.findMiddle(stack)); 
	}
}

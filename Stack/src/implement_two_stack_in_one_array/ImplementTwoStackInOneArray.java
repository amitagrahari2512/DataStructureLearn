package implement_two_stack_in_one_array;

public class ImplementTwoStackInOneArray {
	
	int[] arr;
	int size;
	int top1;
	int top2;
	
	public ImplementTwoStackInOneArray(int n) {
		arr = new int[n];
		top1 = -1;
		top2 = n;
		size = n;
	}
	
	public void push1(int x) {
		if(top1 < top2-1) {
			top1++;
			arr[top1] = x;
		}
		else {
			System.out.println("Stack Overflow");
			System.exit(0);
		}
	}
	
	public void push2(int x) {
		if(top1 < top2-1) {
			top2--;
			arr[top2] = x;
		}
		else {
			System.out.println("Stack Overflow");
			System.exit(0);
		}
	}
	
	public int pop1() {
		if(top1 >= 0) {
			int x = arr[top1];
			top1--;
			return x;
		}
		else {
			System.out.println("pop1 Stack underflow");
			System.exit(0);
		}
		return 0;
	}
	
	public int pop2() {
		if(top2 < size) {
			int x = arr[top2];
			top2++;
			return x;
		}
		else {
			System.out.println("pop2 Stack underflow");
			System.exit(0);
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		ImplementTwoStackInOneArray imp = new ImplementTwoStackInOneArray(5);
		imp.push1(5); 
	    imp.push2(10); 
	    imp.push2(15); 
	    imp.push1(11); 
	    imp.push2(7); 
	     
	    System.out.println(imp.pop1());
	    imp.push2(40);
	    System.out.println(imp.pop2());
	}
}



package array;

import java.util.ArrayList;
import java.util.List;

public class LargeNoFactorial {

	public static void main(String[] args) {
		//int n = 5;
		int n = 100;
		FactNode tail = new FactNode(1);
		for (int i = 2 ;i <= n; i++) {
			factorial(tail, i);
		}
		List<Integer> list = new ArrayList<>();
		printFactorial(tail, list);
		System.out.println(list);
	}
	
	public static void factorial(FactNode tail, int n) {
		FactNode temp = tail;
		FactNode prevNode = tail;
		int carry = 0;
		
		while(temp != null) {
			int data = temp.i * n + carry;
			temp.i = data % 10;
			carry = data / 10;
			prevNode = temp;
			temp = temp.prev;
		}
		
		while(carry != 0) {
			prevNode.prev = new FactNode(carry%10);
			carry = carry/10;
			prevNode = prevNode.prev;
		}
	}
	
	public static void printFactorial(FactNode tail, List<Integer> list) {
		//Print Factorial
		if(tail == null)
			return;
		printFactorial(tail.prev, list);
		list.add(tail.i);
	}
	
}


class FactNode {
	
	int i;
	FactNode prev;
	
	public FactNode(int i) {
		this.i = i;
		this.prev = null;
	}
}
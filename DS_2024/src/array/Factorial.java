package array;

import java.util.ArrayList;
import java.util.Collections;

public class Factorial {

	public static void main(String[] args) {
		ArrayList<Integer>list = new ArrayList<>();		
		int x = factorial(5);
		while(x != 0) {
			int d = x % 10;
			list.add(d);
			x = x / 10;
		}
		
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		
	}
	
	public static int factorial(int n) {
		
		if(n == 0)
			return 1;
		
		if(n == 1 )
			return 1;
		else 
			return n * factorial(n - 1);
		
	}

}

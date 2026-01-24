package list;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1, 1);
		//list.add(10, 10); Error Array index out of bound
		
		System.out.println(list);
	}
}

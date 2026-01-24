package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>(Collections.nCopies(10, 6));
		System.out.println(l);
	}
}

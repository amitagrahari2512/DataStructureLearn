package java_8_somecase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Amit");
		list.add("AMIT");
		list.add("abhi");
		
		
		List test = list.stream().distinct().collect(Collectors.toList());
		System.out.println(test);
		
		List test1 = list.stream().map(a -> a.toUpperCase()).distinct().collect(Collectors.toList());
		System.out.println(test1);
		
	}
}

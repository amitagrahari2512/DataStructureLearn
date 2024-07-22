package interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String data = "A, B, C";
		String[] strCommaArr = data.split(",");
        List<String> al = Arrays.asList(strCommaArr);
        al = al.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println(al);
	}
}

package stream.collectors;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * String "banana apple apple banana chiku chiku", 
 * print = {apple =2, banana=2, chiku = 2}
 */
public class StringToMapWithCount {
	public static void main(String[] args) {
		String str = "banana apple apple banana chiku chiku";
		Map<String, Long> map = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		
		//Same Result
		Map<String, Long> map1 = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(map1);
	}
}

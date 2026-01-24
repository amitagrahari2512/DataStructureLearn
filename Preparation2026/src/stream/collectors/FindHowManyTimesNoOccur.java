package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 
 * key = number
	value = how many times it appears
 */
public class FindHowManyTimesNoOccur {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 2, 4, 6);
		Map<Integer, Long> map = numbers.stream().collect(Collectors.groupingBy(x -> x , Collectors.counting()));
		System.out.println(map);
		
	}
}

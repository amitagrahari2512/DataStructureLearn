package stream.collectors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
Create a Map<Character, List<String>> where:

key = first character of the word

value = list of words starting with that character

Preserve insertion order of keys
 *
 */

public class FindListOfWordsStartingWithItsKeyCharacter {

	public static void main(String[] args) {
		List<String> words = List.of("java", "stream", "api", "java", "collector");
		
		Map<Character, List<String>> map = words.stream().collect(Collectors.groupingBy(x->x.charAt(0),LinkedHashMap::new, Collectors.toList()));
		System.out.println(map);
		
	}

}

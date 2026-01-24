package streamapis;

import java.util.stream.Stream;

public class StreamOf {
	public static void main(String[] args) {
		Stream s = Stream.of("A", "B", "C");
		s.forEach(System.out::println);
		s.forEach(System.out::println); // Error we get ( stream has already been operated upon or closed)
	}
}

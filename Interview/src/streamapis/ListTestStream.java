package streamapis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListTestStream {
	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.id = 1;
		
		Phone ph1 = new Phone();
		ph1.id = 1;
		Phone ph2 = new Phone();
		ph2.id = 2;

		p1.phones.add(ph1);
		p1.phones.add(ph2);
		
		
		Person p2 = new Person();
		p1.id = 1;
		
		Phone ph3 = new Phone();
		ph3.id = 3;
		Phone ph4 = new Phone();
		ph4.id = 4;

		p2.phones.add(ph3);
		p2.phones.add(ph4);
		
		
		List<Person> listPerson = List.of(p1, p2);
		
		List<String> phoneList = listPerson.stream()
				.flatMap(p -> p.phones.stream())
				.flatMap(a -> a.phoneNames.stream())
				.filter(x -> x.equals("Home"))
				.collect(Collectors.toList());
		
		System.out.println(phoneList);
		
		
		
	}
}

class Person {
	int id;
	List<Phone> phones = new ArrayList<>();
}

class Phone {
	int id;
	List<String> phoneNames = List.of("Standard", "Home");
}


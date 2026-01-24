package java_8_somecase;

public class ImpConcept {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.name = "Amit";
		
		Employee e2 = e1;
		e1 = null;
		
		//What Output will be, this will be Amit
		System.out.println(e2.name);
	}
}

class Employee {
	String name;
}

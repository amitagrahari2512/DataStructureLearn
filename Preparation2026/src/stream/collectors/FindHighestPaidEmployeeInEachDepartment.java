package stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/*
 *
 * Que:
 * Group employees by department
	Find the highest-paid employee in each department
 */
public class FindHighestPaidEmployeeInEachDepartment {
	public static void main(String[] args) {
		List<Employee> listEmp = Arrays.asList(new Employee("IT", 200.00), 
				new Employee("IT", 300.00),
				new Employee("IT", 400.00),
				new Employee("Ops", 500.00),
				new Employee("Ops", 600.00),
				new Employee("Admin", 800.00),
				new Employee("Admin", 1000.00));
		
		
		System.out.println("With Return as optional");
		
		Map<String, Optional<Employee>> map = listEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		System.out.println(map);
		
		System.out.println("Without Return as optional");
		
		Map<String, Employee> mapWithoutOptional = listEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, 
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), 
								Optional::get)));
		
		System.out.println(mapWithoutOptional);
		
	}
}



package stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 
 * using Streams and Collectors, find the highest-paid employee overall, but return the result as:
 * Where:

key = "HIGHEST_PAID"

value = the employee with maximum salary
 */

public class FindHighestPaidEmployeeOverall {

	public static void main(String[] args) {
		List<Employee> listEmp = Arrays.asList(new Employee("IT", 200.00), 
				new Employee("IT", 300.00),
				new Employee("IT", 400.00),
				new Employee("Ops", 500.00),
				new Employee("Ops", 600.00),
				new Employee("Ops", 700.00),
				new Employee("Admin", 800.00),
				new Employee("Admin", 1000.00),
				new Employee("Admin", 1100.00));
		
		Map<String, Employee> result = listEmp.stream().collect(Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), 
						opt -> opt.map(e -> Map.of("HIGHEST_PAID", e))
							      .orElseGet(Map::of)
									));
		
		System.out.println(result);
	}

}

package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * Find the average salary per department using Collectors only
 *
 */
public class FindAverageSalaryOfEachDepartment {
	public static void main(String[] args) {
		List<Employee> listEmp = Arrays.asList(new Employee("IT", 200.00), 
				new Employee("IT", 300.00),
				new Employee("IT", 400.00),
				new Employee("Ops", 500.00),
				new Employee("Ops", 600.00),
				new Employee("Admin", 800.00),
				new Employee("Admin", 1000.00));
		
		Map<String, Double> map = listEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(map);
	}
}


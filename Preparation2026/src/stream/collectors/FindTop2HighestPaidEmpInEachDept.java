package stream.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * For each department, find the top 2 highest-paid employees.
 *
 */
public class FindTop2HighestPaidEmpInEachDept {
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
		
		Map<String, List<Employee>> map = listEmp.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
										.limit(2).collect(Collectors.toList()))));
		
		System.out.println(map);

	}
}

package stream.collectors;

public class Employee {
	String department;
	double salary;
	public Employee(String department, double salary) {
		super();
		this.department = department;
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [department=" + department + ", salary=" + salary + "]";
	}
	
}

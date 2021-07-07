package app.core.templates;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import app.core.entities.Employee;
import app.core.entities.Job;

public class CompanyRestTemplate {

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {

		//initiate some date to work with                                                               
		Employee emp1 = new Employee(0, "Dan", 10_000D);
		emp1.addJob(new Job(0, "getEmployee function", LocalDate.now().plusDays(5)));
		emp1.addJob(new Job(0, "addJob function", LocalDate.now().plusDays(3)));
		Employee emp2 = new Employee(0, "Aor", 8_000D);
		emp2.addJob(new Job(0, "getJob function", LocalDate.now().plusDays(1)));
		emp2.addJob(new Job(0, "addEmployee function", LocalDate.now().plusDays(10)));
		Employee emp3 = new Employee(0, "Aor", 12_000D);
		emp3.addJob(new Job(0, "updateJob function", LocalDate.now().plusDays(2)));
		emp3.addJob(new Job(0, "updateEmployee function", LocalDate.now().plusDays(7)));
		
		// adding three employees with two jops each 
		System.out.println("____________ Adding Employee ______________");
		addEmployee(emp1);
		addEmployee(emp2);
		addEmployee(emp3);
		
		System.out.println("______________ One Employee _______________");
		getEmployee(1);
		System.out.println();

		System.out.println("______________ All Employees _______________");
		getEmployees();
		System.out.println();

		System.out.println("______________ All Employees By Name _______________");
		getEmployees("Aor");
		System.out.println();
		
		

	}

	private static void addEmployee(Employee employee) {
		String url = "http://localhost:8080/company/employee";
		employee = restTemplate.postForObject(url, employee, Employee.class);
		System.out.println("Employee added is: " + employee);
	}

	private static void getEmployee(long empId) {
		String url = "http://localhost:8080/company/employee?empId=" + empId;
		try {
			Employee employee = restTemplate.getForObject(url, Employee.class);
			System.out.println("Customer with id " + empId + " is: " + employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void getEmployees() {
		String url = "http://localhost:8080/company/employees";
		Employee[] employees = restTemplate.getForObject(url, Employee[].class);
		List<Employee> listEmps = Arrays.asList(employees);
		printList(listEmps);
	}

	private static void getEmployees(String name) {
		String url = "http://localhost:8080/company/employees/" + name;
		Employee[] employees = restTemplate.getForObject(url, Employee[].class);
		List<Employee> listEmps = Arrays.asList(employees);
		printList(listEmps);
	}

	private static void printList(List<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

}

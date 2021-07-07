package app.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Employee;
import app.core.entities.Job;
import app.core.services.CompanyService;

@SpringBootApplication
public class SprinCoreJpaApplication {

	public static void main(String[] args) {

		// Getting ApplicationContext for beans management
		ApplicationContext context = SpringApplication.run(SprinCoreJpaApplication.class, args);

		// Getting company service as a singleton bean
		CompanyService service = context.getBean(CompanyService.class);

		System.out.println(">>>> Program Starts");
		{
			System.out.println("_________________ AddingEmployeesWithJobs __________________");
			// add 2 employees with 2 jobs each
			Employee employee1 = new Employee("Eldar", 15_000D);
			Employee employee2 = new Employee("Dan", 9_000D);
			Employee employee3 = new Employee("Dan", 7_000D);

			employee1.addJob(new Job("AAA", LocalDate.now().plusDays(1)));
			employee1.addJob(new Job("BBB", LocalDate.now().plusDays(2)));

			employee2.addJob(new Job("CCC", LocalDate.now().plusDays(2)));
			employee2.addJob(new Job("DDD", LocalDate.now().plusDays(4)));

			service.addEmployee(employee1);
			service.addEmployee(employee2);
			service.addEmployee(employee3);
		}

		{
			System.out.println();
			// Fetching one employee with jobs
			try {
				System.out.println("_________________ getEmployeeById __________________");
				Employee employee;
				employee = service.getEmployee(1L);
				System.out.println(">>>> Employee with id=1 : " + employee);
				List<Job> jobs = service.getJobsByEmployeeId(employee.getId());
				System.out.println(">>>> Employee jobs: ");
				for (Job job : jobs) {
					System.out.println(">>>> " + job);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		{
			// Fetching employees by name
			try {
				System.out.println("________________ getEmployeesByName __________________");
				List<Employee> employees;
				employees = service.getEmployeesByName("Dan");
				for (Employee employee : employees) {
					System.out.println(">>>> " + employee);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		{
			// Fetching all employees
			try {
				System.out.println("________________ getAllEmployees __________________");
				List<Employee> employees;
				employees = service.getAllEmployees();
				for (Employee employee : employees) {
					System.out.println(">>>> " + employee);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		{
				// Fetching all jobs
			try {
				System.out.println("________________ getAllJobs __________________");
				List<Job> jobs = service.getAllJobs();
				for (Job job : jobs) {
					System.out.println(">>>> " + job);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		{
				// Fetching all jobs by endDate
			try {
				System.out.println("________________ getAllJobsBeforeEndDate __________________");
				List<Job> jobs = service.getAllJobsByEndDateLessThanEqual(LocalDate.now().plusDays(2));
				for (Job job : jobs) {
					System.out.println(">>>> " + job);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		{
			try {
				System.out.println("________________ getAllJobsBetweenDate __________________");
				List<Job> jobs = service.getAllJobsBetween(LocalDate.now().plusDays(2), LocalDate.now().plusDays(4));
				for (Job job : jobs) {
					System.out.println(">>>> " + job);
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(">>>> Program Ends");
	}

}

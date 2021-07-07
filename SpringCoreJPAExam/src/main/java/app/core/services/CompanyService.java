package app.core.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Employee;
import app.core.entities.Job;
import app.core.repositories.EmployeeRepository;
import app.core.repositories.JobRepository;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JobRepository jobRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(Long employeeID) throws Exception {
		Optional<Employee> optional = employeeRepository.findById(employeeID);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			return employee;
		}
		throw new Exception(">>> ServiceError: Employee is not found");
	}

	public List<Job> getJobsByEmployeeId(Long employeeID) throws Exception {
		getEmployee(employeeID);
		List<Job> jobs = jobRepository.getJobsByEmployeeId(employeeID);
		if (jobs.isEmpty()) {
			throw new Exception(">>> ServiceError: Employee has no jobs");
		}
		return jobs;
	}

	public List<Employee> getEmployeesByName(String name) throws Exception {
		List<Employee> employees = employeeRepository.findByName(name);
		if (employees.isEmpty()) {
			throw new Exception(">>> ServiceError: Employee with name = " + name + " does not exist");
		}
		return employees;
	}

	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			throw new Exception(">>> ServiceError: No employee were found");
		}
		return employees;
	}

	public List<Job> getAllJobs() throws Exception {
		List<Job> jobs = jobRepository.findAll();
		if (jobs.isEmpty()) {
			throw new Exception(">>> ServiceError: No jobs were found");
		}
		return jobs;
	}

	public List<Job> getAllJobsByEndDateLessThanEqual(LocalDate endDate) throws Exception {
		if (endDate.isBefore(LocalDate.now())) {
			throw new Exception(">>> ServiceError: Date = " + endDate + " is in the past");
		}
		List<Job> jobs = jobRepository.findByEndDateBefore(endDate);
		if (jobs.isEmpty()) {
			throw new Exception(">>> ServiceError: No jobs were found");
		}
		return jobs;
	}

	public List<Job> getAllJobsBetween(LocalDate start, LocalDate end) throws Exception {
		if (start.isBefore(LocalDate.now()) || end.isBefore(LocalDate.now())) {
			throw new Exception(">>> ServiceError: One of the dates is pass");
		}
		List<Job> jobs = jobRepository.findAllByEndDateBetween(start, end);
		if (jobs.isEmpty()) {
			throw new Exception(">>> ServiceError: No jobs were found");
		}
		return jobs;
	}
}

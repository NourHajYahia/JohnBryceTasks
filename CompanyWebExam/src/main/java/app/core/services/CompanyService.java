package app.core.services;

import java.sql.Date;
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
	private EmployeeRepository empRepo;
	@Autowired
	private JobRepository jobRepo;
	
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}
	
	public Employee getEmployee(long empId) throws Exception{
		Optional<Employee> optional = empRepo.findById(empId);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			return employee;
		}
		throw new Exception("Not Found: Employee with id = " + empId);
	}
	
	public List<Employee> getEmployees(String name){
		return empRepo.findEmployeeByName(name);
	}
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	public List<Job> getJobs(){
		return jobRepo.findAll();
	}

	public List<Job> getJobs(Date endDate){
		return jobRepo.findJobByEndDate(endDate);
	}
	
	public List<Job> getJobs(Date start, Date end){
		return jobRepo.findJobByEndDateBetween(start, end);
	}
}

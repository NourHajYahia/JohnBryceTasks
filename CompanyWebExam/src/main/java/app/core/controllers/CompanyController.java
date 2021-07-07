package app.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Employee;
import app.core.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@PostMapping("/employee")
	private Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@GetMapping("/employee")
	private Employee getEmployee(@RequestParam long empId) {
		try {
			return service.getEmployee(empId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}	
	}
	
	@GetMapping("/employees")
	private List<Employee> getEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/employees/{name}")
	private List<Employee> getEmployees(@PathVariable String name) {
		return service.getEmployees(name);
	}
	
	

}

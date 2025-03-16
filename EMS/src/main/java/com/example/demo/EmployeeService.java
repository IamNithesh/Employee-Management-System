package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private EmployeeInterface repository;

	public EmployeeService(EmployeeInterface repository) {
		this.repository = repository;
	}
	
	// Getting all employees
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	//Getting specific details 
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	//Add employee details
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}

}

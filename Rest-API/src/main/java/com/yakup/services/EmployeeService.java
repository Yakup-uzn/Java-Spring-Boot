package com.yakup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.yakup.model.Employee;
import com.yakup.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployeeList(){
		
		// 100 lerce satır kontroller yapıp öyle repository'e yollayacağız
		
		return employeeRepository.getAllEmployeeList() ;
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	
	public List<Employee> getEmployeeWithParams(String firstName,String lastName){
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
		
	}
	
	
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	
}

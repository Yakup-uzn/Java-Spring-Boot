package com.yakup.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yakup.model.Employee;
import com.yakup.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/rest/api/employee")

public class RestEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@GetMapping(path = "/list")
	public List<Employee> getAllEmployeeList(){		
		return employeeService.getAllEmployeeList();
	}
	
	
	
	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id",required = true) String id) {		
		return employeeService.getEmployeeById(id);	
	}
	
	
	
	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParam(@RequestParam(name ="firstName",required = false) String firstName,
	                                           @RequestParam(name ="lastName",required = false) String lastName) {
	    return employeeService.getEmployeeWithParams(firstName, lastName);
	}
	
	
	
	
	@PostMapping("/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		
		return employeeService.saveEmployee(newEmployee);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

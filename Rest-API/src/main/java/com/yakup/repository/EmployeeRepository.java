package com.yakup.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.yakup.model.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;
	
	public List<Employee> getAllEmployeeList(){
		
		return employeeList;
	}
	
	public Employee getEmployeeById(String id) {
		Employee firstEmployee = null;
		
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				firstEmployee = employee;
				break;
				
			}
		}
		return firstEmployee;
	}
	
	
	
	public List<Employee> getEmployeeWithParams(String firstName,String lastName){
		
		List<Employee> employeeWithParam = new ArrayList<>();
		
		if(firstName == null && lastName == null) {
			return employeeList;
		}
		
		
		for (Employee employee : employeeList) {
			
					if (firstName != null && lastName != null) {
						if (employee.getFirstName().equalsIgnoreCase(firstName)&& employee.getLastName().equalsIgnoreCase(lastName)) {
							employeeWithParam.add(employee);
						}
					}
					
					
					if (firstName != null && lastName == null) {
						if(employee.getFirstName().equalsIgnoreCase(firstName)) {
							employeeWithParam.add(employee);
						}
						
					}
					
					
					if (firstName == null && lastName != null) {
						if(employee.getLastName().equalsIgnoreCase(lastName)) {
							employeeWithParam.add(employee);
						}
						
					}
					
					
		}
		
		return employeeWithParam;
		
	}
	
	
	
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

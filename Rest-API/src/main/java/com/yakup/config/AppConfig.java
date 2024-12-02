package com.yakup.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.yakup.model.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public List<Employee> employeeList(){
	
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1", "yakup", "uzunoglu"));
		employeeList.add(new Employee("2", "yunus", "uzunoglu"));
		employeeList.add(new Employee("3", "yusuf", "uzunoglu"));
		employeeList.add(new Employee("4", "yiğit", "uzunoglu"));
		employeeList.add(new Employee("5", "sezgin", "uzunoglu"));
		employeeList.add(new Employee("6", "ayten", "uzunoglu"));
		
		return employeeList;
	
	
	}
}

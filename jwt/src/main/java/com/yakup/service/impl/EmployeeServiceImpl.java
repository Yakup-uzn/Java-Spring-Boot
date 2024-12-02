package com.yakup.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoDepartment;
import com.yakup.dto.DtoEmployee;
import com.yakup.model.Department;
import com.yakup.model.Employee;
import com.yakup.repository.EmployeeRepository;
import com.yakup.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository ; 

	@Override
	public DtoEmployee findEmployeeById(Long id) {
		DtoEmployee dtoEmployee  =new DtoEmployee();
		DtoDepartment dtoDepartment = new DtoDepartment();
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty()) {
			//Exception
			return null;
		}
		Employee employee = optional.get();
		Department department = employee.getDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		return dtoEmployee;
	}

	
}

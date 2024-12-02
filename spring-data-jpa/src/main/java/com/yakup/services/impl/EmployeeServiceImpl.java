package com.yakup.services.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoDepartment;
import com.yakup.dto.DtoEmployee;
import com.yakup.entites.Department;
import com.yakup.entites.Employee;
import com.yakup.exception.BaseException;
import com.yakup.exception.MessageType;
import com.yakup.exception.ErrorMesage;
import com.yakup.repository.EmployeeRepository;
import com.yakup.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> findAllEmployees(){
		
		List<DtoEmployee> dtoEmployeeList=new ArrayList<>();
		List<Employee> dBEmployees =employeeRepository.findAll();
		
		if (dBEmployees!=null && !dBEmployees.isEmpty()) {
			
			for (Employee employee : dBEmployees) {
				
				DtoEmployee dtoEmployee=new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getName()));
				dtoEmployeeList.add(dtoEmployee);
			}
			
			
			return dtoEmployeeList;
		}
		
		
		
		return null;
		
		
		
	}
	


	@Override
	public DtoEmployee findAllByIdEmployees(long id) {
		DtoEmployee dtoEmployee =new DtoEmployee();
		DtoDepartment dtoDepartment=new DtoDepartment();
		
		Optional<Employee> optional =employeeRepository.findById(id);
		if (optional.isEmpty()) {
			
			//hata fırlatmak
			throw new BaseException(new ErrorMesage(MessageType.NO_RECORD_EXIST,String.valueOf(id)));
		}
		
		
		
		Employee employee=optional.get();
		Department department=employee.getDepartment();
		
		BeanUtils.copyProperties(employee, dtoEmployee);
		BeanUtils.copyProperties(department, dtoDepartment);
		
		dtoEmployee.setDepartment(dtoDepartment);
		
		return dtoEmployee;
	}	
	
	
}

package com.yakup.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakup.controller.IEmployeeController;
import com.yakup.dto.DtoEmployee;
import com.yakup.entites.RootEntity;
import com.yakup.services.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController extends RestBaseController implements IEmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@Override
	@GetMapping("/list")
	public RootEntity<List<DtoEmployee>> findAllEmployees(){
          		
		return ok(employeeService.findAllEmployees());
	}

	@Override
	@GetMapping("/list/{id}")
	public RootEntity<DtoEmployee> findAllByIdEmployees(@PathVariable(name = "id") long id) {
		return ok(employeeService.findAllByIdEmployees(id));
	}




	
	
	
	
}

package com.yakup.services;

import java.util.List;

import com.yakup.dto.DtoEmployee;

public interface IEmployeeService {
	
	public List<DtoEmployee> findAllEmployees() ;

	public DtoEmployee findAllByIdEmployees(long id);



}

package com.yakup.controller;

import java.util.List;


import com.yakup.dto.DtoEmployee;
import com.yakup.entites.RootEntity;

public interface IEmployeeController {
	
	public RootEntity<List<DtoEmployee>> findAllEmployees();
	public RootEntity<DtoEmployee> findAllByIdEmployees(long id);

}

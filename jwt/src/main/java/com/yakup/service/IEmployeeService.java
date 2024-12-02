package com.yakup.service;

import com.yakup.dto.DtoEmployee;

public interface IEmployeeService {

	DtoEmployee findEmployeeById(Long id);
}

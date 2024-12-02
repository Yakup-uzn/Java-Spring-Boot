package com.yakup.controller;

import com.yakup.dto.DtoEmployee;

public interface IRestEmployeeController {

	public DtoEmployee findEmployeeById(Long id);
}

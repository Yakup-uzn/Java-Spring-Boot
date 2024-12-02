package com.yakup.controller;


import com.yakup.dto.DtoCustomer;


public interface ICustomerController {
        
	public DtoCustomer findCustomerById(long id);
	
}

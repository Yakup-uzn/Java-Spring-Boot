package com.yakup.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakup.controller.IAddressController;
import com.yakup.dto.DtoAddress;
import com.yakup.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddressController implements IAddressController{
	
	@Autowired
	private IAddressService addressService;
	
	@Override
	@GetMapping(path = "/list/{id}")
	public DtoAddress findAddressById(@PathVariable(name = "id") long id){
		return addressService.findAddressById(id);
	}

}

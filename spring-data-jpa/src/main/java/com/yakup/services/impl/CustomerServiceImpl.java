package com.yakup.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoAddress;
import com.yakup.dto.DtoCustomer;
import com.yakup.entites.Address;
import com.yakup.entites.Customer;
import com.yakup.repository.CustomerRepository;
import com.yakup.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public DtoCustomer findCustomerById(long id) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		
		Optional <Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Customer customer =optional.get();
		Address address =optional.get().getAddress();
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAddress);
        dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
		
		
		
		
	}

}

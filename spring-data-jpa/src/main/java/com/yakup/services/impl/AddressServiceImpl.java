package com.yakup.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoAddress;
import com.yakup.dto.DtoCustomer;
import com.yakup.entites.Address;
import com.yakup.entites.Customer;
import com.yakup.repository.AddressRepository;
import com.yakup.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressById(long id) {
		
		DtoAddress dtoaddress = new DtoAddress();
		DtoCustomer dtoCustomer = new DtoCustomer();
		
		Optional<Address> optional=addressRepository.findById(id);
		if (optional.isEmpty()) {
			return null;	
		}
		
		Address adress=optional.get();
		Customer customer= optional.get().getCustomer();
		BeanUtils.copyProperties(adress, dtoaddress);
		BeanUtils.copyProperties(customer, dtoCustomer);
		
		dtoaddress.setCustomer(dtoCustomer);	
		return dtoaddress;
		
	}
}

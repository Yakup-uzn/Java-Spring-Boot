package com.yakup.services;

import com.yakup.dto.DtoCustomer;

public interface ICustomerService {

	DtoCustomer findCustomerById(long id);

}

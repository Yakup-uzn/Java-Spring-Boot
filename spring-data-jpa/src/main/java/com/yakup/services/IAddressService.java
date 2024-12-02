package com.yakup.services;

import com.yakup.dto.DtoAddress;

public interface IAddressService {
	public DtoAddress findAddressById(long id);
}

package com.yakup.controller;

import com.yakup.dto.DtoAddress;

public interface IAddressController {
	public DtoAddress findAddressById(long id);
}

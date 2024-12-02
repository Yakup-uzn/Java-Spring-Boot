package com.yakup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddress {
	
	private long id;
	private String description;
	private DtoCustomer customer;

}

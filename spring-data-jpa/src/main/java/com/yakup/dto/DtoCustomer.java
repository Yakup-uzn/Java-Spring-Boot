package com.yakup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer {
 
	private long id;
	
	private String name;
	private DtoAddress address;
	
}

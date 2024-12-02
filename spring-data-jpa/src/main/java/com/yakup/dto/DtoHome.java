package com.yakup.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoHome {
	private long id;
	
	private BigDecimal price;
	private List<DtoRoom> rooms= new ArrayList<>();

}
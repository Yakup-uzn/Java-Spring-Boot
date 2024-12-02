package com.yakup.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {

	private long id;
	private String name;
    private DtoDepartment department;
    
	
}

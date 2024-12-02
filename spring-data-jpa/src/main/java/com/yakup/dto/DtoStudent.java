package com.yakup.dto;



import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
	
	private Integer idInteger;
	private String firstName;
    private String lastName;
    private List<DtoCourse> courses=new ArrayList<>();


}

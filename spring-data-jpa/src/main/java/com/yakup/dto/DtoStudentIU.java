package com.yakup.dto;


import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	
	    @NotEmpty(message = "Firstname alanı boş olamaz")
	    @Size(min = 3, max = 13, message = "Firstname 3 ile 13 karakter arasında olmalı")
	    private String firstName;
		
	    private String lastName;
	    
	    private Date birthOfDate;
	    
	    @Email(message = "Lütfen geçerli bir e-posta adresi giriniz")
	    private String email;
	    
	    @Size(min = 11, max = 11, message = "TCKN 11 karakter olmalı")
	    private String tckn;
    
    
    
}

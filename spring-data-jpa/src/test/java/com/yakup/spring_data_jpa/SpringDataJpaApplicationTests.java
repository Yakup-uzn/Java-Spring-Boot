package com.yakup.spring_data_jpa;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yakup.dto.DtoEmployee;
import com.yakup.services.IEmployeeService;
import com.yakup.starter.SpringDataJpaApplication;

@SpringBootTest(classes = {SpringDataJpaApplication.class})
class SpringDataJpaApplicationTests {

	@Autowired
	private IEmployeeService employeeService;
	
	
	
	
	@BeforeEach
	public void beforeEach() {
		//her testen önce çalışır
		//log,token üretme vb.
	}
	
	
	
	//ctrl+1
	@Test
	public void testFindEmployeeById() {
		DtoEmployee employee = employeeService.findAllByIdEmployees(3L);
		//assertEquals(2, 4);
		assertNotNull(employee);
		
	}
	
	@AfterEach
	public void afterEach() {	
		//her testen sonra çalışır
		//log temizle,mail at vb....
	}
}

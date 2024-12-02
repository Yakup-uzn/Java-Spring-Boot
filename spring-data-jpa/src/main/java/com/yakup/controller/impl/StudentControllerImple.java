package com.yakup.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yakup.controller.IStudentController;
import com.yakup.dto.DtoStudent;
import com.yakup.dto.DtoStudentIU;
import com.yakup.services.IStudentService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("rest/api/student")

public class StudentControllerImple implements IStudentController{
	
	@Autowired
	private IStudentService studentService;

	
	@Override
	@PostMapping(path = "/save")
	public DtoStudent saveStudent(@Valid @RequestBody DtoStudentIU dtoStudentIU) {
		return studentService.saveStudent(dtoStudentIU);
	}
	
	
	@Override
	@GetMapping(path = "/list")
	public List<DtoStudent> getAllStudents(){
		return studentService.getAllStudents();
	}


	@Override
	@GetMapping(path = "/list/{id}")
	public DtoStudent getStudentById(@PathVariable(name = "id")  Integer id) {
		return studentService.getStudentById(id);
	}


	@Override
	@DeleteMapping("/delete/{id}")
	public void deleteStudentById(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudentById(id);
	}
	
    @Override
	@PutMapping("/update/{id}")
	public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU dtoStudentIU ) {
		return studentService.updateStudent(id, dtoStudentIU);
	}






	
	

}

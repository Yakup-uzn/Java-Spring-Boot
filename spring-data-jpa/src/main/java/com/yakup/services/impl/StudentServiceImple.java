package com.yakup.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakup.dto.DtoCourse;
import com.yakup.dto.DtoStudent;
import com.yakup.dto.DtoStudentIU;
import com.yakup.entites.Course;
import com.yakup.entites.Student;
import com.yakup.repository.IStudentRepository;
import com.yakup.services.IStudentService;

@Service
public class StudentServiceImple implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		

		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		Student dbStudent= studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}
	
	public List<DtoStudent> getAllStudents(){
		List<DtoStudent> dtoList= new ArrayList<>();
		List<Student> studentList =studentRepository.findAll();
		
		for (Student student : studentList) {
			DtoStudent dto= new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		
        Optional<Student> optional= studentRepository.findById(id);
		if (!optional.isEmpty() && optional!=null) {
			DtoStudent dtoStudent=new DtoStudent();
			Student DbStudent=optional.get();
			BeanUtils.copyProperties(DbStudent, dtoStudent);
			
			if (DbStudent.getCourse()!=null && !DbStudent.getCourse().isEmpty()) {
				
				for (Course course : DbStudent.getCourse()) {
					DtoCourse dtoCourse=new DtoCourse();
					BeanUtils.copyProperties(course, dtoCourse);
					dtoStudent.getCourses().add(dtoCourse);
					
				}
				return dtoStudent;
			}
		}
		return null;
		
		
      
	}

	@Override
	public void deleteStudentById(Integer id) {
		Optional<Student> optional= studentRepository.findById(id);
		
		if (optional.isEmpty()) {
			studentRepository.delete(optional.get());
		}
		studentRepository.deleteById(id);
	}
	
	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
	    DtoStudent response = new DtoStudent();
	    
	    Optional<Student> optional = studentRepository.findById(id);
	    

	    if (optional.isPresent()) {

	        Student dbStudent = optional.get();
	        BeanUtils.copyProperties(dtoStudentIU, dbStudent);
	        Student updatedStudent = studentRepository.save(dbStudent);
	        BeanUtils.copyProperties(updatedStudent, response);
	        
	        return response;
	    }
	   	    return null;
	}

}













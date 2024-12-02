package com.yakup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yakup.entites.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
	
	//@Query anatasyonu ile kendi özel metotlarımızı çağırarak özel sorgular yazarız
	//HGL: sınıfın ismi ve değişken isimleri kullanıralak sorgular yazılır.(nativeQuery = false)
	//SQL tablo ismi ve tablo içerisindeki kolon isimleri kullanıralak sorgular yazılır.(nativeQuery = true)
	
	//@Query(value = "select * from student.student", nativeQuery = true)
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();

}

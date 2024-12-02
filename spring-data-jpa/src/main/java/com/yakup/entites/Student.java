package com.yakup.entites;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
    
    @Column(name = "firstName")
	private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birth_Of_Date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  // Form üzerinden tarih alırken
    private Date birthOfDate;
	
    private String email;
    private String tckn;
    
    @ManyToMany
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> course;
}

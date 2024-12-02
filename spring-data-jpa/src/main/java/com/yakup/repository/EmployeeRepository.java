package com.yakup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yakup.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

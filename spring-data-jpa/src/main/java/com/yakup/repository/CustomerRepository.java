package com.yakup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yakup.entites.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

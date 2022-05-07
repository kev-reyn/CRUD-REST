package com.example.crudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudrest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByName(String name);
	public List<Customer> findBySname(String sname);
}

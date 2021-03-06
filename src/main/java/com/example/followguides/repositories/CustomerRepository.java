package com.example.followguides.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.followguides.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
	
}

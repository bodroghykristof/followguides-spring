package com.example.followguides.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.followguides.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

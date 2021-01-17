package com.example.followguides.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.followguides.model.Customer;
import com.example.followguides.model.Greeting;
import com.example.followguides.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GetMapping()
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> find(@PathVariable Long id) {
		return customerRepository.findById(id);
	}
	
	@GetMapping("/search")
	public List<Customer> search(@RequestParam(value = "first", defaultValue = "") String firstName,
								@RequestParam(value = "last", defaultValue = "") String lastName) {
		
		if (firstName.equals("") && lastName.equals("")) return new ArrayList<>();
		else if (lastName.equals("")) return customerRepository.findByFirstName(firstName);
		else if (firstName.equals("")) return customerRepository.findByLastName(lastName);
		
		else {
			List<Customer> resultsByFirstName = customerRepository.findByFirstName(firstName);
			List<Customer> resultsByLastName = customerRepository.findByLastName(lastName);
			return resultsByFirstName.stream()
								.filter(element -> resultsByLastName.contains(element))
								.collect(Collectors.toList());		}
		
	}
	

}

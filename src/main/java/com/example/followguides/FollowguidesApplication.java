package com.example.followguides;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.followguides.model.Customer;
import com.example.followguides.repositories.CustomerRepository;

@SpringBootApplication
public class FollowguidesApplication {
	
	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FollowguidesApplication.class, args);
	}
	
	@PostConstruct
	private void initializeRepository() {
		customerRepository.save(new Customer("John", "Doe"));
		System.out.println("Post construct");
		System.out.println(customerRepository.findAll());
	}

}

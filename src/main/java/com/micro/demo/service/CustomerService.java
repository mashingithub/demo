package com.micro.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.micro.demo.CustomerRequest;
import com.micro.demo.domain.Customer;

@Component
public class CustomerService {
	@Autowired
	private CustomerRepository repository;

	
	public void saveCustomer(CustomerRequest customerReq) {
		Customer customer=new Customer(customerReq.firstName,customerReq.lastName,customerReq.age);
		repository.save(customer);
	}
	
	public Customer getByFirstName(String firstName){
		return repository.findByFirstName(firstName);
	}
}

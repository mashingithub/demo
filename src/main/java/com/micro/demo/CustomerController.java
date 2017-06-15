package com.micro.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.demo.domain.Customer;
import com.micro.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService service;
	
	 @RequestMapping(method = RequestMethod.GET)
	public Customer getByFirstName(@RequestParam("firstName") String firstName){
		return service.getByFirstName(firstName);
	}
	
	 @RequestMapping(method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveCustomer(@RequestBody CustomerRequest customer){
		service.saveCustomer(customer);
		return "SUCCESS";
	}

}

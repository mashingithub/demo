package com.micro.demo.domain;



import org.springframework.data.annotation.Id;

public class Customer {

	@Id
	public String id;

	public String firstName;
	public String lastName;
	public String age;

	public Customer() {
	}

	public Customer(String firstName, String lastName,String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age=age;
	}


}

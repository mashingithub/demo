package com.micro.demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerRequest {
	public String firstName;
	public String lastName;
	public String age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}

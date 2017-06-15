package com.micro.demo.domain;

public class Player {
	String name;
	String type;
	
	public Player() {
		super();
	}
	
	public Player(String name, String type) {
		this();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

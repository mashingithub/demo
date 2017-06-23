package com.micro.demo.domain;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Team {
	String name;
	String location;
	
	Set<Player> players;
	
	public Team() {
		super();
	
	}

	public Team(String name, String location, Set<Player> players) {
		this();
		this.name = name;
		this.location = location;
		this.players = players;
	}

	
	
}

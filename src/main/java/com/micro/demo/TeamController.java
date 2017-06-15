package com.micro.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.demo.domain.Player;
import com.micro.demo.domain.Team;
import com.micro.demo.service.CustomerService;

@RestController
public class TeamController {

	private Team team;
	@Autowired
	private CustomerService service;
	@PostConstruct
	public void init(){
		Set<Player> players=new HashSet<>();
		players.add(new Player("Kohli","Batsman"));
		players.add(new Player("Kumble","Coach"));
		
		team= new Team("RCB","Bangalore",players);
	}
	
	@RequestMapping("/team")
	public Team getTeam(){
		service.saveCustomers();
		return team;
	}
}

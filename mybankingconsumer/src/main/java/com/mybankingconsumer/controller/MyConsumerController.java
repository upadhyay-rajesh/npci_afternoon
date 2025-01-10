package com.mybankingconsumer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mybankingconsumer.dto.Employee;

@RestController
@RequestMapping("/api/v1/consumers")
public class MyConsumerController {
	
	@GetMapping
	public List<Employee> getAll(){
		RestTemplate rr=new RestTemplate();
		
		return rr.getForObject("http://localhost:10000/api/v1/employees", List.class);
	}

}

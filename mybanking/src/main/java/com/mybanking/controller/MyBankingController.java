package com.mybanking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybanking.entity.Employee;
import com.mybanking.service.BankingServiceInterface;

@RestController
public class MyBankingController {
	
	
	@Autowired
	private BankingServiceInterface bService;

	@GetMapping("displayAll")
	public List<Employee> getAll(){
		Employee e1=new Employee();
		e1.setName("Rajesh");
		e1.setPassword("abcd");
		e1.setEmail("abc@yahoo.com");
		e1.setAddress("Bangalore");
		
		List<Employee> ll=new ArrayList<Employee>();
		ll.add(e1);
		return ll;
	}
	
	@PostMapping("createRecord")
	public Employee create(@RequestBody Employee ee) {
		bService.createRecordService(ee);
		return ee;
	}
	
}


















package com.mybanking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybanking.entity.Employee;
import com.mybanking.service.BankingServiceInterface;

@RestController
@RequestMapping("/api/v1/employees")
public class MyBankingController {
	
	
	@Autowired
	private BankingServiceInterface bService;

	@GetMapping
	public List<Employee> getAll(){
		return bService.getAllService();
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee ee) {
		bService.createRecordService(ee);
		return ee;
	}
	
}


















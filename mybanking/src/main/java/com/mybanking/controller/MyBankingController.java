package com.mybanking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybanking.entity.Employee;
import com.mybanking.service.BankingServiceInterface;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/employees")
public class MyBankingController {
	
	
	@Autowired
	private BankingServiceInterface bService;

	
	@Operation(
	        summary = "Get all employees",
	        description = "Retrieve a list of all available employees",
	        responses = {
	            @ApiResponse(
	                responseCode = "200",
	                description = "List of employees",
	                content = @Content(mediaType = "application/json", 
	                                   schema = @Schema(implementation = Employee.class))
	            )
	        }
	    )
	
	@GetMapping
	public List<Employee> getAll(){
		return bService.getAllService();
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee ee) {
		bService.createRecordService(ee);
		return ee;
	}
	
	@PutMapping("/{empid}")
	public Employee edit(@RequestBody Employee emp,@PathVariable("empid") String empid) {
		emp.setEmail(empid);
		return bService.editProfileService(emp);
	}
	@DeleteMapping("/{empid}")
	public String delete(@PathVariable("empid") String empid) {
		
		return bService.deleteProfileService(empid);
	}
	
}


















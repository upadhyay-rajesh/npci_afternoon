package com.mybanking.service;

import java.util.List;

import com.mybanking.entity.Employee;

public interface BankingServiceInterface {

	void createRecordService(Employee ee);

	List<Employee> getAllService();

	Employee editProfileService(Employee emp);

	String deleteProfileService(String empid);

}

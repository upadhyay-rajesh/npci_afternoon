package com.mybanking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybanking.dao.MyBankDAOInterface;
import com.mybanking.entity.Employee;

@Service
@Transactional()
public class MyBankingService implements BankingServiceInterface{
	
	@Autowired
	private MyBankDAOInterface mDao;

	@Override
	public void createRecordService(Employee ee) {
		mDao.save(ee);
		
	}

	@Override
	public List<Employee> getAllService() {
		// TODO Auto-generated method stub
		return mDao.findAll();
	}

	@Override
	public Employee editProfileService(Employee emp) {
		
		mDao.saveAndFlush(emp);
		return emp;
	}

	@Override
	public String deleteProfileService(String empid) {
		mDao.deleteById(empid);
		return "record deleted";
	}

}

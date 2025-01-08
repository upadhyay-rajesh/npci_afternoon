package com.mybanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybanking.dao.MyBankDAOInterface;
import com.mybanking.entity.Employee;

@Service
@Transactional
public class MyBankingService implements BankingServiceInterface{
	
	@Autowired
	private MyBankDAOInterface mDao;

	@Override
	public void createRecordService(Employee ee) {
		mDao.save(ee);
		
	}

}

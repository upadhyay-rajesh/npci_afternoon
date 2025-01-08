package com.mybanking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mybanking.entity.Employee;

@Repository
public interface MyBankDAOInterface extends JpaRepository<Employee, String>{

}

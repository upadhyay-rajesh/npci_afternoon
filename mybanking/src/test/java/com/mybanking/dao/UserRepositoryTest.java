package com.mybanking.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mybanking.entity.Employee;
import com.mybanking.service.MyBankingService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest // Loads only JPA-related components
public class UserRepositoryTest {

	@Autowired
    private MyBankingService userService;
	@Autowired
    private MyBankDAOInterface userRepository;


    @Test
    public void testSaveUser() {
    	Employee user=new Employee();
        user.setName("Rajesh Upadhyay");
        user.setEmail("abc@yahoo.com");
        user.setAddress("Bangalore");
        user.setPassword("abcd");

        userService.createRecordService(user);

        // Verify user is saved in MySQL
        assertEquals("Rajesh Upadhyay", user.getName());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    public void testFindUserById() {
    	Employee user=new Employee();
        user.setName("Dhruva Upadhyay");
        user.setEmail("dhruva@yahoo.com");
        user.setAddress("Bangalore");
        user.setPassword("abcd");

        userService.createRecordService(user);

        Optional<Employee> retrievedUser = userRepository.findById(user.getEmail());
        assertTrue(retrievedUser.isPresent());
        assertEquals("Dhruva", retrievedUser.get().getName());
    }
}

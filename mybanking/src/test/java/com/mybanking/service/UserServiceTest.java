package com.mybanking.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mybanking.dao.MyBankDAOInterface;
import com.mybanking.entity.Employee;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private MyBankDAOInterface userRepository;

    @InjectMocks
    private MyBankingService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testFindAllUsers() {
    	Employee user=new Employee();
        user.setName("Rajesh Upadhyay");
        user.setEmail("abc@yahoo.com");
        user.setAddress("Bangalore");
        user.setPassword("abcd");
        
        Employee user1=new Employee();
        user1.setName("Dhruva Upadhyay");
        user1.setEmail("dhruva@yahoo.com");
        user1.setAddress("Bangalore");
        user1.setPassword("abcd");

        when(userRepository.findAll()).thenReturn(Arrays.asList(
                user,
                user1
        ));

        List<Employee> users = userService.getAllService();

        assertEquals(2, users.size());
        assertEquals("Rajesh Upadhyay", users.get(0).getName());
        assertEquals("Dhruva Upadhyay", users.get(1).getName());
    }

    @Test
    public void testSaveUser() {
    	Employee user1=new Employee();
        user1.setName("Sivangi Upadhyay");
        user1.setEmail("sh@yahoo.com");
        user1.setAddress("Bangalore");
        user1.setPassword("abcd");

        when(userRepository.save(user1)).thenReturn(user1);

         userService.createRecordService(user1);

        assertEquals("Shivangi Upadhyay", user1.getName());
        assertEquals("sh@yahoo.com", user1.getEmail());
    }
}


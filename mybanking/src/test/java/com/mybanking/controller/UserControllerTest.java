package com.mybanking.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mybanking.entity.Employee;
import com.mybanking.service.MyBankingService;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyBankingController.class) // Load only the Controller layer
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyBankingService userService;

    @Test
    public void testGetAllUsers() throws Exception {
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

        when(userService.getAllService()).thenReturn(Arrays.asList(
                user,
                user1
        ));


        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Rajesh"))
                .andExpect(jsonPath("$[1].name").value("Dhruva"));
    }

    
}

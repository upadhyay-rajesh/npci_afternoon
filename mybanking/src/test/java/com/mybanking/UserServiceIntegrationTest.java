package com.mybanking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.mybanking.dao.MyBankDAOInterface;
import com.mybanking.entity.Employee;
import com.mybanking.service.EmailNotificationService;
import com.mybanking.service.MyBankingService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest // Load the full application context
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Use real database
@ActiveProfiles("test") // Use test-specific properties
@Transactional // Rollback after each test
public class UserServiceIntegrationTest {

    @Autowired
    private MyBankingService userService;

    @Autowired
    private MyBankDAOInterface userRepository;

    @MockBean
    private EmailNotificationService emailNotificationService; // Example of a mocked dependency

    @Test
    public void testSaveUser() {
       Employee user=new Employee();
        user.setName("Rajesh Upadhyay");
        user.setEmail("abc@yahoo.com");
        user.setAddress("Bangalore");
        user.setPassword("abcd");

        // Mock external service
        doNothing().when(emailNotificationService).sendWelcomeEmail(user.getEmail());

        userService.createRecordService(user);

        // Verify user is saved in MySQL
        assertEquals("Rajesh Upadhyay", user.getName());
        assertEquals(1, userRepository.findAll().size());

        // Verify the mocked service was called
        verify(emailNotificationService, times(1)).sendWelcomeEmail(user.getEmail());
    }

    @Test
    public void testFindAllUsers() {
    	Employee user1 = new Employee();
        user1.setName("Alice");
        user1.setEmail("alice@example.com");
        userService.createRecordService(user1);

        Employee user2 = new Employee();
        user2.setName("Bob");
        user2.setEmail("bob@example.com");
        userService.createRecordService(user2);

        List<Employee> users = userService.getAllService();

        assertEquals(2, users.size());
    }
}

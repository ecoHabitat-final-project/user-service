package com.ecohabitat.user_service.services;

import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    private User testUser;
    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setName("test");
        testUser.setEmail("test@example.com");
        userRepository.save(testUser);
    }



    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Test find user id")
    void testGetUserById() {
        User user = userService.getUserById(1);
        assertNotNull(user);
    }

    @Test
    @DisplayName("Test get all users")
    void testGetUsers() {
        List<User> users = userService.getUsers();
        assertNotNull(users);
    }

    @Test
    @DisplayName("Test get user by email")
    void testEmail() {
        User user = userService.getUserByEmail("test@example.com");
        assertEquals("test@example.com", user.getEmail());
    }


}
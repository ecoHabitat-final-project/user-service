package com.ecohabitat.user_service.services;

import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
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


}
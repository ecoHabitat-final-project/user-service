package com.ecohabitat.user_service.mock;

import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.repositories.UserRepository;
import com.ecohabitat.user_service.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestMockito {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("Dany");
        testUser.setEmail("dany@mock.com");

    }

    @Test
    @DisplayName("Return user by id")
    void testGetUserById(){
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        User user = userService.getUserById(1L);
        assertNotNull(user);
        assertEquals("Dany", user.getName());
        verify(userRepository).findById(1L);

    }

    @Test
    @DisplayName("Return user by email")
    void testGetUserByEmail(){
        when(userRepository.findUserByEmail("dany@mock.com")).thenReturn(Optional.of(testUser));
        User user = userService.getUserByEmail("dany@mock.com");
        assertNotNull(user);
        assertEquals("dany@mock.com", user.getEmail());
        verify(userRepository).findUserByEmail("dany@mock.com");

    }

@Test
@DisplayName("Get all users")
    void testGetUsers(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(testUser));
        List<User> users = userService.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        //verify(userRepository,times(2)).findAll(); //2 llamadas a la repo
        //he refactorizado el méthod de userService.getUsers
        verify(userRepository.findAll());

}


    }

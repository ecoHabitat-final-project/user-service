package com.ecohabitat.user_service.mockMVC;

import com.ecohabitat.user_service.controllers.UserController;
import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;


@WebMvcTest(UserController.class)
public class UserMockMVC {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    private User testUser;

    @BeforeEach
    public void setup() {
        testUser = new User(1L, "Dany", "dany@mockmvc.com");
    }

    @Test
    @DisplayName("Get /api/user/{id}     Return user bu ID")
    void getUserById() throws Exception {
        given(userService.getUserById(1L)).willReturn(testUser);

        mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dany"))
                .andExpect(jsonPath("$.email").value("dany@mockmvc.com"));
    }
}


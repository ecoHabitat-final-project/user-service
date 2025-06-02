package com.ecohabitat.user_service.controllers;


import com.ecohabitat.user_service.dto.EmailDTO;
import com.ecohabitat.user_service.exceptions.UserNotFoundException;
import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        User userFound = userService.getUserById(id);
        return new ResponseEntity<>(userFound, HttpStatus.OK);
    }


    @PostMapping("")
    ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/update/{userId}")
    ResponseEntity<?> updateEmail(@PathVariable("userId") Long userId,
                                  @RequestBody EmailDTO emailDTO) {

        User updateUser = userService.updateMail(userId, emailDTO);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable("userId") long userId) {
       userService.deleteUser(userId);
        return new ResponseEntity<> ("Deleted User", HttpStatus.OK);
    }


}



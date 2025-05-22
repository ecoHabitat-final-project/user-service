package com.ecohabitat.user_service.controllers;


import com.ecohabitat.user_service.exceptions.UserNotFoundException;
import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("")
    List<User> getUsers(){return userService.getUsers();}

    @GetMapping("/{id}")
    //User getUserById(@PathVariable("id") int id){return userService.getUserById(id);}

    ResponseEntity<?> getUserById(@PathVariable("id") int id){
        try{
            User userFound= userService.getUserById(id);
            return new ResponseEntity(userFound, HttpStatus.OK);

        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}

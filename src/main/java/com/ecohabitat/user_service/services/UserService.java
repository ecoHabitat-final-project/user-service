package com.ecohabitat.user_service.services;

import com.ecohabitat.user_service.exceptions.UserNotFoundException;
import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User getUserById(long id) {
        Optional<User> userOptional= userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }else{
            throw new UserNotFoundException("User id " + id + " not found");
        }
    }
}

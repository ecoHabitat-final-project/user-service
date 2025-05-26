package com.ecohabitat.user_service.services;

import com.ecohabitat.user_service.dto.EmailDTO;
import com.ecohabitat.user_service.exceptions.UserNotFoundException;
import com.ecohabitat.user_service.exceptions.UsersNotFoundException;
import com.ecohabitat.user_service.models.User;
import com.ecohabitat.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(long id) {
        Optional<User> userOptional= userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }else{
            throw new UserNotFoundException("User id " + id + " not found");
        }
    }


    public List<User> getUsers() {
        if(userRepository.findAll().isEmpty()) {
            throw new UsersNotFoundException("User are empty");

        }else{
            return userRepository.findAll();
        }
    }

    public User getUserByEmail(String email) {

        Optional<User> userOptional= userRepository.findUserByEmail(email);
        if(userOptional.isPresent()) {
            return userOptional.get();
        }else{
            throw new UserNotFoundException("User mail " + email + " not found");
        }
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public User updateMail(Long userId, EmailDTO emailDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User id " + userId + " not found"));
        user.setEmail(emailDTO.getEmail());
        return userRepository.save(user);
    }

}

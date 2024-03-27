package com.example.newDatabase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newDatabase.Repository.UserRepository;
import com.example.newDatabase.entity.UserEntity;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
    
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }
    
    public boolean authenticateUser(String userName, String password) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
}

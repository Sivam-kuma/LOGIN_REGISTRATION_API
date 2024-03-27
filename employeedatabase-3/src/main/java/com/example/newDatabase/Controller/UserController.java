package com.example.newDatabase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.newDatabase.entity.UserEntity;
import com.example.newDatabase.service.UserServices;

@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        
        if (userServices.authenticateUser(userName, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        
        if (userServices.findByUsername(userName).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        } else {
            userServices.saveUser(user);
            return ResponseEntity.ok("User registered successfully");
        }
    }
}

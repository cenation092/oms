package com.assignment.oms.controller;

import com.assignment.oms.model.User;
import com.assignment.oms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public User SignUp( @RequestBody User newUser ){
        return userRepository.save(newUser);
    }
}

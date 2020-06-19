package com.assignment.oms.controller;

import com.assignment.oms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/user/{userId}")
    public void removeUser(@PathVariable Long userId ){
        userRepository.deleteById(userId);
    }

}

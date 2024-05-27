package com.example.springbooks.controller;

import com.example.springbooks.model.User; // Import User entity class
import com.example.springbooks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import List class

@RestController
@RequestMapping("/users") // Specify base URL for the controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable long userId){
        return userService.getUser(userId);
    }

    @GetMapping
    public List<User> getAllUsers(){ // Corrected method name to follow Java naming convention
        return userService.getAllUsers();
    }
}

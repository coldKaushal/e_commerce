package com.practice.e_commerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.e_commerce.model.User;
import com.practice.e_commerce.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@RequestBody User user){
        if (user.getUserId() == null || user.getUserId().isEmpty()) {
            return "Error: userId cannot be null or empty!";
        }
        System.out.println("Received User: " + user);
        try {
            userService.saveUser(user);
            return "Saved";
        } catch (Exception e) {
            System.out.println(e);
            return "Error Encountered";
        }
    }

    @GetMapping("/{Id}")
    public User getUserByID(@PathVariable String Id) {
        User user = userService.getUserById(Id).orElse(null);
        return user;

    }

    @GetMapping("/all")
    public Iterable<User> getAllUser(){
        return userService.getAllUser();

    }   
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    @DeleteMapping("/{Id}")
    public String deleteUser(@PathVariable String Id){
        return userService.deleteUserById(Id);
    }
    
}

package com.practice.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.e_commerce.model.User;
import com.practice.e_commerce.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public Iterable<User> getAllUser(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(String userId) {
        return userRepo.findById(userId);
    }

    public String deleteUserById(String userId){
        try {
            userRepo.deleteById(userId);
            return "Deleted";
        } catch (Exception e) {
            System.out.println(e);
            return "Uh-oh something went wrong while deleting";
            // TODO: handle exception
        }
    }
}

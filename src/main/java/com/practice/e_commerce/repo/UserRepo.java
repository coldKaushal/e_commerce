package com.practice.e_commerce.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.e_commerce.model.User;

@EnableScan
public interface UserRepo extends CrudRepository<User, String>{

}

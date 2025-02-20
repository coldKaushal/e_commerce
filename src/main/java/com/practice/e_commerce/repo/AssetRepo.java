package com.practice.e_commerce.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.practice.e_commerce.model.Asset;

@EnableScan
public interface AssetRepo extends CrudRepository<Asset, String>{

    
} 
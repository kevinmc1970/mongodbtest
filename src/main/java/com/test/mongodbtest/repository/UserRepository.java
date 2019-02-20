package com.test.mongodbtest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.mongodbtest.document.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	
	

}

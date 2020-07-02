package com.test.mongodbtest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.mongodbtest.document.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
	
	

}

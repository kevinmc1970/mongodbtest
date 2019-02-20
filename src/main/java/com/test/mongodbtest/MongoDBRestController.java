package com.test.mongodbtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.mongodbtest.document.User;
import com.test.mongodbtest.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class MongoDBRestController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
}

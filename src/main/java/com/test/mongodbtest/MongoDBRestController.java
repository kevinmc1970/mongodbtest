package com.test.mongodbtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
//		return userRepository.findAll();
	}
	
}

package com.test.mongodbtest.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.test.mongodbtest.document.User;
import com.test.mongodbtest.repository.UserRepository;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> userRepository.save(new User(1, "Peter", "Development", 100L));							
	}
	
	@Bean
	CommandLineRunner commandLineRunnerCheck(UserRepository userRepository) {
		System.out.println("output all of the users " + userRepository.findAll());
		return null;							
	}
}

package com.mcintech.interest.config;

import com.mcintech.interest.repository.InterestResultRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = InterestResultRepository.class)
@org.springframework.context.annotation.Configuration
public class Configuration {

}

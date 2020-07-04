package com.mcintech.interest.repository;

import com.mcintech.interest.document.InterestResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface InterestResultRepository extends MongoRepository<InterestResult, Integer>{

}

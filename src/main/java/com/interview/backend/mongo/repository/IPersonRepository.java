package com.interview.backend.mongo.repository;

import com.interview.backend.mongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends MongoRepository<Person, String> { }
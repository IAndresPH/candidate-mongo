package com.interview.backend.mongo.repository;


import com.interview.backend.mongo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends MongoRepository<Task, String> { }
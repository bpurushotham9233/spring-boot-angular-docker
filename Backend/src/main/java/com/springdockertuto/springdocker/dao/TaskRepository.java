package com.springdockertuto.springdocker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdockertuto.springdocker.model.TaskModel;
import com.springdockertuto.springdocker.model.UserModel;

public interface TaskRepository extends MongoRepository<TaskModel, String> {
	List<TaskModel> findByNameLike(String name);	
}
package com.springdockertuto.springdocker.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdockertuto.springdocker.model.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {
	Optional<UserModel> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
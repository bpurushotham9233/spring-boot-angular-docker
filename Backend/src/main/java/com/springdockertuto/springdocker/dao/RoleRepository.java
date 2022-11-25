package com.springdockertuto.springdocker.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springdockertuto.springdocker.model.ERole;
import com.springdockertuto.springdocker.model.RoleModel;

public interface RoleRepository extends MongoRepository<RoleModel, String> {
	Optional<RoleModel> findByName(ERole roleUser);
	
}
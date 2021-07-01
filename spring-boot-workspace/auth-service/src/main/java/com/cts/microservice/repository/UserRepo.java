package com.cts.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.microservice.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
}

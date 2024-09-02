package com.javatechie.spring.mockito.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.spring.mockito.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByAddress(String address);

}

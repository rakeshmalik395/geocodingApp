package com.geomap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geomap.model.User;

public interface UserLoginRepository extends JpaRepository<User, Integer>{

	List<User> getUserByEmailId(String emailId);

	
}

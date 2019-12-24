package com.geomap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geomap.model.Role;

public interface RoleLoginRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String roleName);



	

	

	

	
}

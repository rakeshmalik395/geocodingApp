package com.geomap.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.geomap.model.Address;

public interface MarkerAddressRepository extends JpaRepository<Address, Integer>{

	List<Address> findByUserId(@Valid Integer userId);

	





	
}

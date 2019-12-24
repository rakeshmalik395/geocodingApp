package com.geomap.repository;

import java.util.List;
import javax.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;


import com.geomap.model.Address;

public interface MarkerAddressRepository extends JpaRepository<Address, Integer>{

	List<Address> findByUserId(@Valid Integer userId);

	





	
}

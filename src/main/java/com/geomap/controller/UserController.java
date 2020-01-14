package com.geomap.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geomap.model.Address;
import com.geomap.service.UserMarkerService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMarkerService uMarkerService;
	private List<Address> umAddress;
	
	@PostMapping(value="/saveAddress",headers="Accept=application/json")
	public Address addLocationById(@Valid @RequestBody Address address)
	{
		//Address umAddress = uMarkerService.addMarkerById(address);
		Address umAddress=new Address();
		if(address.getUserId()!=2) 		
		{
			umAddress = uMarkerService.addMarkerById(address);
			umAddress.setRole("USER");
			umAddress.setStatusCode(200);
		}
		umAddress.setStatusCode(400);
		return umAddress;
		
		
	}
	
	@GetMapping(value="/getAddress/{userId}")
	public List<Address>getLocationById(@Valid @RequestBody Address address,@PathVariable(value = "userId") Integer userId)
	{
		
		if(userId!=2) 
		{
			 umAddress =uMarkerService.getMarkerById(userId);		
		}
		return umAddress;
	
	}
}

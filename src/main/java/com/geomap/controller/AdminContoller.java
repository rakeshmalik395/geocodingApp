package com.geomap.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.geomap.model.Address;
import com.geomap.service.AdminMarkerService;


@RestController
@RequestMapping("/admin")
public class AdminContoller {

	@Autowired
	private AdminMarkerService aMarkerService;
	
	
	@PostMapping(value="/saveAddress",headers="Accept=application/json")
	public Address addLocationById(@Valid @RequestBody Address address)
	{
		System.out.println("in save controller");
		System.out.println(address.getLatitude());
		
		Address mAddress = aMarkerService.addMarkerById(address);
		mAddress.setStatusCode(200);
		return mAddress;
	}
	
	
	@GetMapping(value="/getAddress/{userId}")
	public List <Address> getLocationById(@Valid @RequestBody Address address,@PathVariable(value = "userId") Integer userId)
	{
		List<Address> mAddress =aMarkerService.getMarkerById(userId);
		
		return mAddress;	
		
	}
	

	@PutMapping(value="/updateAddress")
	public List <Address> updateLocationById(@Valid @RequestBody Address address)
	{
		List<Address> mAddress = aMarkerService.updateMarkerByMarkerId(address);
		
		return mAddress;
	}
	
	
	@DeleteMapping(value="/deleteAddress")
	public List <Address> deleteLocationById(@Valid @RequestBody Address address)
	{
		List<Address> mAddress = aMarkerService.deleteMarkerById(address);
		
		return mAddress;
	}
	

}
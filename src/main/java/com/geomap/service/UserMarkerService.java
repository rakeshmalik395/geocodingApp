package com.geomap.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomap.model.Address;
import com.geomap.repository.MarkerAddressRepository;

@Service
public class UserMarkerService {
	
	@Autowired
	private MarkerAddressRepository mRepository;

	public Address addMarkerById(@Valid Address address) {
		Address umAddress = null;
		try {
			umAddress = mRepository.save(address);
			
			if(umAddress != null)
			{
				return umAddress;
			}
		}
		catch (Exception eq) {
			eq.printStackTrace();
		}
		umAddress.setStatusCode(400);
		
		return umAddress;
	}

	public List<Address> getMarkerById(Integer userId) {
	
		try
		{
			List<Address> addressList =mRepository.findByUserId(userId);
			
			return addressList;
		}
	
		catch(Exception ee)
		{
			ee.printStackTrace();
			
		}
		return null;
	}

	
}

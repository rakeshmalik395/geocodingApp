package com.geomap.service;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomap.model.Address;
import com.geomap.repository.MarkerAddressRepository;

@Service
public class AdminMarkerService {

	@Autowired
	private MarkerAddressRepository mRepository;
	
	
	public Address addMarkerById(Address address) {
		Address mAddress=null;
		System.out.println("in before try block");
			try
			{
				System.out.println("in try block");
				 mAddress = mRepository.save(address);
	
		if(mAddress !=null)
		{
			
			return mAddress;
		}
			}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("No Address Found");
		}
		
		mAddress.setStatusCode(400);
		
		return mAddress;
	}


	public List<Address> getMarkerById(@Valid Integer userId) {
		
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


	public List<Address> deleteMarkerById(@Valid Address address) {
		
		
		try
		{
			mRepository.deleteById(address.getMarkerId());
			List<Address> addressList =mRepository.findByUserId(address.getUserId());
			
			return addressList;
		}
		catch (Exception ew)
		{
			ew.printStackTrace();
		}
		return null;
	}


	public List<Address> updateMarkerByMarkerId(@Valid Address address) {
		
		try
		{
			
			
			mRepository.save(address);
			List<Address> addressList =mRepository.findByUserId(address.getUserId());
			
			return addressList;
		}
		catch (Exception ew)
		{
			ew.printStackTrace();
		}
		return null;
		
	}



		
}

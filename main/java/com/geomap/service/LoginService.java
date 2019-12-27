package com.geomap.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomap.model.Address;
import com.geomap.model.Role;
import com.geomap.model.User;
import com.geomap.repository.MarkerAddressRepository;
import com.geomap.repository.RoleLoginRepository;
import com.geomap.repository.UserLoginRepository;


@Service
public class LoginService {

	@Autowired
	private UserLoginRepository userRepository;
	
	@Autowired
	private RoleLoginRepository roleRepository;
	
	
	
	User userSuccess =new User();

	public User findUserByEmailId(@Valid User userLogin) {
		
		try
		{
			List<User> userList = userRepository.getUserByEmailId(userLogin.getEmailId());
		
			for(User user :userList)
			{
				
				if(user.getEmailId().equals(userLogin.getEmailId()) && user.getPassword().equals(userLogin.getPassword()))
					user.getRoles().isEmpty();
				System.out.println("Role..."+user.getRoles().isEmpty());
//				userSuccess.setEmailId(userLogin.getEmailId());	
//				userSuccess.setPassword(userLogin.getPassword());
//				userSuccess.setUserId(user.getUserId());
				return user;

			}
		
		}
		
	catch (Exception e) {
		System.out.println("User Not Found");
	}
		 return null;
}

	public User insertUser(@Valid User userLogin) {
		
		Role role = roleRepository.findByRoleName("USER");
		userLogin.setRoles((new HashSet<Role>(Arrays.asList(role))));
		
		return userRepository.save(userLogin);
		
					
	}


}
			
		
	




		
	
	
	
	


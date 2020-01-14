package com.geomap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import com.geomap.model.User;

import com.geomap.service.LoginService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private LoginService loginService;

	
	
	@PostMapping(value = "/userLogin" ,headers="Accept=application/json")
	public User getUserByEmailId( @RequestBody User userLogin, HttpSession session)
	{
		User uLogin= loginService.findUserByEmailId(userLogin);
		if(uLogin != null) {
			session.setAttribute("emailId", userLogin.getEmailId());
			session.setAttribute("password", userLogin.getPassword());
			session.setAttribute("Role", userLogin.getRoles());		
			System.out.println(session.getAttribute("emailId"));
			System.out.println(session.getAttribute("password"));
			System.out.println("session attribute set");
			uLogin.setPassword("null");
			System.out.println("G---"+uLogin.getGender());
			System.out.println("N---"+uLogin.getName());
			session.setMaxInactiveInterval(60);
			uLogin.setStatusCode(200);
			return (uLogin);
		}
		
		return (uLogin);
	}
	
	@PostMapping(value="/addUser",headers="Accept=application/json")
	 public User insertUser(@Valid @RequestBody User userLogin)
	{
		userLogin.setStatusCode(200);
			 return loginService.insertUser(userLogin);
	 }
	
	
	@GetMapping(value = "/logout")
    public User logout(HttpServletRequest session) 
    {
		
		System.out.println("logout");
        session.getSession().invalidate();
      User user = new User();
      user.setStatusCode(200);
       return user;
        
    }
	
}

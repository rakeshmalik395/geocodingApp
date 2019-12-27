package com.geomap.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="user_details")
public class User {

	@Id
	@Column(name="userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	//@NotNull
	@Column(name="name")
	private String name;
	
	//@NotNull
	@Column(name="emailid", unique = true, nullable = false,updatable = false)
	private String emailId;
	
	//@NotNull
	@Column(name="password")
	private String password;
	
	//@NotNull
	@Column(name="gender")
	private String gender;
	
	@Transient
	private int statusCode;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns =  @JoinColumn(name = "userid", unique=false),
            inverseJoinColumns = @JoinColumn(name = "roleId", unique=false,referencedColumnName = "roleId", columnDefinition = "int default 2") )
  
	private Set<Role> roles= new HashSet<>();


	




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public User(Integer userId, String name, String emailId, String password, String gender, int statusCode,
			Set<Role> roles) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.statusCode = statusCode;
		this.roles = roles;
	}




	


	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public int getStatusCode() {
		return statusCode;
	}




	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}




	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", gender=" + gender + ", statusCode=" + statusCode + ", roles=" + roles + "]";
	}





	
	
		
	
	
}

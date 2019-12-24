package com.geomap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="marker_id")
	private Integer markerId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
    private double longitude;
 
	@Column(name="user_id")
	private Integer userId;
	
	@Transient
	private String role;
	
	@Transient 
	private int StatusCode;



	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Address(Integer markerId, String address, double latitude, double longitude, Integer userId, String role,
			int statusCode) {
		super();
		this.markerId = markerId;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.userId = userId;
		this.role = role;
		this.StatusCode = statusCode;
	}








	public Integer getMarkerId() {
		return markerId;
	}



	public void setMarkerId(Integer markerId) {
		this.markerId = markerId;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public int getStatusCode() {
		return StatusCode;
	}



	public void setStatusCode(int statusCode) {
		this.StatusCode = statusCode;
	}



	@Override
	public String toString() {
		return "Address [markerId=" + markerId + ", address=" + address + ", latitude=" + latitude + ", longitude="
				+ longitude + ", userId=" + userId + ", role=" + role + ", StatusCode=" + StatusCode + "]";
	}




	
	
	
}

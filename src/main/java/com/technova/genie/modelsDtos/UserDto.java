package com.technova.genie.modelsDtos;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class UserDto {
	/**
	 * Define the userDto.
	 */
	
	private Long id;
	
    private String name;
	
    private String email;
	
    private String phone;
	
	private String address;
	
    private String password;
    
    public UserDto() {
    	
    }
    
    public UserDto(Long id, String name, String email, String phone, String address, String password) {
    	this.id = id;
    	this.name = name;
    	this.phone = phone;
    	this.address= address;
    	this.password = password;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
}

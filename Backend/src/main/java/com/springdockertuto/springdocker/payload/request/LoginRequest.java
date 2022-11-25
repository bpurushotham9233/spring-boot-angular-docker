package com.springdockertuto.springdocker.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String _user) {
		this.username = _user;
	}
	
	public void setPassword(String _pass) {
		this.password = _pass;
	}
}
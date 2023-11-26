package com.gfg.employeaap.response;

import jakarta.persistence.Column;

public class LoginResponse {
	private String username;
	private String password;
	

	public String getPassword() {
        return password;
    }
	
	public String getUsername() {
        return username;
    }


	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

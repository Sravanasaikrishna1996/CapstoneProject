package com.gfg.employeaap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOGIN")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name= "ID")
	 private Long id;
	



	public void setId(Long id) {
		this.id = id;
	}


	public Long getId() {
		return id;
	}


	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
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

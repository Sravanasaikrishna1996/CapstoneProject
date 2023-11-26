package com.gfg.employeaap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfg.employeaap.entity.Login;

public interface RegistrationRepo extends JpaRepository<Login, Long> {
	boolean existsByUsername(String username);
}

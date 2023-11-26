package com.gfg.employeaap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gfg.employeaap.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Long>  {
	 

	Login findByUsername(String username);

	boolean existsByUsername(String username);

	
}

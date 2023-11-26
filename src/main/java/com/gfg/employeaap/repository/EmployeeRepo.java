package com.gfg.employeaap.repository;

import com.gfg.employeaap.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	List<Employee> findBySubject(String subject);


}

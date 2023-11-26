package com.gfg.employeaap.controller;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.response.EmployeeResponse;
import com.gfg.employeaap.service.EmployeeNotFoundException;
import com.gfg.employeaap.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/Questions")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@GetMapping("/employees/{id}")
//	private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) throws EmployeeNotFoundException {
//		EmployeeResponse employee = employeeService.getEmployeeById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(employee);
//	}
	
	@GetMapping("/allQuestions")
	public List<Employee> getallQuestions()
	{		
		return employeeService.getallQuestions();
	}
	
	@GetMapping("/category/{subject}")
	public List<Employee> getEmployeesBySubject(@PathVariable String subject) {
	    return employeeService.getEmployeesBySubject(subject);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Employee q)
	{
		employeeService.addQuestion(q);
		return "success";
	}

	

}

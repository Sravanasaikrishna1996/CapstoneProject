package com.gfg.employeaap.service;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.repository.EmployeeRepo;
import com.gfg.employeaap.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper mapper;

	
//	public EmployeeResponse getEmployeeById(int id) throws EmployeeNotFoundException {
//        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
//
//        if (optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//            // Use your mapper to map Employee to EmployeeResponse
//            EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
//            return employeeResponse;
//        } else {
//            // Handle the case when the employee with the given ID is not found
//            // You can throw an exception, return a default response, or handle it as needed.
//            // For example:
//        	throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
//
//        }
//	}


	  
//Questions in Database




	public List<Employee> getallQuestions() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}


	public List<Employee> getEmployeesBySubject(String subject) {
	    return employeeRepo.findBySubject(subject);
	}


	public void addQuestion(Employee q) {
		employeeRepo.save(q);
		
	}





}

package com.gfg.employeaap.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gfg.employeaap.entity.Login;
import com.gfg.employeaap.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private ModelMapper mapper;
    


    public boolean authenticateUser(String username, String password) {
        // Perform authentication logic here
        Login login = loginRepo.findByUsername(username); // Use findByUsername
        if (login != null && login.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }



    public Login findByUsername(String username) {
        return loginRepo.findByUsername(username);
    }
    
    public boolean existsByUsername(String username)
    {
    	return loginRepo.existsByUsername(username);
    }
    
   
   
    public Login registerUser(Login login) throws RegistrationException {
        // Check if the username is already registered
    	
        if (loginRepo.existsByUsername(login.getUsername())) {
            throw new RegistrationException("Username is already taken");
        }

        // Add more validation logic here, e.g., password strength checks, email format, etc.

        // Save the user registration data to the database
        try {
            return loginRepo.save(login);
        } catch (Exception e) {
            throw new RegistrationException("Registration failed: " + e.getMessage());
        }
    }





	


}

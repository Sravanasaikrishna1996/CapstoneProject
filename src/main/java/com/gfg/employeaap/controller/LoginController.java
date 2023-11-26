package com.gfg.employeaap.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.entity.Login;
import com.gfg.employeaap.response.RegistrationResponse;
import com.gfg.employeaap.service.LoginService;
import com.gfg.employeaap.service.RegistrationException;

@CrossOrigin(origins = "http://localhost:4200") // Allow requests from http://localhost:4200
@RestController
@RequestMapping("/Login") // Changed the base URL mapping
public class LoginController {

    @Autowired
    private LoginService loginService;



    @GetMapping("/getLoginDetails")
    public Login getLoginDetails(@RequestParam String username) {
        return loginService.findByUsername(username);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Login login) {
        // Call the service method to perform login authentication
        boolean isAuthenticated = (boolean) loginService.authenticateUser(login.getUsername(), login.getPassword());

        if (isAuthenticated) {
            System.out.println("Login successful"); // Add this line for logging
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            System.out.println("Login failed"); // Add this line for logging
            return ResponseEntity.ok().body("{\"message\": \"Login failed\"}");
        }
    }
    
    @PostMapping("/register")
    
//    public ResponseEntity<String> registerUser(@RequestBody Login login) {
//        try {
//            Login registeredUser = loginService.registerUser(login);
//            return ResponseEntity.ok().body("{\"message\": \"Registration successful\"}");
//            //return ResponseEntity.status(HttpStatus.CREATED)
//            //    .body(new RegistrationResponse("Registration successful"));
//        } catch (RegistrationException e) {
//        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Registration failed\"}");
//            //return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//              //  .body(new RegistrationResponse("Registration failed: " + e.getMessage()));
//        }
//    }

    public ResponseEntity<Object> registerUser(@RequestBody Login login) {
        try {
            Login registeredUser = loginService.registerUser(login);
            System.out.println("Registration successful");
            return ResponseEntity.ok().body("{\"message\": \"Registration successful\"}");
            //return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
        	 System.out.println("Registration failed");
        	 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message\": \"Registration failed\"}");
        	  // Add this line for logging
        }
    }

}

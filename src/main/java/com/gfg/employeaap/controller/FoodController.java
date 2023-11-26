package com.gfg.employeaap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gfg.employeaap.entity.Food;
import com.gfg.employeaap.repository.FoodRepo;
import com.gfg.employeaap.service.FoodService;

@CrossOrigin(origins = "http://localhost:4200") // Allow requests from http://localhost:4200
@RestController
@RequestMapping("/api/foods")
public class FoodController {
	
	@Autowired
	private  FoodService foodservice;
	
	  @Autowired
	    private FoodRepo foodRepository;

	    @PostMapping
	    public ResponseEntity<Food> addFood(@RequestBody Food food) {
	        Food savedFood = foodRepository.save(food);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedFood);
	    }
	

}

package com.gfg.employeaap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfg.employeaap.entity.Food;
import com.gfg.employeaap.repository.FoodRepo;
import com.gfg.employeaap.repository.LoginRepo;

@Service

public class FoodService {

    @Autowired
    private FoodRepo foodrepo;
	
	public List<Food> getfood() {
		// TODO Auto-generated method stub
		return null;
	}

}

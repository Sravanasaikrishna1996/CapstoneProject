package com.gfg.employeaap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfg.employeaap.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {

}

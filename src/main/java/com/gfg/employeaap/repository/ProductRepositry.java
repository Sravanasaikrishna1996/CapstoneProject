package com.gfg.employeaap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfg.employeaap.entity.Product;



@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String query);

}

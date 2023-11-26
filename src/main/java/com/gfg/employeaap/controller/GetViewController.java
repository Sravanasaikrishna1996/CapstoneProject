package com.gfg.employeaap.controller;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.entity.Product;
import com.gfg.employeaap.repository.ProductRepositry;
import com.gfg.employeaap.service.ProductService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin(origins = "http://localhost:4200") 
@Controller
@RestController
@RequestMapping("/Foods")
public class GetViewController {

    @Autowired
    private ProductService productService;
    
    private static final Logger logger = LoggerFactory.getLogger(GetViewController.class);


    @GetMapping("/allFoods")
    public ResponseEntity<List<Product>> getallFoods() {
    	
        try {
            System.out.println("Food controller");
            List<Product> products = productService.getAllProduct();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();

            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
    @GetMapping("/filter/{id}")
    public ResponseEntity<Product> getFoodDetails(@PathVariable Long id) {
        Product food = productService.getFoodById(id);
        System.out.println("Filtering the Products in backend");

        try {
            if (id == null) {
                return ResponseEntity.notFound().build();
            }
 
            
            
            Product foodDetails = new Product();
            foodDetails.setId(food.getId());
            foodDetails.setName(food.getName());
            foodDetails.setDescription(food.getDescription());
            foodDetails.setPrice(food.getPrice());
            foodDetails.setImage(food.getImage());

            return ResponseEntity.ok(foodDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
 
    @GetMapping("/search/{query}")
    public ResponseEntity<List<Product>> searchItems(@PathVariable String query) {
    	  System.out.println("Searching the Products in backend");
        try {
            System.out.println("Searching the Products in backend");
            List<Product> searchResults = productService.searchItems(query);
            logger.info("Received search request with query: " + query);

            return ResponseEntity.ok(searchResults);
        } catch (Exception e) {
            String errorMessage = "Error occurred during search operation: " + e.getMessage();
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
    	
//    	return productService.searchItems(query);
//    
//}
    
    
    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        System.out.println("Loading image for food id: " + id);

        try {
            Product food = productService.getFoodById(id);

            if (food == null || food.getImage() == null) {
                System.out.println("Image not found for food id: " + id);
                return ResponseEntity.notFound().build();
            }

            byte[] imageBytes = food.getImage();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            System.out.println("Image loaded successfully for food id: " + id);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image for food id: " + id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    
}



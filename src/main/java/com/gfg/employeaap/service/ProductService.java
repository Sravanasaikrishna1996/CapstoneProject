package com.gfg.employeaap.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gfg.employeaap.entity.Employee;
import com.gfg.employeaap.entity.Product;
import com.gfg.employeaap.repository.ProductRepositry;

@Service
public class ProductService {
	@Autowired
	private ProductRepositry productRepo;
	
	public void saveProductToDB(MultipartFile file, String name, String description, int price) {
        Product product = new Product();

        // Clean the file name to prevent directory traversal attacks
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.contains("..")) {
            // Log a warning instead of using System.out.println
            System.out.println("Not a valid file");
            return; // or throw an exception if appropriate
        }

        try {
            // If you decide to store the image as a BLOB in the database
            product.setImage(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        productRepo.save(product);
    }
	 
	public List<Product> getAllProduct()
	{
		System.out.print("food service");
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    
    public Product getFoodById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
    public void changeProductPrice(Long id,int price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }

    public ProductService(ProductRepositry foodRepository) {
        this.productRepo = productRepo;
    }

    public List<Product> searchItems(String query) {
        // Replace this with your actual search logic using the repository
        return productRepo.findByNameContainingIgnoreCase(query);
    }
	
}

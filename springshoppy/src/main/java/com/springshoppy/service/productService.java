package com.springshoppy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springshoppy.model.product;
import com.springshoppy.repository.productRepository;

@Service
public class productService {

	//repository to communicate and configure the DB
	@Autowired
	private productRepository repo;
	//getting products and returning to controller
	public List<product> getAllProducts(){		
		List<product> productList=new ArrayList<>();
		repo.findAll().forEach(productList::add);
		return productList;
	}
	//adding product to DB
	public String addProduct(product p1) {
		repo.save(p1);
		return "successfully added!....";
	}
	//getting product if id is available
	public Optional<product> getProduct(int id) {
		return repo.findById(id);
	}
	//delete product by using id
	public String deleteProduct(int id) {
		
		repo.deleteById(id);
		return "Deleted Successfully";
	}
	
	public String addallProducts(List<product> pl)
	{
		repo.saveAll(pl);
		return "successfully added";
	}
	
	public product getProductByName(String productName) {
		return repo.findByProductName(productName);
	}
	
	public List<product> getProductsByPrice(int productPrice){
		return repo.findByProductPrice(productPrice);
	}
	
	
	
}

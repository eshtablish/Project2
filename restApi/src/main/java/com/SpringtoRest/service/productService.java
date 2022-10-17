package com.SpringtoRest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringtoRest.model.product;

@Service
public class productService {

	private List<product> productList=new ArrayList<>(Arrays.asList(
			
			new product(101,"Lenovo Laptop",55000,10),
			new product(102,"MSI Laptop",75000,10),
			new product(103,"Acer Predator Laptop",80000,10),
			new product(104,"Asus Tuf Gaming Laptop",45000,10),
			new product(105,"HP OMEN Laptop",85000,10),
			new product(106,"Dell Alienware Laptop",155000,10),
			new product(107,"MAC Laptop",170000,10)
			
			));
	//returning all products 
	public List<product> getAllProducts(){
		return productList;
	}
	//returning one specified product
	public product getProduct(int id) {
		return productList.stream()
					.filter(pro->pro.getProductId()==id).findFirst().get();
	}
	//adding new product
	public void addProduct(product p1) {
		productList.add(p1);
	}
	
	//to update product
		public void updateProduct(product p2, int id) {
			
			for(int i=0;i<productList.size();i++)
			{
				product p1=productList.get(i);
				
				if(p1.getProductId()==id) {
					productList.set(i, p2);
				}
			}
			
		}
		
		//to delete product
		public void deleteProduct(int id) {
			productList.removeIf(prod->(prod.getProductId()==id));
		}
		
}

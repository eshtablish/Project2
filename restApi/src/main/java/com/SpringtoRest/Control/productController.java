package com.SpringtoRest.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringtoRest.model.product;
import com.SpringtoRest.service.productService;

@RestController
public class productController {

	@Autowired	
	private productService service;
	//handling the request

	@RequestMapping("/hi")
	public String sayHello() {
		return "Hello user!...";
	}

	//controller to get all products

	@RequestMapping(method=RequestMethod.GET, value="/products")
	//processing the request
	public List<product> getProducts() {
		return service.getAllProducts();
	}
	
	//controller to get specified product
	@RequestMapping(method=RequestMethod.GET, value="/product/{id}")
	public product getProduct(@PathVariable int id) {
		return service.getProduct(id);
	}
	
	//controller to add data
	@RequestMapping(method=RequestMethod.POST, value="/product" )
	public void addProduct(@RequestBody product p1) {
		service.addProduct(p1);
	}
	
	//controller to update data
		@RequestMapping(method=RequestMethod.PUT, value="/product/{id}")
		public void updateProduct(@RequestBody product p2, @PathVariable int id) {
			service.updateProduct(p2, id);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/product/{id}")
		public void deleteProduct(@PathVariable int id){
		
			service.deleteProduct(id);
	
 }
}
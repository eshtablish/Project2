package com.usermgm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermgm.dto.userDTO;
import com.usermgm.exception.globalException;
import com.usermgm.model.user;
import com.usermgm.service.userService;

@RestController
@RequestMapping("/user")
public class userController {

	//dependency injection for service layer
	@Autowired
	private userService service;
	
	@GetMapping("/hello")
	public String helloUser(){
		
		
		return "Hello welcome to swagger";
		
	}
	
	//adding user to db
	@PostMapping("/add")
	public ResponseEntity<user> addUser(@RequestBody @Valid userDTO u1){
	
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.OK);
		
	}

	//retriving all users from db
	@GetMapping("/retrive")
	public ResponseEntity<List<user>> getUser(){
		
		
		return new ResponseEntity<>(service.getUser(),HttpStatus.ACCEPTED);
		
	}
	
	//deleting user from db
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<user> deleteUser(@PathVariable int id) throws globalException {
			
			return new ResponseEntity<>(service.deleteUser(id),HttpStatus.ACCEPTED);
		
		}
	
	//updating user details
	@PutMapping("/update")
	public ResponseEntity<user> updateUser(@RequestBody @Valid userDTO u1){
	
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.OK);
		
	}

	//retriving specific user details
	@GetMapping("/{id}")
	public ResponseEntity<user> getUser(@PathVariable int id) throws globalException{
		return new ResponseEntity<>(service.getUser(id),HttpStatus.OK);
	}
	
	

}

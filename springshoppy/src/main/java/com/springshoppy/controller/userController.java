package com.springshoppy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springshoppy.model.users;import com.springshoppy.model.login;
import com.springshoppy.service.userService;

@RestController
public class userController {

	@Autowired
	private userService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/createnewaccount")
	public String createNew(@RequestBody users u1) {
		
		return service.createNew(u1);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login")
	public String login(@RequestBody login l1) {
		return service.login(l1);
	}
	
	
	
	
	
	
	
}
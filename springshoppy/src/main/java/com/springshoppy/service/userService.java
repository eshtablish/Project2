package com.springshoppy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springshoppy.model.users;import com.springshoppy.model.login;
import com.springshoppy.repository.userRepository;

@Service
public class userService {

	@Autowired
	private userRepository userepo;
	
	public String createNew(users u1) {
		
		userepo.save(u1);
		return "successfully registered";
	}
	
	public String login(login l1) {
		
	users u2=userepo.findByUsername(l1.getUsername());
		if(u2!=null) {
			if(u2.getPassword().equals(l1.getPassword())) {
				return "Login Success";
			}
			else {
				return "wrong password";
			}
		}
		else {
			return "user not found";
		}
		
	}
}

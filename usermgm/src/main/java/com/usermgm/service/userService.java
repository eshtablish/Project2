package com.usermgm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermgm.dto.userDTO;
import com.usermgm.exception.globalException;
import com.usermgm.model.user;
import com.usermgm.repository.userRepository;

@Service
public class userService {

	
	//dependency injection for repository
	@Autowired
	private userRepository userepo;	

	
	//adding the new user which satisfies user validation
	public user addUser(userDTO u1) {
	
		user u2=user.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(),u1.getUserPassword());
		
		
		return userepo.save(u2);
		
	}
	
	//retriving all the users 
	public List<user> getUser(){
		return userepo.findAll();
	}
	
	
	//deleting the already existed user
	//if user is not existed we are throwing globalException
	public user deleteUser(int id) throws globalException  {
	
		user _u2=userepo.findByUserId(id);
		if(_u2!=null) {
			userepo.deleteById(id);
			return _u2;
		}
		else {
			throw new globalException("user not found!...");
		}
		
	}
	
	//updating user details
	public user updateUser(userDTO u1) {
		
		user u2=user.build(u1.getUserId(), u1.getUserName(), u1.getUserPhone(), u1.getUserEmail(),u1.getUserPassword());
		return userepo.save(u2);
	}
	
	
	//retriving details of specific user
	public user getUser(int userid) throws globalException
	{
		user _u1=userepo.findByUserId(userid);
		if(_u1!=null) {
			return _u1;
		}
		else {
			throw new globalException("user not found with userid "+userid);
		}
	}
	
	
	
}

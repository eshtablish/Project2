package com.theJail.dao;


import com.theJail.exception.GlobalException;
import com.theJail.model.user;

public interface theJaildao {

	public int registration(user u1)throws GlobalException;
	public user login(String username,String password)throws GlobalException;
	
}

package com.theJail.service;

import com.theJail.exception.GlobalException;
import com.theJail.model.user;

public interface userdashboard {

	public void dashboard(int uId) throws GlobalException;
	public void viewProfile();
	public void viewDueAmount();
	public void viewRoom();
	public void updatePhone() throws GlobalException;
	public void changePassword() throws GlobalException;
	
}

package com.theJail.service;

import java.util.List;

import com.theJail.exception.GlobalException;
import com.theJail.model.room;
import com.theJail.model.user;

public interface admindashboard {

	public void dashboard() throws GlobalException;
	public void viewRooms();
	public void viewUsers();
	public void createRoom() throws GlobalException;
	public void allotRoom();
	public void addDueAmount();
	public void payDueAmount();
	public void deleteUser();
	public void userInRoom();
	public void viewUserProfile();
	
}
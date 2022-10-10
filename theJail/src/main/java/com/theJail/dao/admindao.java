package com.theJail.dao;

import java.util.List;


import com.theJail.exception.GlobalException;
import com.theJail.model.room;
import com.theJail.model.user;

public interface admindao {

	public List<room> viewRooms();
	public List<user> viewUsers();
	public int createRoom(room r1) throws GlobalException;
	public int allotRoom(int uId,int rId);
	public int addDueAmount(int uId,int amount);
	public int payDueAmount(int uId,int amount);
	public int deleteUser(int uId);
	public List<user> userInRoom(int rId);
	public user viewUserProfile(int uId);
	
}
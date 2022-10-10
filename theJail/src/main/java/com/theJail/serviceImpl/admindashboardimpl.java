package com.theJail.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.theJail.dao.admindao;
import com.theJail.daoImpl.admindaoImpl;
import com.theJail.exception.GlobalException;
import com.theJail.model.room;
import com.theJail.model.user;
import com.theJail.service.admindashboard;

public class admindashboardimpl implements admindashboard {
	//creation of global objects
	static Logger log=Logger.getLogger(userdashboardImpl.class);
	static Scanner bs=new Scanner(System.in);
	static admindashboardimpl service=new admindashboardimpl();
	static admindao dao=new admindaoImpl();
	
	@Override
	public void dashboard() throws GlobalException {
		
		log.info("\t\t---------------------------welcome to Admin Dashboard--------------------");
	
		int op=0;
		while(op<10)
		{
			//reading choice of operation
		log.info("\tPress 1 for view rooms\t\tPress 2 for view users\n\tPress 3 for create room\t\tPress 4 for allot room\n\tPress 5 for addDue Amount \t\tPress 6 for payDue amount\n\tPress 7 for view user profile\t\tPress 8 for  delete user\n\tPress 9 for view users in a room");
		op=bs.nextInt();
		
		switch(op) {
		//calling methods as per choice
		case 1->service.viewRooms();
		case 2->service.viewUsers();
		case 3->service.createRoom();
		case 4->service.allotRoom();
		case 5->service.addDueAmount();
		case 6->service.payDueAmount();
		case 7->service.viewUserProfile();
		case 8->service.deleteUser();
		case 9->service.userInRoom();
		default->System.exit(0);
		}
		
		
		
		
		}
	}

	//view available rooms in db
	@Override
	public void viewRooms() {
		
		List<room> roomList=dao.viewRooms();
		for(room r:roomList) {
			log.info(r);
		}
	}
	//view all users 
	@Override
	public void viewUsers() {
		
		List<user> userList=dao.viewUsers();
		for(user u1:userList)
			log.info(u1);
		
	}

	
	//creating new room
	@Override
	public void createRoom() throws GlobalException {
		
		log.info("Enter room Id");
		int rId=bs.nextInt();
		log.info("Enter roomName");
		String rName=bs.next();
		log.info("Enter roomType");
		String rType=bs.next();
		
		room r1=new room();
		r1.setRoomId(rId);
		r1.setRoomName(rName);
		r1.setRoomType(rType);
		
		int st=dao.createRoom(r1);
		if(st==1) {
			log.info("Room added successfully");
		}
	}

	//allocate new room to the user
	@Override
	public void allotRoom() {
		log.info("Enter userId");
		int uid=bs.nextInt();
		log.info("Enter roomId");
		int rid=bs.nextInt();
		int st=dao.allotRoom(uid, rid);
		if(st==1) {
			log.info("room alloted!...");
		}
	}

	//add due amount to the user
	@Override
	public void addDueAmount() {
		log.info("Enter user id");
		int uid=bs.nextInt();
		log.info("Enter amount to add");
		int amount=bs.nextInt();
		int st=dao.addDueAmount(uid, amount);
		if(st==1) {
			log.info("fee updated");
		}
	}

	//pay the due amount
	@Override
	public void payDueAmount() {
		log.info("Enter user id");
		int uid=bs.nextInt();
		log.info("Enter amount to add");
		int amount=bs.nextInt();
		int st=dao.payDueAmount(uid, amount);
		if(st==1) {
			log.info("fee updated");
		}
		
	}
//delete the user
	@Override
	public void deleteUser() {
		log.info("Enter user id");
		int uid=bs.nextInt();
		int st=dao.deleteUser(uid);
	if(st==1) {
		log.info("deleted!....");
	}
	}

	//view users in a room
	@Override
	public void userInRoom() {
		log.info("Enter room Id");
		int rid=bs.nextInt();
		List<user> userList=dao.userInRoom(rid);
		for(user u1:userList)
			log.info(u1);
	}

	@Override
	public void viewUserProfile() {
		log.info("Enter userid");
		int uid=bs.nextInt();
		user u1=dao.viewUserProfile(uid);
		log.info(u1);
	}

}
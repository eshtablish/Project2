package com.theJail.serviceImpl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.theJail.dao.userdao;
import com.theJail.daoImpl.userdaoImpl;
import com.theJail.exception.GlobalException;
import com.theJail.model.room;
import com.theJail.model.user;
import com.theJail.service.userdashboard;


public class userdashboardImpl implements userdashboard{

	static Logger log=Logger.getLogger(userdashboardImpl.class);

	static int userId=0;
	static Scanner bs=new Scanner(System.in);
	static userdashboard udl=new userdashboardImpl();
	static userdao dao=new userdaoImpl();
	@Override
	public void dashboard(int uId) throws GlobalException {
		
		log.info("\t\t-----------------------welcome to user dashboard--------------------");
	
		userId=uId;
	int op=0;
	//selection of operation 
	while(op<6)
	{
		log.info("\n\tPress 1 for view profile\t\tPress 2 for View Due Amount\n\tPress 3 for view Room\t\tPress 4 for update Phone number\n\tPress 5 for change Password");
		op=bs.nextInt();		
		
		switch(op) {
		
		case 1->udl.viewProfile();
		
		case 2->udl.viewDueAmount();
		
		case 3->udl.viewRoom();
																	
		case 4->udl.updatePhone();
		
		case 5->udl.changePassword();
		
		}
	}
	
	}

	//view profile
	@Override
	public void viewProfile() {
		//calling dao viewprofile
		user u1=dao.viewProfile(userId);
		log.info(u1);
	}

	//view fee details
	@Override
	public void viewDueAmount() {
		int amount=dao.viewDueAmount(userId);
		log.info("Hello User your due amount is "+amount);
		
	}

	//view the room
	@Override
	public void viewRoom() {
		
		user u1=dao.viewProfile(userId);
		room r1=u1.getUserRoom();
		log.info("your room number is :"+r1.getRoomId()+" name is :"+r1.getRoomName()+" and it is"+r1.getRoomType()+" room");
	}

	//update phone number
	@Override
	public void updatePhone() throws GlobalException {
		log.info("Enter new Phone number");
		String phone=bs.next();
		int status=dao.updatePhone(userId, phone);
		if(status==1) {
			log.info("phone number updated!...");
		}
		else {
			throw new GlobalException("something went wrong");
		}
	}

	//to change password, have to enter current password correctly
	@Override
	public void changePassword() throws GlobalException {
		log.info("Enter current password");
		String oldpwd=bs.next();
		log.info("Enter New password");
		String newpwd=bs.next();
		int status=dao.changePassword(userId, oldpwd, newpwd);
		if(status==1) {
			log.info("password updated!...");
		}
		else {
			throw new GlobalException("something went wrong");
		}
	}
}
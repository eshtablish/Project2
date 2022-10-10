package com.theJail;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.theJail.dao.admindao;
import com.theJail.dao.theJaildao;
import com.theJail.dao.userdao;
import com.theJail.daoImpl.admindaoImpl;
import com.theJail.daoImpl.theJaildaoImpl;
import com.theJail.daoImpl.userdaoImpl;
import com.theJail.exception.GlobalException;
import com.theJail.model.room;
import com.theJail.model.user;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	@Test
	@Disabled
	public void testregistration() throws GlobalException {
		theJaildao dao=new theJaildaoImpl();
		user u1=new user();
		u1.setUserName("Sahana");
		u1.setUserPhone("9032165478");
		u1.setUserPassword("905906");
		u1.setUserAddress("electronic city");
		u1.setUserRole("student");
		user u2=new user();
		u2.setUserName("preethi");
		u2.setUserPhone("7019403038");
		u2.setUserPassword("phhh16");
		u2.setUserAddress("bangalore");
		u2.setUserRole("student");

		assertAll(
				()->assertEquals(1,dao.registration(u1)),
				()->assertThrows(GlobalException.class,()->dao.registration(u2))
				);
	}
	
	@Test
	@Disabled
	public void testpassword() {
		
		userdao dao=new userdaoImpl();
		
		assertEquals(-1,dao.changePassword(2, "phhh16", "phhh21"));
		
		
	}
	
	@Test
	
	public void testroom() throws GlobalException {
		
		admindao dao=new admindaoImpl();
		room r1=new room();
		r1.setRoomId(108);
		r1.setRoomName("sky");
		r1.setRoomType("non AC");
		
		room r2=new room();
		r2.setRoomId(104);
		r2.setRoomName("seshadri");
		r2.setRoomType("AC");
		
		assertAll(
		()->assertEquals(1,dao.createRoom(r1)),
		()->assertThrows(GlobalException.class,()->dao.createRoom(r2))
				);
		
		
		
	}
	
	
	
	
}
package com.usermgm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usermgm.model.user;

public interface userRepository extends JpaRepository<user,Integer> {


	//user defined query to retrive user basedon user id;
	@Query(value="select * from user where user_id=?1", nativeQuery=true)
	user findByUserId(int id);
	
	
}

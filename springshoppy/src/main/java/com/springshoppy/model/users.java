package com.springshoppy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class users {

	@Id
private int userId;
private String username;
private String password;
private String phone;
	
	
}

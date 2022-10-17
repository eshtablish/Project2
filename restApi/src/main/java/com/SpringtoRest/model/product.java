package com.SpringtoRest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class product {

	private int productId;
	private String productName;
	private int productPrice;
	private int productAvail;	
	
}

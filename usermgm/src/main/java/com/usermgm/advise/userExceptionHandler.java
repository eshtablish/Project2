package com.usermgm.advise;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermgm.exception.globalException;

@RestControllerAdvice
public class userExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	
	//handling exceptions of data validations
	public Map<String,String> handleException(MethodArgumentNotValidException ex) {
		
		Map<String,String> errorMap=new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(globalException.class)
	
	//handling global exception raised in service layer
	public Map<String,String> handleGlobalException(globalException gex){
		
		Map<String,String> errorMap=new HashMap<>();
	
		errorMap.put("Exception ",gex.getMessage());
			
		return errorMap;
	}
	
}

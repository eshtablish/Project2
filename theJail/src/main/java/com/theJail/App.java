package com.theJail;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.theJail.exception.GlobalException;
import com.theJail.service.loginregister;
import com.theJail.serviceImpl.loginregisterImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log=Logger.getLogger(App.class);
    public static void main( String[] args ) throws GlobalException
    {
    	Scanner bs=new Scanner(System.in);
    log.info("\t\t--------------------The Jail-----------------------");
    //selecting operation
    	log.info("\nPress 1 for Registration\nPress 2 for login");
    	int op=bs.nextInt();
    	loginregister logreg=new loginregisterImpl();
    	switch(op) {
    	case 1->logreg.registration();
    	case 2->logreg.login();
    	}
    }
}
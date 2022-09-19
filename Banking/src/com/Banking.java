package com;
import java.util.Scanner;

public class Banking {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BankingDbc Dbc=new BankingDbc();
		System.out.println("\t\t----Welcome to Anudip Bank-----");
		System.out.println("Select Operation: \n1 for Register account \n2 for Login");
		int op=sc.nextInt();
		// creating object of customer
		Customer c1=new Customer();
		switch(op) {
		
		case 1->{
			// Registering to bank account
			System.out.println("Enter details to Register");
			System.out.print("Enter Customer ID : ");
			int cid=sc.nextInt();
			System.out.print("Enter Customer Name : ");
			String cusname=sc.next();
			System.out.print("Enter Customer Password");
			String cuspass=sc.next();
			System.out.println("Enter Customer Phone");
			String cusphone=sc.next();
			System.out.print("Enter Customer minm Balance");
			int cusaccbal=sc.nextInt();
			c1.cid=cid;
			c1.cname=cusname;
			c1.cpassword=cuspass;
			c1.cphone=cusphone;
			c1.cactbal=cusaccbal;
			Dbc.connectDB();
			int res=Dbc.registerCustomer(c1);
			if(res==1) {
				System.out.println("Registered successfully");
			}
			else {
				System.out.println("User is already existed");
			}
		
		}
		case 2->{
			//login into user account
			System.out.println("Enter data to login");
			System.out.println("Enter Customer name");
			String cusname=sc.next();
			System.out.println("Enter Customer password");
			String cuspwd=sc.next();
			Dbc.connectDB();
			//if login success will get cid;
			int res=Dbc.login(cusname, cuspwd);
			if(res==0) {
				System.out.println("Invalid username or password");
			}
			else if(res==-1) {
				System.out.println("user not found, please register");
			}
			else {
				System.out.println("Login Success");
				int op2=0;
				//iterating the menu
				while(op2<5)
				{
				System.out.println("Select Operation: \n1 for Withdraw \n2 for deposit \n3 for check balance \n4 for pin change\n5 for logout");
				op2=sc.nextInt();
				switch(op2) {
				
				case 1->{
					//withdraw
					System.out.println("Enter amount to withdraw");
					int amount=sc.nextInt();
					int bal=Dbc.withdraw(res, amount);
					if(bal==-1) {
						System.out.println("Not enough balance");
					}
					else {
						System.out.println("Withdraw done, avaialble balance is: "+bal);
					}
				}
				// Deposit
				case 2->{
					System.out.println("Enter amount to deposit");
					int amount=sc.nextInt();
					int bal=Dbc.deposit(res, amount);
					System.out.println("Deposit done, the available balance is:"+bal);
					
				}
				// Balance 
				case 3->{
					System.out.println("Avaiable balance : "+Dbc.checkBalance(res));
				}
				// Changing passoword
				case 4->{
					System.out.println("Enter present password");
					String oldpwd=sc.next();
					System.out.println("Enter new password");
					String newpwd=sc.next();
					int count=Dbc.pinChange(res, oldpwd, newpwd);
				
					if(count==-1)
					{
						System.out.println("Password wrong");
					}
					else {
						System.out.println("Password changed successfully");
					}
				
				
				}
				
				default->System.out.println("Logout Successful");
				
				}
				
			}
		}
		
		}
		
		}
		sc.close();

	}

	}